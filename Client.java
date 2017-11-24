/**
 * Created by mOh on 01-May-17.
 */
import java.io.*;
import java.net.*;
public class Client {

        public static void main(String argv[]) throws Exception
        {
            String sentence;
            String modifiedSentence;

            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));

            Socket clientSocket = new Socket("172.20.10.5", 6789);

            DataOutputStream outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer =
                    new BufferedReader(new
                            InputStreamReader(clientSocket.getInputStream()));

            sentence = inFromUser.readLine();

            outToServer.writeBytes(sentence + '\n');

            modifiedSentence = inFromServer.readLine();

            System.out.println("FROM SERVER: " + modifiedSentence);

            clientSocket.close();

        }
}
