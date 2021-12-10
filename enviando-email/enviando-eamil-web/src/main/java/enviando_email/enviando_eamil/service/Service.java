package enviando_email.enviando_eamil.service;

import br.com.jarch.model.IUser;
import br.com.jarch.model.MultiTenant;
import br.com.jarch.model.UserInformation;

import javax.enterprise.inject.spi.CDI;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/")
public class Service {

    @Path("sample/{id}")
    @POST
    public Response sample(@HeaderParam("idMultiTenant") Long idMultiTenant, @HeaderParam("idUser") Long idUser, @PathParam("id") Long id) {
        try {
            startContext(idMultiTenant, idUser);

            // execute your action

            return getResponseOk();
        } catch (Exception ex) {
            return getResponseError(ex);
        }
    }

    private void startContext(Long idMultiTenant, Long idUsuario) {
        MultiTenant multiTenant = CDI.current().select(MultiTenant.class).get();
        multiTenant.set(idMultiTenant);

        UserInformation userInformation = CDI.current().select(UserInformation.class).get();
        if (!userInformation.exists()) {
            IUser user = getUsuario(idUsuario);
            userInformation.set(user);
        }
    }

    private Response getResponseOk() {
        return getResponseOk(null);
    }

    private Response getResponseOk(Object entity) {
        return Response
                .status(Response.Status.OK)
                .entity(entity)
                .build();
    }

    private Response getResponseError(Exception ex) {
        ex.printStackTrace();
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ex.getMessage())
                .build();
    }

    private IUser getUsuario(Long idUser) {
        return new IUser() {
            @Override
            public Long getId() {
                return idUser;
            }

            @Override
            public void setId(Long id) {

            }

            @Override
            public String getLogin() {
                return null;
            }

            @Override
            public void setLogin(String login) {

            }

            @Override
            public String getNome() {
                return null;
            }

            @Override
            public void setNome(String nome) {

            }

            @Override
            public String getSenha() {
                return null;
            }

            @Override
            public void setSenha(String senha) {

            }

            @Override
            public List<String> getGrupo() {
                return null;
            }

            @Override
            public void setGrupo(List<String> grupos) {

            }

            @Override
            public Date getUltimoAcesso() {
                return null;
            }

            @Override
            public void setUltimoAcesso(Date ultimoAcesso) {

            }

            @Override
            public String getUltimoAcessoEm() {
                return null;
            }

            @Override
            public boolean senhaValida(String senha) {
                return false;
            }
        };
    }
}