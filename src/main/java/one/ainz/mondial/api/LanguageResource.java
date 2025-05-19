package one.ainz.mondial.api;


import one.ainz.mondial.dao.Language;
import one.ainz.mondial.dao.LanguagePK;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

/**
 * REST-API für den Zugriff auf Sprachinformationen. Diese API ermöglicht das
 * Abrufen von Sprachen anhand verschiedener Kriterien.
 *
 * @author Andreas Schneider (@ainzone)
 * @author Thomas Schuster (@thomas-schuster)
 * @version 2.0
 */
@Path("/languages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LanguageResource {

    /**
     * Gibt eine Liste aller verfügbaren Sprachen zurück.
     *
     * @return Eine Liste aller Sprachen.
     */
    @GET
    public List<Language> getAllLanguages() {
        return Language.listAll();
    }

    /**
     * Sucht eine Sprache anhand des Landes und des Sprachnamens.
     *
     * @param country Das Land, dem die Sprache zugeordnet ist.
     * @param name    Der Name der gesuchten Sprache.
     * @return Eine HTTP-Response mit der gefundenen Sprache oder einer
     * {@link Response.Status#NOT_FOUND}-Antwort, falls die Sprache nicht
     * existiert.
     */
    @GET
    @Path("/{country}/{name}")
    public Response getLanguageById(@PathParam("country") String country, @PathParam("name") String name) {
        LanguagePK languagePK = new LanguagePK(country, name);
        Language language = Language.findById(languagePK);

        if (language == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(language).build();
    }
}
