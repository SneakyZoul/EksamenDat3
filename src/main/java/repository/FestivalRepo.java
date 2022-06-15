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

    public FestivalDTO updateFestival(FestivalDTO festivalDTO) {
        EntityManager em = getEntityManager();
        Festival festival = em.find(Festival.class, festivalDTO.getId());
        if (festival == null) System.out.println("no Festival found");
        festival.setName(festivalDTO.getName());
        festival.setCity(festivalDTO.getCity());
        festival.setDuration(festivalDTO.getDuration());
        festival.setStartDate(festivalDTO.getStartDate());
        em.getTransaction().begin();
        em.merge(festival);
        em.getTransaction().commit();

        return new FestivalDTO(festival);
    }


}
