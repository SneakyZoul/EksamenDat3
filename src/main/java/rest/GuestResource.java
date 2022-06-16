package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.GuestDTO;
import dto.ShowDTO;
import repository.GuestRepo;
import repository.ShowRepo;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/guest")
public class GuestResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final GuestRepo facade = GuestRepo.getGuestRepo(EMF);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello Geust\"}";
    }


    @GET
   @RolesAllowed("admin")
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGuests() {
        List<GuestDTO> guestDTOList = facade.getAllGuests();
        if (guestDTOList == null) return Response.status(404).build();

        return Response
                .ok()
                .entity(gson.toJson(guestDTOList))
                .build();
    }

    @PUT
    @Path("/signup/{guestID}/{showID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response signUpToShow(@PathParam("guestID") int guestID, @PathParam("showID") int showID) {
        ShowDTO update = facade.signGuestToShow(guestID, showID);
        return Response
                .ok()
                .entity(gson.toJson(update))
                .build();
    }

    @POST
    @RolesAllowed("admin")
    @Path("/createguest")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response creatShow(String content) {
        GuestDTO guestDTO = gson.fromJson(content, GuestDTO.class);
        GuestDTO guestDTO1 = facade.creatGuest(guestDTO);
        return Response
                .ok()
                .entity(gson.toJson(guestDTO1))
                .build();
    }

    @GET
    @Path("/shows/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response seeAllShowsSignedToGuest(@PathParam("id") int id) {
        List<ShowDTO> showDTOs = facade.ShowAllShowsAssignedToo(id);
        return Response
                .ok()
                .entity(gson.toJson(showDTOs))
                .build();
    }

}
