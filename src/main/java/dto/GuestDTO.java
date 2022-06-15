package dto;

import entities.Guest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuestDTO {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String status;

    private int fetivalId;

    public GuestDTO(Guest guest){
        this.id = guest.getId();
        this.name = guest.getName();
        this.phone = guest.getPhone();
        this.email = guest.getEmail();
        this.status = guest.getStatus();

        if(guest.getFestival() !=null){
            this.fetivalId = guest.getFestival().getId();
        }
    }

    public static List<GuestDTO> getDtos(List<Guest> guestList){
        List<GuestDTO> guestDTOS = new ArrayList();
        guestList.forEach(guest -> guestDTOS.add(new GuestDTO(guest)));
        return guestDTOS;
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

    public int getFetivalId() {
        return fetivalId;
    }

    public void setFetivalId(int fetivalId) {
        this.fetivalId = fetivalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestDTO guestDTO = (GuestDTO) o;
        return id == guestDTO.id && fetivalId == guestDTO.fetivalId && Objects.equals(name, guestDTO.name) && Objects.equals(phone, guestDTO.phone) && Objects.equals(email, guestDTO.email) && Objects.equals(status, guestDTO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, email, status, fetivalId);
    }
}
