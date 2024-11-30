package org.example.mailBox;

public class Producer extends Thread{

    private static final String [] EMAILS={
            "El sol brilla hoy",
            "La lluvia refresca el aire",
            "Las hojas caen lentamente",
            "El viento canta suave",
            "La luna ilumina el mar",
            "El río fluye sin pausa",
            "Las estrellas decoran el cielo",
            "Los pájaros vuelan libres",
            "La montaña guarda secretos",
            "La flor abre sus pétalos",
            "El bosque esconde misterios",
            "El fuego calienta la noche",
            "La nieve cubre el camino",
            "El tiempo nunca se detiene",
            "La vida sigue su curso"
    };

    MailBox mailBox= new MailBox();

    //Constructor
    public Producer(MailBox mailBox){
        this.mailBox=mailBox;
    }

    public void run(){
        while (true){
            try {
                //Genera un indice aleatorio que llevará al mensaje con ese índice del array EMAILS
                String mensaje=EMAILS[(int) (Math.random()*EMAILS.length)];
                mailBox.producir(mensaje);
                System.out.println( "Se escribe: "+mensaje);
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
