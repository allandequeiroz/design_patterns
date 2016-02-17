package rest;

import model.Product;
import service.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("product")
public class ProductEndPoint {

    @Inject
    private ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(){
        List<Product> products = productService.findAll();
        if(products.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).entity("No produces were found").build();
        }else{
            return Response.ok().entity(products).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id")Long id){
        Product product = productService.findById(id);
        if(product == null){
            return Response.status(Response.Status.NOT_FOUND).entity(product).build();
        }else{
            return Response.ok().entity(product).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(Product product){
        try{
            productService.save(product);
            return Response.ok().entity("Saved sucessfully").build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id")Long id){
        try{
            productService.remove(id);
            return Response.ok().entity("Removed sucessfully").build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Product product){
        try{
            productService.merge(product);
            return Response.ok().entity("Updated successfully").build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
