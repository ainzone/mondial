package one.ainz.mondial.api;

import one.ainz.mondial.dao.Country;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * REST-API für den Zugriff auf Länderinformationen. Diese API ermöglicht das
 * Abrufen von Ländern anhand verschiedener Kriterien.
 *
 * @author Andreas Schneider (@ainzone)
 * @author Thomas Schuster (@thomas-schuster)
 * @version 2.0
 */
@Path("/countries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Länder-API", description = "Ermöglicht das Abrufen von Länderinformationen anhand von Code, Name oder Liste.")
public class CountryResource {

    /**
     * Gibt eine Liste aller verfügbaren Länder zurück.
     *
     * @return Eine Liste aller Länder.
     */
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Alle Länder abrufen", description = "Gibt eine alphabetisch sortierte Liste aller verfügbaren Länder zurück.")
    @APIResponse(responseCode = "200", description = "Länderliste erfolgreich abgerufen.")
    public List<Map<String, String>> getAllCountries() {
        List<Country> countries = Country.listAll();
        return countries.stream()
                .filter(c -> c.getCode() != null && !c.getCode().isBlank())
                .map(c -> Map.of(
                        "code", c.getCode(),
                        "name", c.getName() != null ? c.getName() : c.getCode()
                ))
                .distinct()
                .sorted(Comparator.comparing(m -> m.get("name")))
                .toList();
    }

    /**
     * Sucht ein Land anhand seines Codes.
     *
     * @param code Der Ländercode, nach dem gesucht werden soll.
     * @return Das gefundene Land oder {@code null}, falls kein entsprechendes
     * Land existiert.
     */
    @GET
    @Path("/{code}")
    @Operation(summary = "Land nach Code suchen", description = "Sucht ein einzelnes Land anhand seines eindeutigen ISO-Codes.")
    @APIResponse(responseCode = "200", description = "Land erfolgreich gefunden oder {@code null}, wenn kein Eintrag existiert.")
    public Country getCountryByCode(@PathParam("code") String code) {
        return Country.findById(code);
    }

    /**
     * Gibt eine sortierte Liste aller verfügbaren Ländercodes zurück.
     *
     * @return Eine Liste von Ländercodes.
     */
    @GET
    @Path("/codes")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Alle Ländercodes abrufen", description = "Gibt eine alphabetisch sortierte Liste aller eindeutigen Ländercodes zurück.")
    @APIResponse(responseCode = "200", description = "Ländercodes erfolgreich abgerufen.")
    public List<String> getAllCountryCodes() {
        List<Country> countries = Country.listAll();
        return countries.stream()
                .map(Country::getCode)
                .filter(code -> code != null && !code.isBlank())
                .distinct()
                .sorted()
                .toList();
    }

}