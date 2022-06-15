package dto;

import entities.Guest;
import entities.Show;

import java.util.*;

public class ShowDTO {

    private int id;
    private String name;
    private String duration;
    private String location;
    private String startDate;
    private String startTime;

    Set<GuestDTO> guests = new HashSet<>();

    public ShowDTO(Show show){
        this.id = show.getId();
        this.name = show.getName();
        this.duration = show.getDuration();
        this.location = show.getLocation();
        this.startDate = show.getStartDate();
        this.startTime = show.getStartTime();

        for(Guest guest : show.getGuests()){
            this.guests.add(new GuestDTO(guest));
        }
    }

    public static List<ShowDTO> getDtos(List<Show> showList){
        List<ShowDTO> showDTOS = new ArrayList<>();
        showList.forEach(show -> showDTOS.add(new ShowDTO(show)));
        return showDTOS;
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

    public Set<GuestDTO> getGuests() {
        return guests;
    }

    public void setGuests(Set<GuestDTO> guests) {
        this.guests = guests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowDTO showDTO = (ShowDTO) o;
        return id == showDTO.id && Objects.equals(name, showDTO.name) && Objects.equals(duration, showDTO.duration) && Objects.equals(location, showDTO.location) && Objects.equals(startDate, showDTO.startDate) && Objects.equals(startTime, showDTO.startTime) && Objects.equals(guests, showDTO.guests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, location, startDate, startTime, guests);
    }
}
