//package Test;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import dto.GuestDTO;
//import dto.ShowDTO;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import repository.GuestRepo;
//import rest.GuestResource;
//import utils.EMF_Creator;
//
//import javax.persistence.EntityManagerFactory;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestRepo {
//
//
//    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
//
//    private static final GuestRepo facade = GuestRepo.getGuestRepo(EMF);
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    public void myTest() {
//
//    }
//}
