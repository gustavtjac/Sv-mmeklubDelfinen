import java.util.ArrayList;

public class CompetitiveSwimmer extends Member{
private ArrayList<SwimmingDisciplines> swimDisciplines;
    public CompetitiveSwimmer(String name, boolean isMemberActive, int age, ArrayList<SwimmingDisciplines> swimmingDisciplines) {
        super(name, isMemberActive, age);
        this.membershipFee = calculateMembershipFee();
        this.inArrears = false;
        this.swimDisciplines = swimmingDisciplines;
    }


}
