package enviando_email.enviando_eamil.listener;

import br.com.jarch.util.LogUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextoListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LogUtils.warning("INICIO APLICACAO");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LogUtils.warning("FIM APLICACAO");
    }
}
