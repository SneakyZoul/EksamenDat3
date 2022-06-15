package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String duration;
    private String location;
    private String startDate;
    private String startTime;

    @ManyToMany
    Set<Guest> guests = new HashSet<>();

    public Show(){}

    public Show(String name, String duration, String location, String startDate,String startTime){
        this.name = name;
        this.duration = duration;
        this.location = location;
        this.startDate = startDate;
        this.startTime = startTime;

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Set<Guest> getGuests() {
        return guests;
    }

    public void setGuests(Set<Guest> guests) {
        this.guests = guests;
    }

    public void addGuest(Guest guest){
        this.guests.add(guest);
        if(!guest.getShows().contains(this)){
            guest.addShow(this);
        }
    }


}
