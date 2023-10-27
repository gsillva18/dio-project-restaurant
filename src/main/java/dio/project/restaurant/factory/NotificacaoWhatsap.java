package dio.project.restaurant.factory;

public class NotificacaoWhatsap implements Notificacao{

    @Override
    public void notificar(String mensagem) {
        System.out.println("[Enviando notificação Whatsap] - " + mensagem);
    }
}
