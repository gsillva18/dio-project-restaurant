package dio.project.restaurant.factory;

public class NotificacaoSms implements Notificacao{

    @Override
    public void notificar(String mensagem) {
        System.out.println("[Enviando notificação SMS] - " + mensagem);
    }
}

