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
@Entity(name = "Client")
@Table(name = "Client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_SEQ")
    @SequenceGenerator(name = "CLIENT_SEQ", sequenceName = "SEQ_CLIENT", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer document;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Character gender;
    @Column(nullable = false)
    private Date birthDate;
}
