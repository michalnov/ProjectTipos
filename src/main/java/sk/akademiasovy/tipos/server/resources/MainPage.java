package sk.akademiasovy.tipos.server.resources;
import sk.akademiasovy.tipos.server.db.MySQL;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Path("/home")
public class MainPage {



    @GET
    @Path("/")
    @Produces({MediaType.TEXT_HTML})
    public String getHome()
    {
        String output = "";
        String inFile = "webSource/html/main.html";
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
}
