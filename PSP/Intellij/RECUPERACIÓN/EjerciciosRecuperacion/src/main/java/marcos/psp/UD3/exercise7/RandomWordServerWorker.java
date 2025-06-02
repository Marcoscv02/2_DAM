package marcos.psp.UD3.exercise7;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class RandomWordServerWorker implements Runnable {
    DatagramPacket packet;
    DatagramSocket socket;

    public RandomWordServerWorker(DatagramPacket packet, DatagramSocket socket) {
        this.packet = packet;
        this.socket = socket;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        String dataReceive = new String(packet.getData(), 0, packet.getLength()).trim();
        try {
            if (dataReceive.equalsIgnoreCase("quit")) {
                sendData("goodBye");
                return;
            }

            if (isNumeric(dataReceive)) {
                int numChars = Integer.parseInt(dataReceive);
                String word = getWord(numChars);
                sendData(word);
            } else {
                sendData("unknown command");
            }

        } catch (IOException e) {
            System.out.println("Error en el envío de la información "+e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    private void sendData (String response) throws IOException {
        byte [] buffer = response.getBytes();
        InetAddress clientAdress = packet.getAddress();
        int port = packet.getPort();
        DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, clientAdress, port);

        socket.send(sendPacket);
    }

    private String getWord (int numChars){
        try {
            URL url = new URI("https://random-word-api.herokuapp.com/word?length="+numChars).toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line = reader.readLine();

            String [] fullLine = line.split("\"");

            return fullLine[1];

        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
