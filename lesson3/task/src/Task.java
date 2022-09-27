import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Task {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        for(;;){
            // Reading input
            String input = reader.readLine().toLowerCase();
            Random r = new Random(System.nanoTime());
            int index = r.nextInt(3);
            String randomResult = cases[index];
            if(input.equals(randomResult))
                System.out.printf("There is a draw (%s)\n", randomResult);
            else if(getWin(input).equals(randomResult))
                System.out.printf( "Sorry, but the computer chose %s\n", randomResult);
            else if(input.equals(getWin(randomResult)))
                System.out.printf("Well done. The computer chose %s and failed\n", randomResult);
            else if(input.equals("!exit")) {
                System.out.println("Bye!");
                break;
            }
            else
                System.out.println("Invalid input");

        }


    }
    static String[] cases = new String[]{"rock",
            "paper",
            "scissors"};
    static String getWin(String input){
        for(int i=0;i<cases.length;i++)
            if(input.equals(cases[i])){
                if(i+1<cases.length)
                    return cases[i+1];
                else
                    return cases[0];
            }
        return "NotExist";
    }
    static String getOutput(String input){
        return String.format("Sorry, but the computer chose %s",getWin(input));
    }
}