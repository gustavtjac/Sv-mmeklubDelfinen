package Members;


public class CasualSwimmer extends Member {
    public CasualSwimmer(String name, boolean isMemberActive, int age,boolean inArreas) {
        super(name, isMemberActive, age, inArreas);
        this.membershipFee = calculateMembershipFee();
        this.setInArrears(inArreas);
    }
}
