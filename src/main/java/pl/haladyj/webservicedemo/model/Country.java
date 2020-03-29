package pl.haladyj.webservicedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "country", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "country", namespace = "http://spring.io/guides/gs-producing-web-service", propOrder = {
        "id",
        "name",
        "population",
        "capital",
        "currency"
})
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    @Size(min=2, max=40)
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    private String name;

    @NotNull
    @Column(nullable = false)
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    private Integer population;

    @NotNull
    @Column(nullable = false)
    @Size(min = 2, max = 40)
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    private String capital;

    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    private Currency currency;
}
