package sk.akademiasovy.tipos.server.resources;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Path("/home")
public class Home {

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

}
