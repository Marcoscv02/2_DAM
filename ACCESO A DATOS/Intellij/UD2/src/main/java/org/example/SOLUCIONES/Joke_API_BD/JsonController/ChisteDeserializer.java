package org.example.SOLUCIONES.Joke_API_BD.JsonController;

import com.google.gson.*;
import org.example.SOLUCIONES.Joke_API_BD.Chiste;
import org.example.SOLUCIONES.Joke_API_BD.Flag;

import java.lang.reflect.Type;

/**
 * Clase que implementa un deserializador para convertir un JSON en un objeto {@link Chiste}.
 */
public class ChisteDeserializer implements JsonDeserializer<Chiste> {

    /**
     * Deserializa un objeto JSON en una instancia de {@link Chiste}.
     *
     * @param elemento el elemento JSON que contiene el chiste.
     * @param type el tipo de objeto esperado.
     * @param jsonDeserializationContext el contexto de deserialización de Gson.
     * @return una instancia de {@link Chiste} si la deserialización es exitosa, o {@code null} si no es válida.
     * @throws JsonParseException si hay un error en el proceso de deserialización.
     */
    @Override
    public Chiste deserialize(JsonElement elemento, Type type,
                              JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        // Comprueba si el JSON es un objeto
        if (!elemento.isJsonObject())
            return null;

        JsonObject jsonChiste = elemento.getAsJsonObject();

        // Comprueba si hay un error en la petición
        if (jsonChiste.has("error") && jsonChiste.get("error").isJsonNull()
                && jsonChiste.get("error").getAsBoolean()) {
            return null;
        }

        // Crea un objeto Chiste vacío para asignarle valores.
        Chiste chiste = new Chiste();

        // Asigna valores a los atributos del objeto Chiste si están presentes en el JSON.
        if (jsonChiste.has("category") && !jsonChiste.get("category").isJsonNull()) {
            chiste.setCategoria(jsonChiste.get("category").getAsString());
        }

        if (jsonChiste.has("type") && !jsonChiste.get("type").isJsonNull()) {
            chiste.setTipo(jsonChiste.get("type").getAsString());
        }

        // Asigna valores al chiste y la respuesta si están presentes en el JSON.
        if (jsonChiste.has("setup") && !jsonChiste.get("setup").isJsonNull()) {
            chiste.setChiste(jsonChiste.get("setup").getAsString());
            if (jsonChiste.has("delivery") && !jsonChiste.get("delivery").isJsonNull()) {
                chiste.setRespuesta(jsonChiste.get("delivery").getAsString());
            }
        } else if (jsonChiste.has("joke") && !jsonChiste.get("joke").isJsonNull()) {
            chiste.setChiste(jsonChiste.get("joke").getAsString());
        }

        // Asigna el idioma del chiste si está presente en el JSON.
        if (jsonChiste.has("lang") && !jsonChiste.get("lang").isJsonNull()) {
            chiste.setLenguaje(jsonChiste.get("lang").getAsString());
        }

        // Asigna el identificador del chiste si está presente en el JSON.
        if (jsonChiste.has("id") && !jsonChiste.get("id").isJsonNull()) {
            chiste.setId(jsonChiste.get("id").getAsInt());
        }

        // Procesa las banderas (flags) si están presentes en el JSON.
        if (jsonChiste.has("flags") && !jsonChiste.get("flags").isJsonNull()
                && jsonChiste.get("flags").isJsonObject()) {
            JsonObject flags = jsonChiste.get("flags").getAsJsonObject();
            if (flags.has("nsfw") && flags.get("nsfw").getAsBoolean()) {
                chiste.addFlag(Flag.NSFW);
            }
            if (flags.has("religious") && flags.get("religious").getAsBoolean()) {
                chiste.addFlag(Flag.RELIGION);
            }
            if (flags.has("political") && flags.get("political").getAsBoolean()) {
                chiste.addFlag(Flag.POLITICAL);
            }
            if (flags.has("racist") && flags.get("racist").getAsBoolean()) {
                chiste.addFlag(Flag.RACIST);
            }
            if (flags.has("sexist") && flags.get("sexist").getAsBoolean()) {
                chiste.addFlag(Flag.SEXIST);
            }
            if (flags.has("explicit") && flags.get("explicit").getAsBoolean()) {
                chiste.addFlag(Flag.EXPLICIT);
            }
        }
        return chiste;
    }

    /**
     * Verifica si un campo existe y no es nulo dentro de un objeto JSON.
     *
     * @param obxecto el objeto JSON donde se busca el campo.
     * @param campo el nombre del campo a verificar.
     * @return {@code true} si el campo existe y no es nulo, {@code false} en caso contrario.
     */
    private static boolean has(JsonObject obxecto, String campo) {
        return obxecto.has(campo) && !obxecto.get(campo).isJsonNull();
    }
}
