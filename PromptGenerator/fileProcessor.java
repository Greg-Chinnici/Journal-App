import java.util.ArrayList;
import java.lang.String;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 


public class fileProcessor extends Prompt{
    public static String inputfileName = "prompts.txt";
    public static ArrayList<String> emotionBuffer = new ArrayList<String>(); // could be an enum

    public static void main(String[] args)
    {
        try {
            File file = new File("prompts.txt");
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                String txtLine = Reader.nextLine();
                processLine(txtLine);
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR file processer cant find the file.");
            e.printStackTrace();
        }
    }



    private static void processLine(String line){
        if (line.length() <= 1){return;} //nothing usefull so exit the line
        if (getFirstWord(line).equals("Themes:")){
            processThemeLine(line);
        }else{
            processPromptLine(line);
        }
    }

    public static String getFirstWord(String line) {
        return line.split(" ")[0];
    }

    public static void processThemeLine(String line){
        if (line.length() <= 8){return;}//blank themes
        for (String word : line.split(" ")){
            if (!(word.equals("Themes:"))){
                emotionBuffer.add((word.toLowerCase()));
            }
        }
    }

    public static void processPromptLine(String line){
        Prompt p = new Prompt(line, emotionBuffer); 
        PromptList.addPromtToList(p);

        emotionBuffer.clear(); // clear after add 
    }
}
