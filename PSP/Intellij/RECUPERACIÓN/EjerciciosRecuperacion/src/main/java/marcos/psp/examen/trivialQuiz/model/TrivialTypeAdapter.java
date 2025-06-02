package marcos.psp.examen.trivialQuiz.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrivialTypeAdapter extends TypeAdapter<Trivial> {
    @Override
    public void write(JsonWriter jsonWriter, Trivial trivial) throws IOException {

    }
    //Leer trivial
    @Override
    public Trivial read(JsonReader reader) throws IOException {
        Trivial trivial = new Trivial();

        if (reader.peek()!= JsonToken.NULL){
            reader.beginObject();

            while (reader.peek()!= JsonToken.END_OBJECT){
                String name = reader.nextName();

                switch (name){
                    case "response_code":
                        trivial.setResposeCode(reader.nextInt());
                        break;

                    case "results":
                        trivial.setQuestions(readQuestionsArray(reader));
                        break;

                    default:
                        reader.skipValue();
                        break;
                }
            }
            reader.endObject();

        }
        return trivial;
    }


    //Leer array de preguntas
    public List<Result> readQuestionsArray (JsonReader reader) throws IOException {
        List<Result> results = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()){
            results.add(readSingleResult(reader));
        }
        reader.endArray();

        return results;
    }

    //Leer pregunta única
    public Result readSingleResult (JsonReader reader) throws IOException {
        Result result = new Result();
        reader.beginObject();

        while (reader.peek() != JsonToken.END_OBJECT){
            String name = reader.nextName();
            switch (name){
                case "type":
                    result.setType(reader.nextString());
                    break;
                case "difficulty":
                    String difficultyStr = reader.nextString().toUpperCase();
                    result.setDifficulty(Difficult.getDifficult(difficultyStr));
                    break;
                case "category":
                    String categoryStr = reader.nextString();
                    result.setCategory(Categoria.getCategoria(categoryStr));
                    break;
                case "question":
                    result.setQuestion(reader.nextString());
                    break;
                case "correct_answer":
                    result.setCorrectAnswer(reader.nextString());
                    break;
                case "incorrect_answers":
                    List<String> incorrectAnswers = new ArrayList<>();
                    reader.beginArray();
                    while (reader.hasNext()) {
                        incorrectAnswers.add(reader.nextString());
                    }
                    reader.endArray();
                    result.setIncorrectAnswers(incorrectAnswers);
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return result;
    }
}
