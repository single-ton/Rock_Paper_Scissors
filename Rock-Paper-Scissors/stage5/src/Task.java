import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<String, String> options = new HashMap<String, String>();
        if(basic.equals("")) {
            options.put("scissors", "rock");
            options.put("rock", "paper");
            options.put("paper", "scissors");
        }
        else {
            String[] list={"lightning", "gun", "air", "water", "dragon", "paper", "devil"};
            options.put("rock", String.join("\n",list));
            list=new String[]{"lightning", "sponge", "air", "water", "dragon", "paper", "devil"};
            options.put("gun", String.join("\n",list));
            list=new String[]{"wolf", "sponge", "air", "water", "dragon", "paper", "devil"};
            options.put("lightning", String.join("\n",list));
            list=new String[]{"wolf", "sponge", "air", "water", "dragon", "paper", "tree"};
            options.put("devil", String.join("\n",list));
            list=new String[]{"wolf", "sponge", "air", "water", "human", "paper", "tree"};
            options.put("dragon", String.join("\n",list));
            list=new String[]{"wolf", "sponge", "air", "snake", "human", "paper", "tree"};
            options.put("water", String.join("\n",list));
            list=new String[]{"wolf", "sponge", "scissors", "snake", "human", "paper", "tree"};
            options.put("air", String.join("\n",list));
            list=new String[]{"wolf", "sponge", "scissors", "snake", "human", "fire", "tree"};
            options.put("paper", String.join("\n",list));
            list=new String[]{"wolf", "rock", "scissors", "snake", "human", "fire", "tree"};
            options.put("sponge", String.join("\n",list));
            list=new String[]{"gun", "rock", "scissors", "snake", "human", "fire", "tree"};
            options.put("wolf", String.join("\n",list));
            list=new String[]{"gun", "rock", "scissors", "snake", "human", "fire", "lightning"};
            options.put("tree", String.join("\n",list));
            list=new String[]{"gun", "rock", "scissors", "snake", "devil", "fire", "lightning"};
            options.put("human", String.join("\n",list));
            list=new String[]{"gun", "rock", "scissors", "dragon", "devil", "fire", "lightning"};
            options.put("snake", String.join("\n",list));
            list=new String[]{"gun", "rock", "water", "dragon", "devil", "fire", "lightning"};
            options.put("scissors", String.join("\n",list));
            list=new String[]{"lightning", "gun", "air", "water", "dragon", "rock", "devil"};
            options.put("fire", String.join("\n",list));

        }
        Random r = new Random();
        int len = options.keySet().size();
        int randIndex = r.nextInt(0,len);

        System.out.println("Okay, let's start");
        while(true){
            randIndex = r.nextInt(0,len);
            String option="121212121";
            int i=0;
            for(String s:options.keySet()){
                if(i==randIndex) {
                    option = s;
                    break;
                }
                i++;
            }

            String hand = reader.readLine();

            if(options.containsKey(hand)) {
                if(options.size()>3){
                    i++;
                    i--;
                }
                if (hand.equals(option)) {
                    System.out.printf("There is a draw (%s)\n", option);
                    rating += 50;
                } else if (options.get(option).contains(hand)) {
                    System.out.printf("Well done. The computer chose %s and failed\n", option);
                    rating+=100;
                }
                else
                    System.out.printf("Sorry, but the computer chose %s\n",option);
            }
            else if(hand.equals("!exit")){
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