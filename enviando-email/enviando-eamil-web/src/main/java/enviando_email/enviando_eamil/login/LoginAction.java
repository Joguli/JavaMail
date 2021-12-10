package enviando_email.enviando_eamil.login;

import br.com.dsfnet.extarch.action.LoginBaseAction;
import br.com.dsfnet.extarch.type.SistemaDsfType;
import br.com.jarch.annotation.JArchViewScoped;

@JArchViewScoped
public class LoginAction extends LoginBaseAction {

    @Override
    public String identificadorSistema() {
        //FIXME: Adicionar o enumerado correto da aplicação
    	return SistemaDsfType.DSF_ADMFIS.name();
    }

}
