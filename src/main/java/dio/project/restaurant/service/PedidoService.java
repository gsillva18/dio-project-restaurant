package dio.project.restaurant.service;

import dio.project.restaurant.core.enums.TipoNotificacao;
import dio.project.restaurant.dto.ConcluirPedidoDto;
import dio.project.restaurant.dto.RealizarPedidoDto;
import dio.project.restaurant.factory.FabricaNotificacao;
import dio.project.restaurant.model.FormaPagamento;
import dio.project.restaurant.model.Pedido;
import dio.project.restaurant.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Com as anotações @Autowired e @Service se fazem uso dos padrões de projeto Singleton e Strategy
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;
    @Autowired
    private MesaService mesaService;
    @Autowired
    private FormaPagamentoService formaPagamentoService;
    @Autowired
    private FabricaNotificacao fabricaNotificacao;

    public void realizarPedido(RealizarPedidoDto dto) throws Exception{

        //verificar se tem pedido aberto para a mesa em questão
        //senão criar um pedido
        Pedido pedido = repository.buscarPedidoAberto(dto.getNumeroMesa()).orElse(new Pedido());
//        Pedido pedido = new Pedido();

        //adiciona a lista de pratos ao pedido
        pedido.setPratos(dto.getPratos());

        //adiciona a lista de bebidas ao pedido
        pedido.setBebidas(dto.getBebidas());

        //buscar mesa e adicionar mesa ao pedido
        pedido.setMesa(mesaService.buscarMesa(dto.getNumeroMesa()));

        //data e hora feito o pedido
        pedido.setDataHora(LocalDateTime.now());

        //salvar pedido no banco
        repository.save(pedido);

    }

    public void concluirPedido(ConcluirPedidoDto dto) throws Exception{
        //buscar pedido
        Pedido pedido = repository.findById(dto.getIdPedido()).orElseThrow(()-> new Exception("Pedido não encontrado"));

        //buscar forma de pagamento
        FormaPagamento formaPagamento = formaPagamentoService.buscarFormaPagamento(dto.getIdFormaPagamento());

        //pegar valor total a pagar
        BigDecimal valorTotal = pedido.valorTotal();

        //aplicar desconto
        valorTotal.subtract(dto.getDesconto());

        //gerar comprovante
        System.out.println("[COMPROVANTE GERADO COM SUCESSO]");

        //enviando notificacao
        fabricaNotificacao.getNotificacao(dto.getNumeroCelular().contains("+") ?
                TipoNotificacao.WHATSAP:TipoNotificacao.SMS).notificar("Pagamento realizado");

        //fechar pedido
        pedido.setAberto(false);

        //adicionando forma de pagamento ao pedido
        pedido.setFormaPagamento(formaPagamento);

        //salvar no banco
        repository.save(pedido);

    }

    public BigDecimal valorTotalPagar(Integer idPedido) throws Exception{

        //buscar pedido
        Pedido pedido = repository.findById(idPedido).orElseThrow(()-> new Exception("Pedido não encontrado"));

        return pedido.valorTotal();
    }

    public List<Pedido> buscarPedidos(){
        return repository.findAll();
    }
}
