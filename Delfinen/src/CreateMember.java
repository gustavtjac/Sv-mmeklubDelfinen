import java.util.ArrayList;
import java.util.Scanner;

public class CreateMember {

    //Metode til at oprette nyt medlem inkl. brugerinteraktion
    public static void createNewMember() {
        Scanner sc = new Scanner(System.in);
        String name;
        boolean activity = false;
        int age;

        while (true) {
            try {
                System.out.println("Indtast navn:");
                name = sc.nextLine();

                System.out.println("Indtast alder:");
                age = Integer.parseInt(sc.nextLine());

                if (age < 0) {
                    System.out.println("Alder kan ikke være negativ. Prøv igen.");
                    continue;
                }

                System.out.println("Er medlemmet aktiv? (true/false):");
                activity = Boolean.parseBoolean(sc.nextLine());

                System.out.println("Er det en konkurrence eller motionssvømmer? (1 for konkurrence, 2 for motionist):");
                int swimmerType = Integer.parseInt(sc.nextLine());

                if (swimmerType == 1) {
                    new CompetitiveSwimmer(name, activity, age,false).setSwimmingDisciplines();
                    FileSaver.saveMemberData();
                    System.out.println("Ny konkurrencesvømmer oprettet");
                } else if (swimmerType == 2) {
                   new CasualSwimmer(name, activity, age,false);
                    FileSaver.saveMemberData();
                    System.out.println("Ny motionist oprettet");
                } else {
                    System.out.println("Ugyldigt valg. Indtast 1 eller 2.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt input. Sørg for at indtaste et gyldigt tal.");
            } catch (Exception e) {
                System.out.println("Der opstod en fejl. Prøv igen.");
            }
            System.out.println("________________________");
        }
    }


}
