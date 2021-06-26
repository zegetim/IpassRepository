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
        if (ItemManager.getInstance().addItem(verzameling,naam, soort, aantal)) {
            Item result = ItemManager.getInstance().getItemByName(naam);
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
        return Response.ok(ItemManager.getInstance().getAlleItems()).build();
    }
    @DELETE
//    @RolesAllowed("eigenaar")
    @Path("{naam}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteKnikker(@PathParam("naam") String naam){
        return ItemManager.getInstance().removeItem(naam)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
