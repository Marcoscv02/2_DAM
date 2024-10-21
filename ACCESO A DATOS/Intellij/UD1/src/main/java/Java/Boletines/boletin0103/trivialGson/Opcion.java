package Java.Boletines.boletin0103.trivialGson;

public final class Opcion {
    //Variables
    String enunciado;
    Boolean correcta;

    //Constructores

    public Opcion() {// Constructor sin parámetros
    }

    public Opcion(String enunciado) { //recoge el enunciado, marcándola como incorrecta.
        this.enunciado = enunciado;
        this.correcta=false;
    }

    public Opcion(String enunciado, Boolean correcta) {//Constructor que recoje ambos parámetros
        this.enunciado = enunciado;
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        if (correcta==true){
            return "Opcion{" +
                    "enunciado='" + enunciado + '\'' +
                    "*, correcta=" + correcta +
                    '}';
        }else {
            return "Opcion{" +
                    "enunciado='" + enunciado + '\'' +
                    ", correcta=" + correcta +
                    '}';
        }

    }
}
