package br.com.kevinarteldev.bibliosystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "Client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClientEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
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
