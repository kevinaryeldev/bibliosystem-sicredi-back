package br.com.kevinarteldev.bibliosystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Copy")
@Table(name = "Copy")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CopyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COPY_SEQ")
    @SequenceGenerator(name = "COPY_SEQ", sequenceName = "SEQ_COPY", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "propertyCode")
    private Integer propertyCode;
    @Column(name = "edition")
    private Integer edition;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private BookEntity Book;
}
