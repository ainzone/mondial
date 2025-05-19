package one.ainz.mondial.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Repräsentiert den zusammengesetzten Primärschlüssel für die City-Entität.
 * Dieser Schlüssel besteht aus dem Stadtnamen, dem zugehörigen Land und der
 * Provinz.
 *
 * @author Andreas Schneider (@ainzone)
 * @author Thomas Schuster (@thomas-schuster)
 * @version 2.0
 */
@Embeddable
public class CityPK implements Serializable {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "country", nullable = false, length = 4)
    private String country;

    @Column(name = "province", nullable = false, length = 50)
    private String province;

    /**
     * Standardkonstruktor für JPA.
     */
    public CityPK() {
    }

    /**
     * Konstruktor zur Initialisierung des Primärschlüssels mit Stadtname, Land
     * und Provinz.
     *
     * @param name     Der Name der Stadt.
     * @param country  Das zugehörige Land (Ländercode).
     * @param province Die Provinz, in der sich die Stadt befindet.
     */
    public CityPK(String name, String country, String province) {
        this.name = name;
        this.country = country;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Berechnet den Hashcode basierend auf den Primärschlüssel-Attributen.
     *
     * @return Der Hashcode der CityPK.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, country, province);
    }

    /**
     * Vergleicht zwei CityPK-Objekte auf Gleichheit.
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
        CityPK cityPK = (CityPK) obj;
        return Objects.equals(name, cityPK.name)
                && Objects.equals(country, cityPK.country)
                && Objects.equals(province, cityPK.province);
    }

    /**
     * Gibt eine textuelle Repräsentation des Primärschlüssels zurück.
     *
     * @return Eine Zeichenkette mit den Werten des Primärschlüssels.
     */
    @Override
    public String toString() {
        return "CityPK{name='" + name + "', country='" + country + "', province='" + province + "'}";
    }
}
