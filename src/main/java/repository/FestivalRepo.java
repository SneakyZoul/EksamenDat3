package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FestivalRepo {
    private static EntityManagerFactory emf;
    private static FestivalRepo instance;

    private FestivalRepo(){}



    public static FestivalRepo getFestivalRepo(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FestivalRepo();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
