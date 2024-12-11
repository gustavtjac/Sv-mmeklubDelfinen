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
                    CreateResult.createNewResult();
                    break;
                case 3:
                    // Lav vis medlemmer funktionalitet
                    break;
                case 4:
                    chooseFour();
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
        System.out.println("Vælg svømmedisciplin:");
        for (SwimmingDisciplines sd : SwimmingDisciplines.values()) {
            System.out.println(sd.ordinal() + 1 + ": " + sd); //ordinal = indeks af enum
        }
    }
}

