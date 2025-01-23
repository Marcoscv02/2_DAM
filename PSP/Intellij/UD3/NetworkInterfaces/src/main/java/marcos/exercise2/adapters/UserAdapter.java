package marcos.exercise2.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import marcos.exercise2.User;

import java.io.IOException;

public class UserAdapter extends TypeAdapter <User>{

    @Override
    public void write(JsonWriter jsonWriter, User user) throws IOException {

    }

    @Override
    public User read(JsonReader reader) throws IOException {
        System.out.println("Ha llegado a metodo read de user");
        if (reader.peek()!= JsonToken.NULL){
            User user= new User();

            reader.beginObject();
            StringBuilder userName= new StringBuilder();
            String name= reader.nextName();

            switch (name){
                case "id:":
                    user.setUserId(reader.nextLong());
                    break;
                case "first_name", "last_name":
                    userName.append(reader.nextString());
                    break;
                default:
                    reader.skipValue();
                    break;
            }
            user.setName(userName.toString());
            reader.endObject();

            return user;
        }

        return null;
    }
}
