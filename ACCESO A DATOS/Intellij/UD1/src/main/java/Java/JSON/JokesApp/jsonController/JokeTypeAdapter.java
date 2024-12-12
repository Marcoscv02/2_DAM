package Java.JSON.JokesApp.jsonController;

import Java.JSON.JokesApp.model.Flag;
import Java.JSON.JokesApp.model.Joke;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JokeTypeAdapter extends TypeAdapter<Joke> {
    @Override
    public void write(JsonWriter jsonWriter, Joke joke) throws IOException {

    }

    @Override
    public Joke read(JsonReader reader) throws IOException {
        Joke joke= new Joke();

        if (reader.peek()!= JsonToken.NULL){
            reader.beginObject();

            while (reader.peek()!=JsonToken.END_OBJECT){
                String name= reader.nextName();

                switch (name){
                    case "error":
                        joke.setError(reader.nextBoolean());
                        break;
                    case "category":
                        joke.setCategoría(reader.nextString());
                        break;
                    case "type":
                        joke.setTipo(reader.nextString());
                        break;
                    case "joke","setup":
                        joke.setJoke(reader.nextString());
                        break;
                    case "delivery":
                        joke.setDelivery(reader.nextString());
                        break;
                    case "flags":
                        joke.setFlags(readFlags(reader,joke));
                        break;
                    case "safe":
                        joke.setSafe(reader.nextBoolean());
                        break;
                    case "id":
                        joke.setId(reader.nextInt());
                        break;
                    case "lang":
                        joke.setLenguaje(reader.nextString());
                        break;
                    default:
                        reader.skipValue();
                        break;
                }

            }
            reader.endObject();
        }

        return joke;
    }

    public List<Flag> readFlags (JsonReader reader, Joke joke){
        List<Flag> banderas= new ArrayList<>();

        try {
            if (reader.peek()!=JsonToken.NULL){
                reader.beginObject();
                while (reader.peek()!=JsonToken.END_OBJECT){
                    String name= reader.nextName();

                    switch (name){
                        case "nsfw":
                            if (reader.nextBoolean()) banderas.add(Flag.NSFW);
                            break;
                        case "religious":
                            if (reader.nextBoolean()) banderas.add(Flag.REGILIOUS);
                            break;
                        case "political":
                            if (reader.nextBoolean()) banderas.add(Flag.POLITICAL);
                            break;
                        case "racist":
                            if (reader.nextBoolean()) banderas.add(Flag.RACIST);
                            break;
                        case "sexist":
                            if (reader.nextBoolean()) banderas.add(Flag.SEXIST);
                            break;
                        case "explicit":
                            if (reader.nextBoolean()) banderas.add(Flag.EXPLICIT);
                            break;
                        default:
                            reader.skipValue();
                            break;
                    }
                }
                reader.endObject();
            }

            return banderas;

        } catch (IOException e) {
            System.out.println("Error en la obtención de flags");
            throw new RuntimeException(e);
        }
    }
}
