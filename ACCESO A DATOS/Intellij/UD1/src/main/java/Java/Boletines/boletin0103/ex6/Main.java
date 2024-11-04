package Java.Boletines.boletin0103.ex6;

import com.google.gson.*;

import java.text.DecimalFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Producto p = new Producto("Teclado",23.6594858);

        Gson gson= new GsonBuilder()
               .setPrettyPrinting()
                //Registrar  typeAdapter con expresion Lambda
               .registerTypeAdapter(Producto.class, (JsonSerializer<Producto>)(producto,type, context)->{
                   JsonObject jsObject= new JsonObject();
                   jsObject.addProperty("nombre",producto.getNombre());
                   //Formatear el precio solo con dos decimales
                   Double precionRedondeado=Math.round(producto.getPrecio()*100.0)/100.0;
                   jsObject.addProperty("precio",precionRedondeado);
                   return jsObject;
               })
                //Segunda epresion Lambda
                .registerTypeAdapter(Producto.class,(JsonDeserializer<Producto>)(jsElement, type, context)->{
                    JsonObject jsObject= jsElement.getAsJsonObject();
                    String nombre= jsObject.get("nombre").getAsString();
                    Double precio= jsObject.get("precio").getAsDouble();
                    Producto producto= new Producto (nombre,precio);
                    return producto;
                })
                .create();

        String json= gson.toJson(p);
        System.out.println(json);

        Producto productoRecuperado =gson.fromJson(json,Producto.class);
        System.out.println(productoRecuperado.toString());

    }
}
