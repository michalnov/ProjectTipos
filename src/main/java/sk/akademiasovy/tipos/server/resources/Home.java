package sk.akademiasovy.tipos.server.resources;

import sk.akademiasovy.tipos.server.db.MySQL;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Path("/login")
public class Home {


    @POST
    @Path("/auth/login")
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
    @Path("/auth/singin")
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

    @GET
    @Path("/")
    @Produces({MediaType.TEXT_HTML})
    public String getHome()
    {
        String output = "";
        String inFile = "webSource/html/login.html";
        try {
            File input = new File(inFile);
            Scanner prepared = new Scanner(input);
            while (prepared.hasNextLine())
            {
                output += prepared.nextLine();
                output += "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            output = "Something went wrong :(";
        }
        finally {
            return output;
        }
    }

    @GET
    @Path("/webSource/{path}/{file}")
    @Produces({MediaType.TEXT_PLAIN})
    public String getResour(@PathParam("path") String source, @PathParam("file") String file)
    {
        String output = "";
        String inFile = "webSource/"+source+"/"+file;
        try {
            File input = new File(inFile);
            Scanner prepared = new Scanner(input);
            while (prepared.hasNextLine())
            {
                output += prepared.nextLine();
                output += "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            output = "File "+ file + " not found.";
        }
        finally {
            return output;
        }
    }

    @POST
    @Path("/auth/controll")
    @Produces({MediaType.APPLICATION_JSON})
    public Response isValid(ControlCredentials controlCredentials)
    {
        String res = "";
        try {
            MySQL mySQL = new MySQL();
            if (mySQL.controllToken(controlCredentials.getLogin(),controlCredentials.getToken()))
            {

            }
            else
            {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        }
        catch (Exception e)
        {
            res = "{\"msg\":\""+e+"\"}";
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        finally {
            return Response.ok().build();
        }
    }
}
