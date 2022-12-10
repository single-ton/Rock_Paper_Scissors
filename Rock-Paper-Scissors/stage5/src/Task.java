import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.print("Enter your name:");
        String name = reader.readLine();
        System.out.printf("Hello, %s%n", name);

        Path path = Paths.get("rating.txt");
        List<String> listStrings = Files.readAllLines(path);
        int rating = 0;
        for (String s : listStrings) {
            if (s.split(" ")[0].equals(name))
                rating = Integer.parseInt(s.split(" ")[1]);
        }
        String basic = reader.readLine();
        String[] values;
        String[] keys;
        if (basic.equals("")) {
            keys = new String[]{"scissors", "rock", "paper"};
            values = new String[]{"rock", "paper", "scissors"};
        } else {
            keys = new String[]{"rock", "gun", "lightning", "devil", "dragon", "water", "air", "paper", "sponge", "wolf", "tree",
                    "human", "snake", "scissors", "fire"};
            values = new String[15];
            String[] list = {"lightning", "gun", "air", "water", "dragon", "paper", "devil"};
            int j = 0;
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"lightning", "sponge", "air", "water", "dragon", "paper", "devil"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"wolf", "sponge", "air", "water", "dragon", "paper", "devil"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"wolf", "sponge", "air", "water", "dragon", "paper", "tree"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"wolf", "sponge", "air", "water", "human", "paper", "tree"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"wolf", "sponge", "air", "snake", "human", "paper", "tree"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"wolf", "sponge", "scissors", "snake", "human", "paper", "tree"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"wolf", "sponge", "scissors", "snake", "human", "fire", "tree"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"wolf", "rock", "scissors", "snake", "human", "fire", "tree"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"gun", "rock", "scissors", "snake", "human", "fire", "tree"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"gun", "rock", "scissors", "snake", "human", "fire", "lightning"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"gun", "rock", "scissors", "snake", "devil", "fire", "lightning"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"gun", "rock", "scissors", "dragon", "devil", "fire", "lightning"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"gun", "rock", "water", "dragon", "devil", "fire", "lightning"};
            values[j] = String.join("\n", list);
            j++;
            list = new String[]{"lightning", "gun", "air", "water", "dragon", "rock", "devil"};
            values[j] = String.join("\n", list);
        }
        Random r = new Random();
        int len = keys.length;
        int randIndex;

        System.out.println("Okay, let's start");
        while(true) {
            randIndex = r.nextInt(len);
            String hand = reader.readLine();
            if (Arrays.asList(keys).contains(hand)) {
                if (hand.equals(keys[randIndex])) {
                    System.out.printf("There is a draw (%s)\n", keys[randIndex]);
                    rating += 50;
                } else if (values[randIndex].contains(hand)) {
                    System.out.printf("Well done. The computer chose %s and failed\n", keys[randIndex]);
                    rating += 100;
                } else
                    System.out.printf("Sorry, but the computer chose %s\n", keys[randIndex]);
            } else if (hand.equals("!exit")) {
                System.out.println("Bye!");
                break;
            } else if (hand.equals("!rating")) {
                System.out.printf("Your rating: %s\n",rating);
            }
            else
                System.out.println("Invalid input");
        }
    }
}