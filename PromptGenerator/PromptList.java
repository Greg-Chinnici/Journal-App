import java.util.ArrayList;
import java.util.Collections;
import java.lang.String;
import java.util.Random;

public class PromptList {
    
    private static ArrayList<Prompt> prompts = new ArrayList<Prompt>();
    private static Random random = new Random();

    public static void main(String[] args){
        //call the main method of file processor
        String[] ar = {"prompts.txt"}; 
        fileProcessor.main(ar);


        //get user input on what to get 
        System.out.println(getRandomPrompt());
        System.out.println(getPromptByTheme("happy"));
        System.out.println(getPromptByTheme("happy"));


    }

    public static void addPromtToList(Prompt p){
        prompts.add(p);
    }

    public static String getRandomPrompt(){
        return prompts.get(random.nextInt(prompts.size())).getPrompt();
    }

    public static String getPromptByTheme(String theme){
        Collections.shuffle(prompts);
        for (Prompt p : prompts){ // worst case n^2 
            if (p.isCorrectEmotion(theme.toLowerCase())){
                return p.getPrompt();
            }
        }
        //it couldnt find one that matches
        return getRandomPrompt();
    }
}
