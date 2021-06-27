package webservices;

import domain.Item;
import domain.ItemManager;
import domain.Verzameling;
import domain.VerzamelingManager;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;

@Path("/item")
public class ItemResource {
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItem(@FormParam("verzameling") String verzameling,
                               @FormParam("naam") String naam,
                               @FormParam("soort") String soort,
                               @FormParam("aantal") int aantal) {
        if (VerzamelingManager.getInstance().addItem(verzameling,naam, soort, aantal)) {
            Item result = VerzamelingManager.getInstance().getItemByName(naam);
            if (result != null) {
                return Response.ok(result).build();
            }
            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("message", "could not add knikker for some unknown reason")).build();
        }
        return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("message", "could not add knikker")).build();
    }
    @GET
    @Produces("application/json")
    public Response getItems() {
        return Response.ok(VerzamelingManager.getInstance().getAlleItems()).build();
    }
//    @RolesAllowed("eigenaar")
    @DELETE
    @Path("{naam}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("naam") String naam){
        return VerzamelingManager.getInstance().removeItem(naam)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
    @PUT
    @Path("{naam}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateItem(@PathParam("naam") String naam, @FormParam("soort") String soort,@FormParam("aantal") int aantal){
        Item item = VerzamelingManager.getInstance().updateItem(new Item(naam, soort, aantal));
        if(item==null) return Response.status(Response.Status.EXPECTATION_FAILED).entity(new AbstractMap.SimpleEntry<>("error","error")).build();
        return Response.ok(VerzamelingManager.getInstance().getItemByName(naam)).build();
    }
}
