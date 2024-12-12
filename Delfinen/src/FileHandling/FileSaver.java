package FileHandling;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import MembersList;

public class FileSaver {

    public static void saveMemberData () {
        try {
            File data = new File("FileHandling/Members.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(data));
            for (Member m : MembersList.get);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void saveResultData () {

    }



}
