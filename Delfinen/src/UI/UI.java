package UI;

import Enums.*;
import FileHandling.*;
import Members.*;
import Result.*;


import java.util.ArrayList;
import java.util.Scanner;

public class UI { // Hovedmenu med forskellige submenuer, dog med lidt manglende funktionalitet

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        FileReader.loadMembers();
        FileReader.loadResults();
        while (true) {
            System.out.println("Hovedmenu:");
            System.out.println("1. Opret medlem");
            System.out.println("2. Opret resultat");
            System.out.println("3. Vis medlemmer");
            System.out.println("4. Vis top 5 konkurrence resultater");
            System.out.println("5. Vis kontingentinformation");
            System.out.println("6. Luk program");
            System.out.println("-------------------------------------------");


            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    gatherNewMemberInfo();
                    break;
                case "2":
                    CreateNewResult();
                    break;
                case "3":
                    MembersList.displayMembers();
                    break;
                case "4":
                    showTopFiveResults();
                    break;
                case "5":
                    showMemberFeeInfo();
                    break;
                case "6":
                    System.out.println("Lukker programmet...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
                    break;
            }
        }
    }

    public static void showTopFiveResults() {
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


    public static void showMemberFeeInfo() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    1. Vis total kontingentinformation
                    2. Vis medlemmer i restance""");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("1")) {
                System.out.println("Forventede kontigent for i år:\n" + MembersList.calculateTotalMembershipFees()+"\n----------------");
                break;

            } else if (choice.equalsIgnoreCase("2")) {
                if (MembersList.showMembersInArrears().isEmpty()) {
                    System.out.println("Ingen medlemmer i restance"+"\n----------------");
                    break;
                } else {
                    System.out.println("Alle medlemmer i restance:");
                    for (Member m : MembersList.showMembersInArrears()) {
                        System.out.println(m);
                        System.out.println("-------------------------------------------");
                    }
                    break;
                }

            } else {
                System.out.println("Forkert input");
            }
        }
    }
    public static void CreateNewResult(){
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
        while (true) {
            System.out.println("-------------------------------------------");
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
                new TrainingResult(date, timeResult, swimmerID, selectedDiscipline);
                FileSaver.saveResultData();
                System.out.println("Nyt resultat oprettet");
                System.out.println("--------------");
                break;
            } catch (Exception e) {
                System.out.println("Forkert brug den korrekte datatype");
            }
        }
    }

    public static void createCompetitionResult() {
        Scanner sc = new Scanner(System.in);
        int swimmerID = -1;
        String date = "";
        double timeResult = -1.0;
        String tournamentName = "";
        int tournamentPlacement = -1;
        SwimmingDisciplines selectedDiscipline = null;

        while (true) {
            try {

                System.out.println("-------------------------------------------");
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


                System.out.println("-------------------------------------------");
                System.out.println("Vælg svømmedisciplin:");
                for (SwimmingDisciplines sd : SwimmingDisciplines.values()) {
                    System.out.println(sd.ordinal() + 1 + ": " + sd); // ordinal = index of enum
                }
                int index = Integer.parseInt(sc.nextLine());
                if (index < 1 || index > SwimmingDisciplines.values().length) {
                    System.out.println("Forkert input. Vælg et tal fra listen!");
                }
                selectedDiscipline = SwimmingDisciplines.values()[index - 1];


                if (selectedDiscipline != null) {
                    new CompetitionResult(date, timeResult, swimmerID, selectedDiscipline, tournamentName, tournamentPlacement);
                    FileSaver.saveResultData();
                    System.out.println("Nyt resultat oprettet");
                    System.out.println("-------------------------------------------");
                    break;
                } else {
                    System.out.println("No discipline selected. Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Forkert input. Sørg for at indtaste et gyldigt tal.");
            } catch (Exception e) {
                System.out.println("Forkert input. Der opstod en fejl.");
                e.printStackTrace();
            }
        }
    }
    public static void gatherNewMemberInfo() {
        String name;
        boolean activity = false;
        int age;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Indtast navn:");
                name = sc.nextLine();

                System.out.println("Indtast alder:");
                age = Integer.parseInt(sc.nextLine());

                if (age < 0) {
                    System.out.println("Alder kan ikke være negativ. Prøv igen.");
                }

                System.out.println("Er medlemmet aktiv? (true/false):");
                activity = Boolean.parseBoolean(sc.nextLine());

                System.out.println("Er det en konkurrence eller motionssvømmer? (1 for konkurrence, 2 for motionist):");
                int swimmerType = Integer.parseInt(sc.nextLine());
                CreateMember.createNewMember(name, activity, age, swimmerType);
                break;
            }
         catch (NumberFormatException e) {
            System.out.println("Ugyldigt input. Sørg for at indtaste et gyldigt tal.");
        } catch (Exception e) {
            System.out.println("Der opstod en fejl. Prøv igen.");
        }
        }
    }

}

