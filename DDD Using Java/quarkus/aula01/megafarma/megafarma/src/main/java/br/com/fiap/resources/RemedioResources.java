package br.com.fiap.resources;

import br.com.fiap.bo.RemedioBO;
import br.com.fiap.to.RemedioTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/megafarma")
public class RemedioResources {
    private RemedioBO remedioBO = new RemedioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<RemedioTO> resultado = remedioBO.findAll();
        Response.ResponseBuilder response = null;

        if (resultado != null){
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
}
