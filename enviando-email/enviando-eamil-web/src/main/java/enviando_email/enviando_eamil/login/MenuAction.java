package enviando_email.enviando_eamil.login;

import br.com.dsfnet.extarch.action.MenuBaseAction;
import br.com.dsfnet.extarch.type.SistemaDsfType;
import br.com.jarch.annotation.JArchViewScoped;

@JArchViewScoped
public class MenuAction extends MenuBaseAction {

    @Override
    public String identificadorSistema() {
        //FIXME: Adicionar o enumerado correto da aplicação
        return SistemaDsfType.DSF_ADMFIS.name();
    }

}