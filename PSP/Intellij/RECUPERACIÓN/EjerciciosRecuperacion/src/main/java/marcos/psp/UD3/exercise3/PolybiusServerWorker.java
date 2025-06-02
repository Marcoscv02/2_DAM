package marcos.psp.UD3.exercise3;

import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PolybiusServerWorker implements Runnable {
    //Matriz que representa el cifrado polybius
    private static final char[][] POLYBIUS_SQUARE = {
            {'A', 'B', 'C', 'D', 'E', 'F'},
            {'G', 'H', 'I', 'J', 'K', 'L'},
            {'M', 'N', 'O', 'P', 'Q', 'R'},
            {'S', 'T', 'U', 'V', 'W', 'X'},
            {'Y', 'Z', '0', '1', '2', '3'},
            {'4', '5', '6', '7', '8', '9'}
    };

    private SSLSocket socket;

    public PolybiusServerWorker(SSLSocket socket) {
        this.socket = socket;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)){

            while (true){
                String word = reader.readLine();

                if (word.equalsIgnoreCase("quit")){
                    writer.println("good bye");
                    break;
                }

                String encryptWord = encrypt(word);
                writer.println(encryptWord);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Recorre la matriz cambiando las letras por los valores corrspondientes con este cifrado
    private static String encrypt(String word) {
        StringBuilder result = new StringBuilder();
        word = word.toUpperCase().replace("J", "I");
        for (char c : word.toCharArray()) {
            for (int i = 0; i < POLYBIUS_SQUARE.length; i++) {
                for (int j = 0; j < POLYBIUS_SQUARE[i].length; j++) {
                    if (POLYBIUS_SQUARE[i][j] == c) {
                        result.append(i + 1).append(j + 1).append(' ');
                        break;
                    }
                }
            }
        }
        return result.toString();
    }
}
