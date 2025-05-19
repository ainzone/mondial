package one.ainz.mondial.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Repräsentiert ein Land mit Details zu Name, Code, Fläche und Bevölkerung.
 * Diese Entität wird von Quarkus mit Hibernate ORM verwaltet.
 *
 * @author Andreas Schneider (@ainzone)
 * @author Thomas Schuster (@thomas-schuster)
 * @version 2.0
 */
@Entity
@Table(name = "country", schema = "public")
public class Country extends PanacheEntityBase implements Serializable {

    @Id
    @Column(name = "code", nullable = false, length = 4)
    private String code;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "area")
    private BigDecimal area;

    @Column(name = "population")
    private BigDecimal population;

    /**
     * Standardkonstruktor für JPA.
     */
    public Country() {
    }

    /**
     * Konstruktor zur Initialisierung eines Landes mit allen relevanten
     * Attributen.
     *
     * @param code       Der eindeutige Ländercode (z. B. "DE" für Deutschland).
     * @param name       Der Name des Landes.
     * @param area       Die Gesamtfläche des Landes in Quadratkilometern.
     * @param population Die Bevölkerung des Landes.
     */
    public Country(String code, String name, BigDecimal area, BigDecimal population) {
        this.code = code;
        this.name = name;
        this.area = area;
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    public void setPopulation(BigDecimal population) {
        this.population = population;
    }

    /**
     * Berechnet den Hashcode basierend auf dem Ländercode.
     *
     * @return Der Hashcode des Landes.
     */
    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    /**
     * Vergleicht zwei Country-Objekte auf Gleichheit.
     *
     * @param obj Das zu vergleichende Objekt.
     * @return {@code true}, wenn beide Objekte gleich sind, sonst
     * {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Country country = (Country) obj;
        return Objects.equals(code, country.code);
    }

    /**
     * Gibt eine textuelle Repräsentation des Landes zurück.
     *
     * @return Eine Zeichenkette mit dem Ländercode und Namen.
     */
    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}
