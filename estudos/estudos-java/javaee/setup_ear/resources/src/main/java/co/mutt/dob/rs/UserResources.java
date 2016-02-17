package co.mutt.dob.rs;

import co.mutt.dob.infra.Resources;
import co.mutt.dob.model.User;
import co.mutt.dob.repository.user.UserServiceLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;

/**
 * Created by camilamacedo on 30/09/14.
 */
@Path("user")
@Stateless
public class UserResources implements Serializable{

    @EJB
    private UserServiceLocal consumidorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> get(){
        return consumidorService.listUsers();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(@Valid User user){
        try {
            consumidorService.saveUser(user);
        } catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
                    Resources.getMessage("global.internal.server.error", e.getMessage())).build();
        }
        return Response.status(Response.Status.OK).entity(
                Resources.getMessage("user.put.ok")).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(User user){
        try {
            consumidorService.removeUser(user);
        } catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
                    Resources.getMessage("global.internal.server.error", e.getMessage())).build();
        }
        return Response.status(Response.Status.OK).entity(
                Resources.getMessage("user.delete.ok")).build();
    }
}
