package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.FestivalDTO;
import repository.FestivalRepo;
import repository.GuestRepo;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @GET
    @Path("/createfestival")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFestival(String container){
        FestivalDTO festivalDTO = gson.fromJson(container,FestivalDTO.class);
        FestivalDTO festivalDTO1 = facade.creatFestival(festivalDTO);
        return Response
                .ok()
                .entity(gson.toJson(festivalDTO1))
                .build();
    }
    @PUT
    @Path("/edit/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFestival(String content){

        FestivalDTO festivalDTO = gson.fromJson(content,FestivalDTO.class);
        FestivalDTO festivalDTO1 = facade.updateFestival(festivalDTO);
        return Response
                .ok()
                .entity(gson.toJson(festivalDTO1))
                .build();

    }

}
