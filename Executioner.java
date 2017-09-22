
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @authors Harry Kapnas,Konstantinos Chronis
 */
public class Executioner {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Toy databse used is included in the text file named testText.txt
        //If the file lies within the program's directory, only its name is needed
        //Otherwise, provide the full filepath.
        Feeder fd = new Feeder();
        fd.setKeyValues();
        //Auxiliary command to get info about a student by providing their SSN (primary key).
        //Uncomment below to test the database.
        fd.valuesPrinter("Student:81129");
       // fd.valuesPrinter("Grade:12938");
        fd.valuesPrinter("Student:72938");
       // fd.valuesPrinter("Grade:80298");
        fd.valuesPrinter("Student:97463");
        //fd.valuesPrinter("Grade:76849");
    }
}
