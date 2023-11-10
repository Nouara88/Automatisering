package inlämningsuppgift;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Scanner;
public class ReadWriteText {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in); // scanna in det som användaren skriver in
        System.out.println("Var vänlig och berätta om problemet som uppstår med bredband uppkopplingen!, skriv stop för att avsluta ärendet.");
        // ett meddelande till användaren

        String input = ""; // vi deklarerar denna variabel för att lagra texten som användaren skriver

        while (true) { // vi kör en while loop som körs tills användaren skriver ordet Stop eller stop
            String line = scan.nextLine();

            if (line.equals("stop") || line.equals("Stop")) {
                break;
            }

            input += line + "\n";

        }

        // Skapa en instans av TextCounter och skicka med den inmatade texten
        TextCounter textCounter = new TextCounter(input);

        // Anropa countPrinter-metoden på den skapade instansen
        textCounter.countPrinter();


    }
 }
