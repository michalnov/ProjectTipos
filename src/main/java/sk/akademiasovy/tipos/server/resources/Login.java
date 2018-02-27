package sk.akademiasovy.tipos.server.resources;



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import sk.akademiasovy.tipos.server.Credentials;
import sk.akademiasovy.tipos.server.User;
import sk.akademiasovy.tipos.server.db.MySQL;


@Path("/auth")
public class Login {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkCredentials(Credentials credential){
        System.out.println(credential.getUsername());
        MySQL mySQL = new MySQL();
        User user=mySQL.getUser(credential.username, credential.password);

        if(user==null){
            return "{}";
        }
        else{
            return "{\"token\":\""+user.getToken()+"\"}";
        }

    }

    @POST
    @Path("/singin")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkNewUser(NewUser newUser){
        System.out.println(newUser.getUsername());
        MySQL mySQL = new MySQL();
        User user=mySQL.getUser(newUser.username, newUser.password);
        if(user==null){
            return "{}";
        }
        else{
            return "{\"token\":\""+user.getToken()+"\"}";
        }

    }
}
