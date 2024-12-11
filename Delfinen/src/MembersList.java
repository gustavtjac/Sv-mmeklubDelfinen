import java.util.ArrayList;
import java.util.Scanner;

public class MembersList {
    private static ArrayList<Member> memberList = new ArrayList<>();


    public static ArrayList<Member> getMemberList() {
        return memberList;
    }
public static void displaySpecficCasualSwimmer(MembershipFees membershipFees) {
    for (Member m : memberList) {
        if (m.getClass() == CasualSwimmer.class && m.getMembershipFee() == membershipFees.getFee()) {
            System.out.println(m);
        }
    }
}
    public static void displaySpecficCompetitivelSwimmer(MembershipFees membershipFees) {
        for (Member m : memberList) {
            if (m.getClass() == CompetitiveSwimmer.class && m.getMembershipFee() == membershipFees.getFee()) {
                System.out.println(m);
            }
        }
    }
public static void displayAllMembers(){
    for (Member m : memberList) {
            System.out.println(m);
    }
}
public static void displayMembersOnCategory(Class s){
    for (Member m : memberList) {
        if (m.getClass() == s) {
            System.out.println(m);
        }
    }
}

public static void displayCasualSwimmers(){
Scanner sc = new Scanner(System.in);
boolean running = true;
while(running) {
    System.out.println("1. Vis alle motionister");
    System.out.println("2. Vis junior motionister");
    System.out.println("3. Vis senior motionister");
    System.out.println("4. Vis pensionerede motionister");
    String temp = sc.nextLine();
    switch (temp) {
        case "1":
            displayMembersOnCategory(CasualSwimmer.class);
            running = false;
            break;
        case "2":
            displaySpecficCasualSwimmer(MembershipFees.JUNIOR);
            running = false;
            break;
        case "3":
            displaySpecficCasualSwimmer(MembershipFees.SENIOR);
            running = false;
            break;
        case "4":
            displaySpecficCasualSwimmer(MembershipFees.RETIREE);
            running = false;
            break;
        default:
            System.out.println("forkert input");
            break;

    }
}


}
    public static void displayCompetitiveSwimmers(){
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("1. Vis alle konkurrencesvømmere");
            System.out.println("2. Vis junior konkurrencesvømmere");
            System.out.println("3. Vis senior konkurrencesvømmere");
            System.out.println("4. Vis pensionerede konkurrencesvømmere");
            String temp = sc.nextLine();
            switch (temp) {
                case "1":
                    displayMembersOnCategory(CompetitiveSwimmer.class);
                    running = false;
                    break;
                case "2":
                    displaySpecficCompetitivelSwimmer(MembershipFees.JUNIOR);
                    running = false;
                    break;
                case "3":
                    displaySpecficCompetitivelSwimmer(MembershipFees.SENIOR);
                    running = false;
                    break;
                case "4":
                    displaySpecficCompetitivelSwimmer(MembershipFees.RETIREE);
                    running = false;
                    break;
                default:
                    System.out.println("forkert input");
                    break;

            }
        }
    }

    public static void displayMembers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Vis alle medlemmer");
        System.out.println("2. Vis motionister");
        System.out.println("3. Vis konkurrencesvømmere");
        String temp = sc.nextLine();
        switch (temp) {
            case "1":
                displayAllMembers();
                break;
            case "2":
                 displayCasualSwimmers();
                 break;
            case "3":
                  displayCompetitiveSwimmers();
                  break;
            default:
                  System.out.println("Forkert input");
                  break;
        }
    }

}
