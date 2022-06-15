package repository;

import dto.GuestDTO;
import dto.ShowDTO;
import entities.Guest;
import entities.Show;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class GuestRepo {
    private static EntityManagerFactory emf;
    private static GuestRepo instance;

    private GuestRepo() {
    }


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


    public List<GuestDTO> getAllGuests() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Guest> query = em.createQuery("SELECT g FROM Guest g", Guest.class);
            List<Guest> guests = query.getResultList();
            return GuestDTO.getDtos(guests);
        } finally {
            em.close();
        }
    }

    public GuestDTO creatGuest(GuestDTO guestDTO) {
        Guest guest = new Guest(guestDTO.getName(), guestDTO.getPhone(), guestDTO.getEmail(), guestDTO.getStatus());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(guest);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new GuestDTO(guest);
    }

    public ShowDTO signGuestToShow(int guestID, int showID) {
        EntityManager em = getEntityManager();
        try {
            Show show = em.find(Show.class, showID);
            if (show == null) System.out.println("Show not found");

            Guest guest = em.find(Guest.class, guestID);
            if (guest == null) System.out.println("Guest not found");
            show.addGuest(guest);
            ShowDTO update = new ShowDTO(show);
            em.getTransaction().begin();
            em.merge(show);
            em.merge(guest);
            em.getTransaction().commit();
            return update;
        } finally {
            em.close();
        }
    }
    public List<ShowDTO> ShowAllShowsAssignedToo(int guestId){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<Show> query = em.createQuery("SELECT s FROM Show s JOIN Guest g where g=s.guests and g.id=:guestId",Show.class);
            query.setParameter("guestId", guestId);
            List<Show> shows = query.getResultList();
            if(shows.size() == 0){
                System.out.println("no shows asigned");
            }
            return ShowDTO.getDtos(shows);
        }finally {
            em.close();
        }
    }

}
