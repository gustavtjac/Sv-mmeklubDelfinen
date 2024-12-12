import java.util.ArrayList;
import java.util.Comparator;
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

    public static CompetitiveSwimmer matchIDFromResult(Result result) {
        CompetitiveSwimmer nullM = null;
        for (Member m : memberList) {
            if (m instanceof CompetitiveSwimmer) {
                // This ensures that m is a CompetitiveSwimmer or a subclass of it
                CompetitiveSwimmer swimmer = (CompetitiveSwimmer) m;  // Cast to CompetitiveSwimmer
                if (result.getSwimmerID() == m.getMemberID()) {
                    return swimmer;  // Return the CompetitiveSwimmer if IDs match
                }
            }
        }
        return null;  // Return null if no match found
    }

    public static ArrayList<Result> sortedResultList (MembershipFees membership, SwimmingDisciplines swimmingDiscipline) {
        ArrayList<Result> tempResultList = new ArrayList<>();
        for (Member m : memberList) {
            if (m instanceof CompetitiveSwimmer) {
                for (Result result : ((CompetitiveSwimmer) m).getSwimmerResultList()) {
                    if (result.getSwimmingDiscipline().equals(swimmingDiscipline) && m.getMembershipFee() == membership.getFee()) {
                        tempResultList.add(result);
                    }
                }
            }
        }
        tempResultList.sort(Comparator.comparingDouble(Result::getTimeResult));
        return tempResultList;
    }
    public static double calculateTotalMembershipFees () {
        double totalMembersFees = 0;
        for (Member m : memberList) {
            totalMembersFees += m.getMembershipFee();
        }
        return totalMembersFees;
    }

    public static ArrayList<Member> showMembersInArrears() {
        ArrayList<Member> tempList = new ArrayList<>();
        for (Member m : memberList) {
            if (m.getInArrears()) {
                tempList.add(m);
            }
        }
        return tempList;
    }


}
