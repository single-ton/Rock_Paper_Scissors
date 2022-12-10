import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task {
    //public static void main(String[] args){
    //System.out.println("Hello World!");
    //}
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        // Reading input
        String input = reader.readLine();
        // Printing output
        System.out.println(getOutput(input));
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
        return String.format("Sorry0, but the computer chose %s",getWin(input));
    }
}