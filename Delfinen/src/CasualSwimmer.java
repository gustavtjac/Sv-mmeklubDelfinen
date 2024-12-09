public class CasualSwimmer extends Member{
    public CasualSwimmer(String name, boolean isMemberActive, int age) {
        super(name, isMemberActive, age);
        this.membershipFee = calculateMembershipFee();
        this.inArrears = false;
    }
}
