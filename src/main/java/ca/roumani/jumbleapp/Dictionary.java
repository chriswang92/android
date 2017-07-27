package ca.roumani.jumbleapp;



        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.PrintStream;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class Dictionary {

    private static int time;
    private static boolean foundBefore;
    public List<String> wordsInFile;
    public Dictionary(){

    }
    public Dictionary(File file)
    {
        this.wordsInFile  = new ArrayList<String>();
        try
        {
            Scanner input = new Scanner(file);

            while (input.hasNextLine())
            {
                String word = input.nextLine();
                wordsInFile.add(word);
            }
            input.close();
        }
        catch (FileNotFoundException e)
        {
            // do nothing
        }
    }
    public List<String> getUnscramblings(String thisString){
        List<String> list = new ArrayList<String>();
        //List<String> thisFootPrint = Dictionary.getFootPrint(thisString);
        for(String word : this.wordsInFile){
                if(isJumble(thisString,word)){
                    list.add(word);
                }
        }
        return list;

    }
    public static List<String> getFootPrint(String word){
        List<String> list = new ArrayList<String>();
        for(int i=0;i < word.length();i++){
            time = 1;
            foundBefore = false;
            for(int j=0;j < word.length();j++){
                if(word.charAt(i) == word.charAt(j) && i!=j){
                    time++;
                    if(j < i){
                        foundBefore = true;
                    }
                }
            }
            if(!foundBefore){
                list.add(String.format("(%s, %d)", word.charAt(i),time));
            }
        }
        return list;

    }
    //one word is a jumble of another one if and only if they have the same foot print.
    public static boolean isJumble(String thisString, String anotherString){
        if(thisString.equals(anotherString) || thisString.length() != anotherString.length()){
            return false;
        }
        List<String> thisFootPrint = getFootPrint(thisString);
        List<String> thatFootPrint = getFootPrint(anotherString);
        if(thisFootPrint.size() != thatFootPrint.size()){
            return false;
        }
        for(int i=0;i < thisFootPrint.size();i++){
            if(!thatFootPrint.contains(thisFootPrint.get(i))
                    || !thisFootPrint.contains(thatFootPrint.get(i))){
                return false;
            }
        }
        return true;
    }

}