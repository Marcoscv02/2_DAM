package marcos.exercise2.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import marcos.exercise2.Article;

import java.io.IOException;

public class ArticleAdapter extends TypeAdapter {
    @Override
    public void write(JsonWriter jsonWriter, Object o) throws IOException {

    }

    @Override
    public Object read(JsonReader reader) throws IOException {
        Article article= new Article();

        if (reader.peek()!= JsonToken.NULL){
            reader.beginObject();

            while (reader.peek()!= JsonToken.END_OBJECT){
                String name= reader.nextName();

                switch (name){
                    case "id":
                        break;
                    case "title":
                        break;
                    case "description":
                        break;
                    case "photo_url":
                        break;
                    case "category":
                        break;
                    case "content_text":
                        break;
                    case "content_html":
                        break;
                    case "created_at":
                        break;
                    case "updated_at":
                        break;
                    case "user_id":
                        break;
                }
            }

            reader.endObject();
        }

        return null;
    }
}
