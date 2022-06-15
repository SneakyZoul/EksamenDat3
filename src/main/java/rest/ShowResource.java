package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ShowDTO;
import repository.ShowRepo;
import utils.EMF_Creator;

import javax.persistence.Column;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("show")
public class ShowResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final ShowRepo facade = ShowRepo.getShowRepo(EMF);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello Shower\"}";
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShows() {
        List<ShowDTO> showDTOList = facade.getAllShows();
        if (showDTOList == null) return Response.status(404).build();
        return Response
                .ok()
                .entity(gson.toJson(showDTOList))
                .build();
    }
//til at lave en guest
    @POST
    @Path("/createshow")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response creatShow(String content) {
        ShowDTO showDTO = gson.fromJson(content, ShowDTO.class);
        ShowDTO showDTO1 = facade.creatAShow(showDTO);
        return Response
                .ok()
                .entity(gson.toJson(showDTO1))
                .build();
    }

    @DELETE
    @Path("/deleteshow/{showId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteShow(@PathParam("showId") int showId) {
        facade.deleteShow(showId);
        return Response
                .ok()
                .entity("Deleted")
                .build();
    }

}

