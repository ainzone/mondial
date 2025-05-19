package one.ainz.mondial.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Eine REST-Resource, die eine statische Begrüßungsnachricht über alle gängigen HTTP-Methoden bereitstellt.
 * Version: 1.0
 * Autor: Andreas Schneider (@ainzone)
 */
@Path("/hello")
@Tag(name = "Begrüssungs-API", description = "Stellt eine einfache Textnachricht für alle HTTP-Methoden bereit.")
public class GreetingResource {

    private static final String MESSAGE = "Hello from Quarkus REST";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "GET-Anfrage", description = "Gibt die Begrüßungsnachricht über eine GET-Anfrage zurück.")
    @APIResponse(responseCode = "200", description = "Begrüßung erfolgreich abgerufen.")
    public String getHello() {
        return MESSAGE;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "POST-Anfrage", description = "Gibt die Begrüßungsnachricht über eine POST-Anfrage zurück.")
    @APIResponse(responseCode = "200", description = "Begrüßung erfolgreich gesendet.")
    public String postHello() {
        return MESSAGE;
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "PUT-Anfrage", description = "Gibt die Begrüßungsnachricht über eine PUT-Anfrage zurück.")
    @APIResponse(responseCode = "200", description = "Begrüßung erfolgreich aktualisiert.")
    public String putHello() {
        return MESSAGE;
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "DELETE-Anfrage", description = "Gibt die Begrüßungsnachricht über eine DELETE-Anfrage zurück.")
    @APIResponse(responseCode = "200", description = "Begrüßung erfolgreich gelöscht (simuliert).")
    public String deleteHello() {
        return MESSAGE;
    }

    @PATCH
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "PATCH-Anfrage", description = "Gibt die Begrüßungsnachricht über eine PATCH-Anfrage zurück.")
    @APIResponse(responseCode = "200", description = "Begrüßung erfolgreich angepasst (simuliert).")
    public String patchHello() {
        return MESSAGE;
    }
}