package enviando_email.enviando_eamil.bpm.delegate;

import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.validation.ValidationException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public abstract class BaseDelegate implements JavaDelegate {

    private static boolean isStatusOk(Response response) {
        return response.getStatus() >= 200
                && response.getStatus() < 300;
    }

    protected void validResponse(Response response) {
        if (!isStatusOk(response)) {
            String messageErro = response.readEntity(String.class);
            throw new ValidationException(messageErro);
        }
    }

    protected WebTarget getWebTarget() {
        String url = System.getProperty("${rootArtifact}.URL.SERVIDOR", "http://localhost:8080/${rootArtifact}");

        System.out.println("URL ${rootArtifact}: " + url);

        return ClientBuilder
                .newClient()
                .target(url);
    }
}