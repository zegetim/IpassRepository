package webservices;

import domain.Verzameling;
import domain.VerzamelingManager;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;

@Path("/verzameling")
public class VerzamelingResource {
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVerzameling(@FormParam("naamVerzameling") String naamVerzameling) {
        if (VerzamelingManager.getInstance().addVerzameling(naamVerzameling)){
            Verzameling result = VerzamelingManager.getInstance().getNaamVerzameling(naamVerzameling);
            if(result!=null){
                return Response.ok(result).build();
            }
            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("message", "Kan verzameling niet toevoegen")).build();
        }

        return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("message", "Kan verzameling niet toevoegen")).build();
    }
    @GET
    @Produces("application/json")
    public Response getVerzamelingen() {
        return Response.ok(VerzamelingManager.getInstance().getAlleVerzamelingen()).build();
    }
//    @GET
//    @Path("{naam}")
//    @Produces("application/json")
//    public String getCollectietest(@PathParam("naam") String naam) {
//        JsonObjectBuilder job = Json.createObjectBuilder();
//        Verzameling a = VerzamelingManager.getInstance().getNaamVerzameling(naam);
//        job.add("naam:", a.getNaamVerzameling());
//        return job.build().toString();
//    }
}
