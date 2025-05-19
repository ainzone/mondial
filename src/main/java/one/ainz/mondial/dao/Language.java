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
 * Repräsentiert eine Sprache, die in einem bestimmten Land gesprochen wird.
 * Diese Entität wird von Quarkus mit Hibernate ORM verwaltet.
 *
 * @author Andreas Schneider (@ainzone)
 * @author Thomas Schuster (@thomas-schuster)
 * @version 2.0
 */
@Entity
@Table(name = "language", schema = "public")
public class Language extends PanacheEntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private LanguagePK languagePK;

    @Column(name = "percentage", precision = 5, scale = 2)
    private BigDecimal percentage;

    /**
     * Standardkonstruktor für JPA.
     */
    public Language() {
    }

    /**
     * Konstruktor zur Initialisierung einer Sprache mit Primärschlüssel und
     * Verbreitung.
     *
     * @param languagePK Der zusammengesetzte Primärschlüssel bestehend aus Land
     *                   und Sprache.
     * @param percentage Der Prozentsatz der Bevölkerung, die diese Sprache
     *                   spricht.
     */
    public Language(LanguagePK languagePK, BigDecimal percentage) {
        this.languagePK = languagePK;
        this.percentage = percentage;
    }

    public LanguagePK getLanguagePK() {
        return languagePK;
    }

    public void setLanguagePK(LanguagePK languagePK) {
        this.languagePK = languagePK;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    /**
     * Vergleicht zwei Language-Objekte auf Gleichheit.
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
        Language language = (Language) o;
        return Objects.equals(languagePK, language.languagePK);
    }

    /**
     * Berechnet den Hashcode basierend auf dem Primärschlüssel.
     *
     * @return Der Hashcode der Sprache.
     */
    @Override
    public int hashCode() {
        return Objects.hash(languagePK);
    }

    /**
     * Gibt eine textuelle Repräsentation der Sprache zurück.
     *
     * @return Eine Zeichenkette mit Land, Sprachenname und prozentualer
     * Verbreitung.
     */
    @Override
    public String toString() {
        return "Language{"
                + "country='" + languagePK.getCountry() + '\''
                + ", name='" + languagePK.getName() + '\''
                + ", percentage=" + percentage
                + '}';
    }
}
