package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;
    private String status;

    @ManyToMany(mappedBy = "guests")
    Set<Show> shows = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "festival_id")
    private Festival festival;


    public Guest() {
    }

    public Guest(String name, String phone, String email, String status) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Show> getShows() {
        return shows;
    }

    public void setShows(Set<Show> shows) {
        this.shows = shows;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

public void addShow(Show show){
        this.shows.add(show);
        if(!show.getGuests().contains(this)){
            show.addGuest(this);
        }
}
}
