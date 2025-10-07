package FIleReader;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {

    public static int CountWord(String filePath,String word){
        
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine()) != null){
                String[] w = line.split("\\W+");
                for(String ww : w){
                    if(ww.equals(word)){
                        count++;
                    }
                }
            }
        }
        catch(IOException e){
            System.err.println("Error :"+e.getMessage());
        }
        return count;
    }
    
    public static void main(String[] args) {
        String filePath = "D:\\JavaPracitce\\FIleReader\\sample.txt";
        String word = "Java";
        int count = CountWord(filePath,word);
        System.out.println("There are "+count+ " in "+filePath);
    }
    
}
