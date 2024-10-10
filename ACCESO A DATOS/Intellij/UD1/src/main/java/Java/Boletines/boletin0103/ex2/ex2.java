package Java.Boletines.boletin0103.ex2;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import static java.lang.System.*;

public class ex2 {
    public static void main(String[] args) {

        ScriptEngineManager manager = new ScriptEngineManager(); // Inicio el API de Scripting

        //Ver la Lista de motores disponibles
        List<ScriptEngineFactory>lista= manager.getEngineFactories();
        for (ScriptEngineFactory f:lista){
            out.println("Nombre: "+f.getEngineName());
            out.println("Version: "+f.getEngineVersion());
            out.println("Engine ShortNames: "+f.getNames());
        }

        //Acceder a archivo .js
        ScriptEngine engine = manager.getEngineByName("Javascript");
        try {
            engine.eval(new FileReader("D:\\MaquinasVirtuais\\a24marcoscv\\ex2.js")); // Sí, los flujos con importantes
        } catch (ScriptException se) {
            err.println(se.getMessage());
        } catch (IOException ioe) {
            err.println(ioe.getMessage());
        }
    }
}
