package Java.JSON.JokesApp.jsonController;

import Java.JSON.JokesApp.model.Flag;
import Java.JSON.JokesApp.model.Joke;
import com.google.gson.*;


import java.lang.reflect.Type;

public class JokeDeserialize implements JsonDeserializer<Joke> {
    @Override
    public Joke deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject chisteObject= element.getAsJsonObject();
        Joke joke= new Joke();

        if (!chisteObject.isJsonNull()){

            //Recojer el error en caso de que sea nulo
            if (chisteObject.has("error")&& chisteObject.get("error").getAsBoolean())
                joke.setError (chisteObject.get("error").getAsBoolean());

            joke.setCategoría (chisteObject.get("category").getAsString());
            joke.setTipo (chisteObject.get("type").getAsString());

            //Deserializar el tipo de chiste
            if (joke.getTipo()== Java.JSON.JokesApp.model.Type.TWOPART){
                joke.setJoke (chisteObject.get("setup").getAsString());
                joke.setDelivery (chisteObject.get("delivery").getAsString());
            }else {
                joke.setJoke (chisteObject.get("joke").getAsString());
                joke.setDelivery(null);
            }

            //Recolectar lista de Banderas y meterlas en el arraylist en caso de ser necesario
            if (chisteObject.has("flags")){
                JsonObject flagsObject= chisteObject.getAsJsonObject("flags");

                if (flagsObject.has("nsfw") && flagsObject.get("nsfw").getAsBoolean() )
                    joke.addFlag(Flag.NSFW);

                if (flagsObject.has("religious") && flagsObject.get("religious").getAsBoolean() )
                    joke.addFlag(Flag.REGILIOUS);

                if (flagsObject.has("political") && flagsObject.get("political").getAsBoolean() )
                    joke.addFlag(Flag.POLITICAL);

                if (flagsObject.has("racist") && flagsObject.get("racist").getAsBoolean() )
                    joke.addFlag(Flag.RACIST);

                if (flagsObject.has("sexist") && flagsObject.get("sexist").getAsBoolean() )
                    joke.addFlag(Flag.SEXIST);

                if (flagsObject.has("explicit") && flagsObject.get("explicit").getAsBoolean() )
                    joke.addFlag(Flag.EXPLICIT);
            }

            joke.setSafe(chisteObject.get("safe").getAsBoolean());
            joke.setId(chisteObject.get("id").getAsInt());
            joke.setLenguaje(chisteObject.get("lang").getAsString());

        }

        return joke;
    }

}
