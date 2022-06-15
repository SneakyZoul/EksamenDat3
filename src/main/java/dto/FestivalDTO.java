package dto;

import entities.Festival;
import entities.Guest;

import java.util.*;

public class FestivalDTO {
    private int id;
    private String name;
    private String city;
    private String startDate;
    private String duration;

    private Set<GuestDTO> guest = new HashSet<>();

    public FestivalDTO(Festival festival){
        this.id = festival.getId();
        this.name = festival.getName();
        this.city = festival.getCity();
        this.startDate = festival.getStartDate();
        this.duration = festival.getDuration();

        for (Guest guest: festival.getGuests()) {
            this.guest.add(new GuestDTO(guest));
        }
    }
    public static List<FestivalDTO> getDtos(List<Festival> festivalList){
        List<FestivalDTO> festivalDTOS = new ArrayList<>();
        festivalList.forEach(festival -> festivalDTOS.add(new FestivalDTO(festival)));
        return festivalDTOS;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Set<GuestDTO> getGuest() {
        return guest;
    }

    public void setGuest(Set<GuestDTO> guest) {
        this.guest = guest;
    }


}
