package one.ainz.mondial.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Repräsentiert eine Stadt mit Details zu Bevölkerung, geografischer Lage und
 * Zugehörigkeit zu einem Land und einer Provinz.
 * <p>
 * Diese Entität wird von Quarkus mit Hibernate ORM verwaltet.
 *
 * @author Andreas Schneider (@ainzone)
 * @author Thomas Schuster (@thomas-schuster)
 * @version 2.0
 */
@Entity
@Table(name = "city", schema = "public")
public class City extends PanacheEntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CityPK cityPK;

    @Column(name = "population")
    private BigDecimal population;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "elevation")
    private BigDecimal elevation;

    @Column(name = "province", insertable = false, updatable = false)
    private String province;

    /**
     * Standardkonstruktor für JPA.
     */
    public City() {
    }

    /**
     * Konstruktor mit Primärschlüssel.
     *
     * @param cityPK Der Primärschlüssel der Stadt.
     */
    public City(CityPK cityPK) {
        this.cityPK = cityPK;
    }

    /**
     * Konstruktor mit Stadtname, Land und Provinz.
     *
     * @param name     Der Name der Stadt.
     * @param country  Das Land, in dem sich die Stadt befindet.
     * @param province Die Provinz, zu der die Stadt gehört.
     */
    public City(String name, String country, String province) {
        this.cityPK = new CityPK(name, country, province);
    }

    public BigDecimal getElevation() {
        return elevation;
    }

    public void setElevation(BigDecimal elevation) {
        this.elevation = elevation;
    }

    public String getProvince() {
        return cityPK.getProvince();
    }

    public void setProvince(String province) {
        this.cityPK.setProvince(province);
    }

    public CityPK getCityPK() {
        return cityPK;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    /**
     * Berechnet den Hashcode basierend auf dem Primärschlüssel.
     *
     * @return Der Hashcode der Stadt.
     */
    @Override
    public int hashCode() {
        return Objects.hash(cityPK);
    }

    /**
     * Vergleicht diese Stadt mit einem anderen Objekt auf Gleichheit.
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
        City other = (City) obj;
        return Objects.equals(cityPK, other.cityPK);
    }

    /**
     * Gibt eine textuelle Repräsentation der Stadt zurück.
     *
     * @return Eine Zeichenkette, die die Stadt beschreibt.
     */
    @Override
    public String toString() {
        return "City{cityPK=" + cityPK + "}";
    }
}
