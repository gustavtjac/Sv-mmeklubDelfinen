import java.util.ArrayList;
public class Member {
    protected int memberID;
    protected double membershipFee;
    protected String name;
    protected boolean isMemberActive;
    protected boolean inArrears = false;
    protected int age;

    public Member(String name, boolean isMemberActive,int age) {
        this.name = name;
        this.isMemberActive = isMemberActive;
        this.age = age;
        this.membershipFee = calculateMembershipFee();
        MembersList.getMemberList().add(this);
        this.memberID = MembersList.getMemberList().size();

    }
    public Member(){

    }
public double calculateMembershipFee() { //Metode til at beregne kontingent
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
public void setAge(int age) {
        this.age = age;
}
public int getAge() {
        return this.age;
}
public double getMembershipFee() {
        return membershipFee;
}
public void setName(String name) {
        this.name = name;
}
public String getName() {
        return this.name;
}
public int getMemberID() {
        return memberID;
}
public void setMemberActive(boolean isMemberActive) {
        this.isMemberActive = isMemberActive;
}
public boolean isMemberActive() {
        return this.isMemberActive;
}
@Override
public String toString() { // ændret opsætning for visuel præsentation
    return "Navn: " + this.name + "\nKotigentbeløb: " + this.membershipFee + "\nAktiv?: " + this.isMemberActive + "\nAlder: " + this.age + "\nI Restance: " + this.inArrears + "\n ID: " + this.memberID;
}
}
