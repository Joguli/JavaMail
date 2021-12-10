package enviando_email.enviando_eamil.login;

import br.com.dsfnet.extarch.action.LoginCertificadoDigitalBaseAction;
import br.com.dsfnet.extarch.type.SistemaDsfType;
import br.com.jarch.annotation.JArchSessionScoped;

@JArchSessionScoped
public class LoginCertificadoDigitalAction extends LoginCertificadoDigitalBaseAction {

	@Override
	public String identificadorSistema() {
		//FIXME: Adicionar o enumerado correto da aplicação
		return SistemaDsfType.DSF_ADMFIS.name();
	}
}