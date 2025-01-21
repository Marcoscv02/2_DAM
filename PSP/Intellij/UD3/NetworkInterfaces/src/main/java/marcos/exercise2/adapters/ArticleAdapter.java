package marcos.exercise2.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import marcos.exercise2.Article;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArticleAdapter extends TypeAdapter {
    @Override
    public void write(JsonWriter jsonWriter, Object o) throws IOException {

    }

    @Override
    public Object read(JsonReader reader) throws IOException {
        Article article= new Article();

        reader.beginObject();
        if (reader.peek()!= JsonToken.NULL) {
            reader.beginObject();

            while (reader.peek() != JsonToken.END_OBJECT) {
                String name = reader.nextName();
                switch (name){
                    case "success":
                        boolean error= reader.nextBoolean();
                        if(error){
                            return null;
                        }
                        break;
                    case "blog":
                        article=readArticle(reader,article);
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
            }
        }
        reader.endObject();

        return article;
    }

    public Article readArticle(JsonReader reader, Article article) throws IOException{

        if (reader.peek()!= JsonToken.NULL){
            reader.beginObject();

            while (reader.peek()!= JsonToken.END_OBJECT){
                String name= reader.nextName();

                switch (name){
                    case "id":
                        article.setId(reader.nextLong());
                        break;
                    case "title":
                        article.setTittle(reader.nextString());
                        break;
                    case "description":
                        article.setDescription(reader.nextString());
                        break;
                    case "photo_url":
                        article.setPhotoUrl(reader.nextString());
                        break;
                    case "category":
                        article.setCategory(reader.nextString());
                        break;
                    case "content_text":
                        article.setContentText(reader.nextString());
                        break;
                    case "content_html":
                        article.setContentHtml(reader.nextString());
                        break;
                    case "created_at":
                        LocalDateTime dateCreate = dateConverter(reader);
                        article.setCreatedAt(dateCreate);
                        break;
                    case "updated_at":
                        LocalDateTime dateupdate = dateConverter(reader);
                        article.setUpdatedAt(dateupdate);
                        break;
                    case "user_id":
                        article.setUserId(reader.nextLong());
                        break;
                }
            }

            reader.endObject();
        }

        return article;
    }

    DateTimeFormatter dtFormatter= DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss.SSSS");
    public LocalDateTime dateConverter(JsonReader reader) throws IOException {
        reader.beginObject();
        String data = reader.nextString().replace('T',' ');
        LocalDateTime localDateTime= LocalDateTime.parse(data,dtFormatter);
        reader.endObject();
        return localDateTime;
    }
}
