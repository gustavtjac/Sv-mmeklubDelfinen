package Members;
import Enums.*;


import Result.*;


import java.util.ArrayList;
import java.util.Scanner;
public class CompetitiveSwimmer extends Member {
    private ArrayList<SwimmingDisciplines> swimDisciplines = new ArrayList<>();
    private ArrayList<Result> swimmerResultList = new ArrayList<>();


    public CompetitiveSwimmer(String name, boolean isMemberActive, int age,  boolean inArreas,ArrayList<SwimmingDisciplines> swimmingDisciplines) {
        super(name, isMemberActive, age,inArreas);
        this.membershipFee = calculateMembershipFee();
        this.swimDisciplines = swimmingDisciplines;

    }


    public CompetitiveSwimmer(String name, boolean isMemberActive, int age, boolean inArreas) {
        super(name, isMemberActive, age, inArreas);
        this.membershipFee = calculateMembershipFee(); //Kalder metode der beregner kontingent
        this.inArrears = false;
    }

    public CompetitiveSwimmer() {
    }

    public void setSwimDisciplines(ArrayList<SwimmingDisciplines> swimDisciplines) {
        this.swimDisciplines = swimDisciplines; //Setter konkurrencesvømmerens disciplin
    }

    public String toString() { // ændret i opsætningen for den visuelle præsentation
        return "Navn: " + this.name + "\nKotigentbeløb: " + this.membershipFee + "\nAktiv?: " + this.isMemberActive + "\nAlder: " + this.age + "\nI Restance: " + this.inArrears + "\nDiscipliner: " + this.swimDisciplines.toString() + "\nID: " + this.memberID + "\nResultater:\n" + swimmerResultList;
    }
        public void setSwimmingDisciplines() {
            Scanner sc = new Scanner(System.in);
            String tempSvar = "";

            while (true) {
                System.out.println("---------------------------------------");
                System.out.println("Discipliner:");
                for (SwimmingDisciplines sd : SwimmingDisciplines.values()) {
                    System.out.println(sd.ordinal() + 1 + ": " + sd);
                }
                System.out.println("Tryk 0 for at markere at du er færdig");
                System.out.print("Skriv nummeret på den disciplin du vil tilføje ");

                tempSvar = sc.nextLine();

                if (tempSvar.equals("0")) {
                    break;
                }

                try {
                    int index = Integer.parseInt(tempSvar);
                    if (index < 1 || index > SwimmingDisciplines.values().length) {
                        System.out.println("Forkert input. vælg et tal fra listen!");
                        continue;
                    }
                    SwimmingDisciplines selectedDiscipline = SwimmingDisciplines.values()[index - 1];

                    if (swimDisciplines.contains(selectedDiscipline)) {
                        System.out.println("Du har allerede denne disciplin tilføjet");
                    } else {
                        swimDisciplines.add(selectedDiscipline);
                        System.out.println("Disciplin tilføjet: " + selectedDiscipline);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Forkert input, tast et nummer fra listen");
                }
            }
        }

        public ArrayList<Result> getSwimmerResultList () {
        return swimmerResultList;
        }
        public double getMembershipFee() {
        return membershipFee;
    }
        public String checkForNullSwimmingDiscipline(){

        if(this.swimDisciplines == null){
                return "";
            }
            return this.swimDisciplines.toString();
}

public String writeMemberData(){
    return name + ";" + getIsActiveStringValue() + ";" + age + ";" + inArrears + ";" + checkForNullSwimmingDiscipline();

}
    }

