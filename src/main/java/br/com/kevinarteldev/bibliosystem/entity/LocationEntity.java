package br.com.kevinarteldev.bibliosystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Location")
@Table(name = "Location")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATION_SEQ")
    @SequenceGenerator(name = "LOCATION_SEQ", sequenceName = "SEQ_LOCATION", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "location_date")
    private Date location_date;

    @Column(name = "return_date")
    private Date return_date;

    @Column(name = "status")
    private Character status;
}
