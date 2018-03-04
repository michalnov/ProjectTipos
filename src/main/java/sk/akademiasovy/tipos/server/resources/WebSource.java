package sk.akademiasovy.tipos.server.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.*;
import java.util.*;

@Path("/webSource")
public class WebSource {

    @GET
    @Path("/html/{file}")
    @Produces({MediaType.TEXT_HTML})
    public String getHtml(@PathParam("file") String file)
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
    @Path("/css/{file}")
    @Produces({MediaType.TEXT_HTML})
    public String getCss(@PathParam("file") String file)
    {
        String output = "";
        String inFile = "webSource/css/"+file;
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
    @Path("/js/{file}")
    @Produces({MediaType.TEXT_HTML})
    public String getJS(@PathParam("file") String file)
    {
        String output = "";
        String inFile = "webSource/js/"+file;
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
    @Path("/script/{file}")
    @Produces({MediaType.TEXT_HTML})
    public String getscript(@PathParam("file") String file)
    {
        String output = "";
        String inFile = "webSource/script/"+file;
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
