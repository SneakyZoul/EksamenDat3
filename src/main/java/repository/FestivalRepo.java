package repository;

import dto.FestivalDTO;
import entities.Festival;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FestivalRepo {
    private static EntityManagerFactory emf;
    private static FestivalRepo instance;

    private FestivalRepo() {
    }


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

    public FestivalDTO creatFestival(FestivalDTO festivalDTO) {
        Festival festival = new Festival(festivalDTO.getName(), festivalDTO.getCity(), festivalDTO.getStartDate(), festivalDTO.getDuration());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(festival);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new FestivalDTO(festival);
    }



}
