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

public class ArticleAdapter extends TypeAdapter<Article> {
    @Override
    public void write(JsonWriter jsonWriter, Article a) throws IOException {

    }

    @Override
    public Article read(JsonReader reader) throws IOException {
        System.out.println("Llegada a metodo read articulo");
        Article article= new Article();
        if (reader.peek()!=JsonToken.NULL) {
            reader.beginObject();

            while (reader.hasNext()) {
                String name = reader.nextName();
                switch (name) {
                    case "success":
                        boolean correcto = reader.nextBoolean();
                        if (correcto == false) {
                            return null;
                        }
                        break;
                    case "blog":
                        article = readArticle(reader, article);
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
            }
            reader.endObject();
            return article;
        }
        return null;
    }

    public Article readArticle(JsonReader reader, Article article) throws IOException{

        if (reader.peek()!= JsonToken.NULL){
            reader.beginObject();

            while (reader.hasNext()){
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
                    default:
                        reader.skipValue();
                        break;
                }
            }

            reader.endObject();
            return article;
        }

        return null;
    }

    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n");
    public LocalDateTime dateConverter(JsonReader reader) throws IOException {
        String data = reader.nextString().replace('T',' ');
        return LocalDateTime.parse(data,dtFormatter);
    }
}
