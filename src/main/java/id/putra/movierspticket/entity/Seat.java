package id.putra.movierspticket.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Seat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "showtime_id")
    private String id;

    @Column(name = "seat_code")
    private String seatCode;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @OneToMany(mappedBy = "seat")
    private List<Showtimes> showtimes;
}
