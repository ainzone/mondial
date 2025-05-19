package one.ainz.mondial.api;

import one.ainz.mondial.dao.City;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * Ressource für den Zugriff auf Städteinformationen. Diese API ermöglicht das
 * Abrufen von Städten basierend auf verschiedenen Kriterien.
 *
 * @author Andreas Schneider (@ainzone)
 * @author Thomas Schuster (@thomas-schuster)
 * @version 2.0
 */
@Path("/cities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CityResource {

    /**
     * Gibt eine Liste aller Städte zurück.
     *
     * @return Eine Liste aller verfügbaren Städte.
     */
    @GET
    public List<City> getAllCities() {
        return City.listAll();
    }

    /**
     * Gibt eine Liste aller Städte eines bestimmten Landes zurück.
     *
     * @param country Der Name des Landes, nach dem gefiltert werden soll.
     * @return Eine Liste von Städten, die zu dem angegebenen Land gehören.
     */
    @GET
    @Path("/country/{country}")
    public List<City> getCitiesByCountry(@PathParam("country") String country) {
        return City.list("cityPK.country", country);
    }

    /**
     * Gibt eine Liste aller Städte mit einem bestimmten Namen zurück.
     *
     * @param name Der Name der Stadt, nach dem gefiltert werden soll.
     * @return Eine Liste von Städten, die den angegebenen Namen haben.
     */
    @GET
    @Path("/name/{name}")
    public List<City> getCitiesByName(@PathParam("name") String name) {
        return City.list("cityPK.name", name);
    }
}
