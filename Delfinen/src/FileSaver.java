


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class FileSaver {

    public static void saveMemberData () {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Delfinen/src/Members.txt"));

            for (Member m : MembersList.getMemberList()){
                bw.write(m.writeMemberData());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Kunne ikke finde fil");
            e.printStackTrace();
        }
    }


    public static void saveResultData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Delfinen/src/Results.txt"));

            for (Result r : ResultList.getResultList()) {
                bw.write(r.writeResultData());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Kunne ikke finde fil");
            e.printStackTrace();
        }
    }



}
