
import java.io.File;
import java.util.Scanner;

/**
 *
 * @authors Harry Kapnas,Konstantinos Chronis
 */
public class UserInput {
    
    String path;
 
    public UserInput(){
        
    }
    
    public String inputInterface(){
        System.out.println("Please provide the path to the text file:");
        Scanner scanner = new Scanner(System.in);
        path = scanner.nextLine();
        while(!(new File(path).exists())){
            System.out.println("Invalid Path!");
            System.out.println("Try again!");
            System.out.println("======================");
            System.out.println("Please provide the path to the text file:");
            path = scanner.nextLine();
        }
        return path;
    }    
    
}
