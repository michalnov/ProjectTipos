package sk.akademiasovy.tipos.server.resources;



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import sk.akademiasovy.tipos.server.db.MySQL;


@Path("/auth")
public class Login {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkCredentials(Credentials credential){
        System.out.println(credential.getLogin());
        MySQL mySQL = new MySQL();
        User user=mySQL.getUser(credential.getLogin(), credential.getPassword());

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
    public String createUser(NewUser newUser){
        System.out.println(newUser.getlogin());
        MySQL mySQL = new MySQL();
        User user=mySQL.createNewUser(newUser);
        if(user==null){
            return "{}";
        }
        else{
            return "{\"token\":\""+user.getToken()+"\"}";
        }

    }

    @POST
    @Path("/formcontroll")
    @Produces(MediaType.APPLICATION_JSON)
    public String createUser(NewUser newUser){
        System.out.println(newUser.getlogin());
        MySQL mySQL = new MySQL();
        User user=mySQL.createNewUser(newUser);
        if(user==null){
            return "{}";
        }
        else{
            return "{\"token\":\""+user.getToken()+"\"}";
        }

    }


}
