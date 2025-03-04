package id.putra.movierspticket.entity;

import java.time.Duration;
import java.util.Date;
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
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "movie_id", nullable = false)
    private String id;

    private String title;

    private String description;

    @Column(name = "duration", columnDefinition = "integer")
    private Duration duration;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "poster_path")
    private String posterPath;

    @OneToMany(mappedBy = "movie")
    private List<Genre> genres;

    @OneToMany(mappedBy = "movie")
    private List<Showtimes> showtimes;
}
