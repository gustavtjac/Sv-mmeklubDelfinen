public enum MembershipFees {
    JUNIOR(1000),
    SENIOR(1600),
    RETIREE(SENIOR.getFee()*0.75),
    PASSIVE(500);
    private final double fee;


    MembershipFees(double fee) {
        this.fee = fee;
    }
    public double getFee() {
        return fee;
    }
}
