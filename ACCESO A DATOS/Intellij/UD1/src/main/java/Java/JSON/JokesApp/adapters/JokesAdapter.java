package Java.JSON.JokesApp.adapters;

import Java.JSON.JokesApp.model.Flag;
import Java.JSON.JokesApp.model.Joke;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class JokesAdapter extends TypeAdapter<Joke> {
    @Override
    public void write(JsonWriter writer, Joke joke) throws IOException {

    }

    @Override
    public Joke read(JsonReader reader) throws IOException {
         boolean error, safe;
         String category, type, setUp, delivery,lang;
         Flag flags;
         int id;

        if (reader.peek()== JsonToken.BEGIN_OBJECT){
            switch (reader.nextName()){
                case "error":
                    error=reader.nextBoolean();
                    break;
                case "category":
                    category=reader.nextString();
                    break;
                case "type":
                    type=reader.nextString();
                    break;
                case "setup":
                    type=reader.nextString();
                    break;
                case "flags":
                    break;
                case "safe":
                    safe=reader.nextBoolean();
                case "id":
                    id= reader.nextInt();
                case "lang":
                    lang=reader.nextString();
                default:
                    reader.skipValue();
            }
        }
        Joke joke=new Joke();

        return joke;
    }

    public Flag readFlags(JsonReader reader, Joke chiste){
        if ()

        return null;
    }
}
