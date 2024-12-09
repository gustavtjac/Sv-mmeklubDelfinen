public class Member {
    protected double membershipFee;
    private String name;
    private boolean isMemberActive;
    protected boolean inArrears = false;
    private int age;
    public Member(String name, boolean isMemberActive,int age) {
        this.name = name;
        this.isMemberActive = isMemberActive;
        this.age = age;
        this.membershipFee = calculateMembershipFee();
    }
public double calculateMembershipFee() {
        if (!this.isMemberActive) {
            return MembershipFees.PASSIVE.getFee();
        } else if (this.isMemberActive && this.age<18) {
            return MembershipFees.JUNIOR.getFee();
        }else if (this.isMemberActive && this.age>18 && this.age<60) {
            return MembershipFees.SENIOR.getFee();
        }else{
            return MembershipFees.RETIREE.getFee();
        }
}
}
