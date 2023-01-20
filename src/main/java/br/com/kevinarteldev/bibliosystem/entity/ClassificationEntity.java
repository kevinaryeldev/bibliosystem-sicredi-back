package br.com.kevinarteldev.bibliosystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@Entity
public class ClassificationEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private Integer code;

    @Column(name = "description")
    private String description;
}
