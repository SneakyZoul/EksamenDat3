package repository;

import dto.ShowDTO;
import entities.Show;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShowRepo {
    private static EntityManagerFactory emf;
    private static ShowRepo instance;

    private ShowRepo() {
    }


    public static ShowRepo getShowRepo(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ShowRepo();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<ShowDTO> getAllShows() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Show> query = em.createQuery("SELECT s FROM Show s", Show.class);
            List<Show> shows = query.getResultList();
            return ShowDTO.getDtos(shows);
        } finally {
            em.close();
        }
    }

    public ShowDTO creatAShow(ShowDTO showDTO) {
        Show show = new Show(showDTO.getName(), showDTO.getDuration(), showDTO.getLocation(), showDTO.getStartDate(), showDTO.getStartTime());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(show);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return new ShowDTO(show);
    }

    public void deleteShow(int id) {
        EntityManager em = getEntityManager();
        try {
            Show show = em.find(Show.class, id);
            if (show == null) System.out.println("no show found");
            em.getTransaction().begin();
            em.remove(show);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


}
