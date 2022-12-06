import java.util.ArrayList;
import java.lang.String;


public class Prompt{
    private String prompt;
    private ArrayList<String> emotionList;


    Prompt(){
        String prompt = "";
        ArrayList<String> emotionList = null;
    }
    Prompt(String promptIn, ArrayList<String> emotionListIn){
        prompt = promptIn;
        emotionList = emotionListIn;
    }
    

    public void setPromt(String promptIn){
        prompt = promptIn;
    }
    public String getPrompt(){
        return prompt;
    }

    public Boolean isCorrectEmotion(String emotionToLookfor){
        for (String e : emotionList){
            if (e.equals(emotionToLookfor)){
                return true;
            }
        }
        return false;
    }
    
    public void addEmotion(String emotionIn){
        emotionList.add(emotionIn);
    }
}