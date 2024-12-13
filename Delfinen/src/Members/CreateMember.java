package Members;

import FileHandling.FileSaver;

import java.util.Scanner;

public class CreateMember {

    //Metode til at oprette nyt medlem inkl. brugerinteraktion
    public static void createNewMember(String name,boolean activity,int age,int swimmerType) {
        Scanner sc = new Scanner(System.in);

                if (swimmerType == 1) {
                    new CompetitiveSwimmer(name, activity, age,false).setSwimmingDisciplines();
                    FileSaver.saveMemberData();
                    System.out.println("Ny konkurrencesvømmer oprettet");
                } else if (swimmerType == 2) {
                   new CasualSwimmer(name, activity, age,false);
                    FileSaver.saveMemberData();
                    System.out.println("Ny motionist oprettet");
                }

            System.out.println("________________________");
        }



}
