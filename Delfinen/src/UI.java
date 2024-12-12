import java.util.ArrayList;
import java.util.Scanner;

public class UI { // Hovedmenu med forskellige submenuer, dog med lidt manglende funktionalitet
    public static void main(String[] args) {
        UI menu = new UI();
        menu.showMenu();
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Hovedmenu:");
            System.out.println("1. Opret medlem");
            System.out.println("2. Opret resultat");
            System.out.println("3. Vis medlemmer");
            System.out.println("4. Vis top 5 konkurrence resultater");
            System.out.println("5. Vis kontingentinformation");
            System.out.println("6. Luk program");


            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    CreateMember.createNewMember();
                    break;
                case 2:
                    CreateNewResultUI();
                    break;
                case 3:
                    MembersList.displayMembers();
                    break;
                case 4:
                    chooseFour();
                    /*ResultList.showTopFiveResults();*/
                    break;
                case 5:
                    // Lav vis kontingentinformation funktionalitet
                    break;
                case 6:
                    System.out.println("Lukker programmet...");
                    sc.close();
                    return;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    public static void chooseFour() {
        Scanner sc = new Scanner(System.in);
        SwimmingDisciplines selectedDiscipline = null;
        MembershipFees selectedMembership = null;
        System.out.println("Vælg svømmedisciplin:");
        for (SwimmingDisciplines sd : SwimmingDisciplines.values()) {
            System.out.println(sd.ordinal() + 1 + ": " + sd); //ordinal = indeks af enum
        }
        try {
            int index = Integer.parseInt(sc.nextLine());
            if (index < 1 || index > SwimmingDisciplines.values().length) {
                System.out.println("Forkert input. vælg et tal fra listen!");
            }
            selectedDiscipline = SwimmingDisciplines.values()[index - 1];
        } catch (Exception e) {
            System.out.println("forkert input");
        }
        System.out.println("Vælg kategori:");
        for (MembershipFees membership : MembershipFees.values()) {
            System.out.println(membership.ordinal() + 1 + ": " + membership); //ordinal = indeks af enum
        }
        try {
            int index = Integer.parseInt(sc.nextLine());
            if (index < 1 || index > SwimmingDisciplines.values().length) {
                System.out.println("Forkert input. vælg et tal fra listen!");
            }
            selectedMembership = MembershipFees.values()[index - 1];
        } catch (Exception e) {
            System.out.println("forkert input");
        }
        ArrayList<Result> tempResults = MembersList.sortedResultList(selectedMembership, selectedDiscipline);
        for (Result r : tempResults){
            System.out.println(r.toString());
        }
        if(tempResults.size() < 1) {
            System.out.println("Der findes ingen resultater");
        } else if (tempResults.size() < 5) {
            for (int i = 0; i < tempResults.size() - 1; i++) {
                tempResults.get(i).toString();
            }} else {
                for (int i = 0; i < 5; i++) {
                    tempResults.get(i).toString();
                }
            }
        }

    public static void CreateNewResultUI(){
        boolean running = true;
        Scanner sc = new Scanner(System.in);

while(running) {
    System.out.println("Trænings[1]-/Konkurrenceresultat[2]");
    String temp = sc.nextLine();
    if (temp.equalsIgnoreCase("1")) {
        createTrainingResult();
        break;
    } else if (temp.equalsIgnoreCase("2")) {
        createCompetitionResult();
        break;
    } else {
        System.out.println("Forkert input");
    }
}


    }

    public static void createTrainingResult() {
        Scanner sc = new Scanner(System.in);
        int swimmerID; //evt. -1
        String date;
        double timeResult;
        SwimmingDisciplines swimmingDiscipline = null;
        System.out.println("-------------------------------");
        try {
            System.out.println("Indtast svømmerens ID");
            swimmerID = Integer.parseInt(sc.nextLine());

            System.out.println("Indtast dato DD/MM/YY");
            date = sc.nextLine();

            System.out.println("Indtast svømmerens tid i sekunder [XX.XX]");
            timeResult = Double.parseDouble(sc.nextLine());


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
            new TrainingResult(date, timeResult, swimmerID, swimmingDiscipline);
            System.out.println("Nyt resultat oprettet");
        } catch (Exception e) {
            System.out.println("Forkert input");
        }
    }

    public static void createCompetitionResult() {
        Scanner sc = new Scanner(System.in);
        int swimmerID; //evt. -1
        String date;
        double timeResult;
        String tournamentName;
        int tournamentPlacement;
        SwimmingDisciplines swimmingDiscipline = null;
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
            new CompetitionResult(tournamentName, date, timeResult, tournamentPlacement, selectedDiscipline, swimmerID);
            System.out.println("Nyt resultat oprettet");
        } catch (Exception e) {
            System.out.println("Forkert input");
            e.printStackTrace();
        }
    }
}

