

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @authors Harry Kapnas,Konstantinos Chronis
 */
public class Reader {
    
    private String path;
    int counter=0;
    ArrayList<String> textFile= new ArrayList<>();
    
    /*Constructor where the initial txt object is created.
    We don't use a try-catch sttement because we have implemented a manual control
    on whether the filepath exists.
    */
    public Reader(String path) throws FileNotFoundException, IOException{
        setPath(path);
        loadFile();
    }
    
    //Path setter and and buffer creator. We will use br later to extract what we need from txt
    public void setPath(String path) throws FileNotFoundException {
        this.path = path;
    }
    
    //Class to load the txt. The txt file is stored in an ArrayList in order to be
    //processed more easily by the methods that follow.
    private ArrayList<String> loadFile() throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while((line=br.readLine())!=null){
                this.textFile.add(line);
            }
        }
        System.out.println("File Loaded");
        System.out.println("======================");
        return this.textFile;
    }
    
    //Extract title
    public String getTitle(){
        String title = this.textFile.get(0);
        return title;
    }
    
    //Extract attributes. I use a counter to store the number of lines that contain attributes
    public ArrayList<String> getAttributes() throws FileNotFoundException, IOException{
        ArrayList<String> atts = new ArrayList<>();        
        for(int i=1;i<textFile.size();i++){
            if(!textFile.get(i).equals(";")){
                atts.add(textFile.get(i));
                counter++;
            }else{
                break;
            }
        }
        return atts;
    }
    
    //Extract key-values
    public ArrayList<String[]> getValues() throws FileNotFoundException, IOException{
        int lines = numLines(path);
        ArrayList<String[]> values = new ArrayList<>();
        
        for(int i=counter+2;i<lines;i++){
            String[] tmp=textFile.get(i).split(";");
            values.add(tmp);
        }        
        return values;       
    }
    
    //Number of lines calculator
    private int numLines(String path) throws IOException{
        BufferedReader bf = new BufferedReader(new FileReader(path));
        
        String line;
        int totalNumber=0;
        
        while ((line=bf.readLine())!=null){
           totalNumber++;
        }
        bf.close();
        return totalNumber;
    }
      
}
