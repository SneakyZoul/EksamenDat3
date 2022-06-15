package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String duration;
    private String location;
    private String startDate;
    private String startTime;


}
