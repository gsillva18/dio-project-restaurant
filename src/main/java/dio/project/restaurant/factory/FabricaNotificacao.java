package dio.project.restaurant.factory;

import dio.project.restaurant.core.enums.TipoNotificacao;
import org.springframework.stereotype.Component;

/**
 * Nas classes deste pacote foi implementado o padrão de projeto factory method
 */
@Component
public class FabricaNotificacao {

    public Notificacao getNotificacao(TipoNotificacao tipoNotificacao){

        if (tipoNotificacao == TipoNotificacao.SMS){
            return new NotificacaoSms();
        }else{
            return new NotificacaoWhatsap();
        }
    }

}
