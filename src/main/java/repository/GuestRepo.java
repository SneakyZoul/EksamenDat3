package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class GuestRepo {
    private static EntityManagerFactory emf;
    private static GuestRepo instance;

    private GuestRepo(){}



    public static GuestRepo getGuestRepo(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GuestRepo();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
