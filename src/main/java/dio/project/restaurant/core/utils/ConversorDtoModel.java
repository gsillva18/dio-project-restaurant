package dio.project.restaurant.core.utils;

import dio.project.restaurant.dto.BebidaDto;
import dio.project.restaurant.dto.FormaPagamentoDto;
import dio.project.restaurant.dto.MesaDto;
import dio.project.restaurant.dto.PratoDto;
import dio.project.restaurant.model.Bebida;
import dio.project.restaurant.model.FormaPagamento;
import dio.project.restaurant.model.Mesa;
import dio.project.restaurant.model.Prato;

public class ConversorDtoModel {

    public static Bebida converter(BebidaDto dto){
        Bebida bebida = new Bebida();
        bebida.setNome(dto.getNome());
        bebida.setValor(dto.getValor());

        return bebida;
    }

    public static Prato converter(PratoDto dto){
        Prato prato = new Prato();
        prato.setNome(dto.getNome());
        prato.setValor(dto.getValor());

        return prato;
    }

    public static FormaPagamento converter(FormaPagamentoDto dto){
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setNome(dto.getNome());

        return formaPagamento;
    }

    public static Mesa converter(MesaDto dto){
        Mesa mesa = new Mesa();
        mesa.setNumero(dto.getNumero());
        mesa.setQuantidadeLugares(dto.getQuantidadeLugares());

        return mesa;
    }

}
