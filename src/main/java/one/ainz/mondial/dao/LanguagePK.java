package one.ainz.mondial.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Repräsentiert den zusammengesetzten Primärschlüssel für die Language-Entität.
 * Dieser Schlüssel besteht aus dem Ländercode und dem Namen der Sprache.
 *
 * @author Andreas Schneider (@ainzone)
 * @author Thomas Schuster (@thomas-schuster)
 * @version 2.0
 */
@Embeddable
public class LanguagePK implements Serializable {

    @Column(name = "country", nullable = false, length = 4)
    private String country;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    /**
     * Standardkonstruktor für JPA.
     */
    public LanguagePK() {
    }

    /**
     * Konstruktor zur Initialisierung des Primärschlüssels mit Land und
     * Sprache.
     *
     * @param country Der Ländercode (z. B. "DE" für Deutschland).
     * @param name    Der Name der Sprache.
     */
    public LanguagePK(String country, String name) {
        this.country = country;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Vergleicht zwei LanguagePK-Objekte auf Gleichheit.
     *
     * @param o Das zu vergleichende Objekt.
     * @return {@code true}, wenn beide Objekte gleich sind, sonst
     * {@code false}.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LanguagePK that = (LanguagePK) o;
        return Objects.equals(country, that.country) && Objects.equals(name, that.name);
    }

    /**
     * Berechnet den Hashcode basierend auf den Primärschlüssel-Attributen.
     *
     * @return Der Hashcode der LanguagePK.
     */
    @Override
    public int hashCode() {
        return Objects.hash(country, name);
    }
}
