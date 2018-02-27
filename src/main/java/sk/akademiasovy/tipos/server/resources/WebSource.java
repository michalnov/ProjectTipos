package sk.akademiasovy.tipos.server.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.*;
import java.util.*;

@Path("/web")
public class WebSource {

    @GET
    @Path("/html/{file}")
    @Produces({MediaType.TEXT_HTML})
    public String getResour(@PathParam("file") String file)
    {
        String output = "";
        String inFile = "webSource/html/"+file;
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

    @GET
    @Path("/{path}/{file}")
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
