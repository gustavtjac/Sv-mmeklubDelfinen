import java.util.Scanner;

public class CreateResult {

    public static void createNewResult() { //Metode til at oprette nyt stævneresultat inkl. brugerinteraktion
        Scanner sc = new Scanner(System.in);
        int swimmerID; //evt. -1
        String tournamentName;
        String date;
        double timeResult;
        int tournamentPlacement;
        SwimmingDisciplines swimmingDiscipline = null;


        //showMemberList();
        while (true) {
            System.out.println("-------------------------------");
            try {
                System.out.println("Indtast svømmerens ID");
                swimmerID = Integer.parseInt(sc.nextLine());

                System.out.println("Indtast stævnets navn");
                tournamentName = sc.nextLine();

                System.out.println("Indtast dato DD/MM/YY");
                date = sc.nextLine();

                System.out.println("Indtast svømmerens tid i sekunder [XX.XX]");
                timeResult = Double.parseDouble(sc.nextLine());

                System.out.println("Indtast svømmerens placering i stævnet");
                tournamentPlacement = Integer.parseInt(sc.nextLine());

                System.out.println("---------------------------------------");
                System.out.println("Vælg svømmedisciplin:");
                for (SwimmingDisciplines sd : SwimmingDisciplines.values()) {
                    System.out.println(sd.ordinal() + 1 + ": " + sd); //ordinal = indeks af enum
                }
                int index = Integer.parseInt(sc.nextLine());
                if (index < 1 || index > SwimmingDisciplines.values().length) {
                    System.out.println("Forkert input. vælg et tal fra listen!");
                }
                SwimmingDisciplines selectedDiscipline = SwimmingDisciplines.values()[index - 1];
                new CompetitionResult(tournamentName, date, timeResult, tournamentPlacement, swimmingDiscipline, swimmerID);
                System.out.println("Nyt resultat oprettet");
                break;
            } catch (Exception e) {
                System.out.println("Forkert input");
            }
        }
    }

}
