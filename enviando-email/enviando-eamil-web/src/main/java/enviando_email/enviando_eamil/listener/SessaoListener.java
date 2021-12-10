
package enviando_email.enviando_eamil.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessaoListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    	//
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    	//
    }

}
