package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import repository.FestivalRepo;
import repository.GuestRepo;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/festival")
public class FestivalResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final FestivalRepo facade = FestivalRepo.getFestivalRepo(EMF);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

//festival
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello Festival\"}";
    }


}
