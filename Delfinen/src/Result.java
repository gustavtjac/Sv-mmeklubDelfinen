public class Result {
    protected String date;
    protected double timeResult;
    protected int swimmerID;
    protected SwimmingDisciplines swimmingDiscipline;
    public Result(String date,double timeResult,int swimmerID, SwimmingDisciplines swimmingDiscipline){
        this.date = date;
        this.timeResult = timeResult;
        this.swimmerID = swimmerID;
        this.swimmingDiscipline = swimmingDiscipline;
        ResultList.resultList.add(this);
        MembersList.matchIDFromResult(this).getSwimmerResultList().add(this);
    }

    public double getTimeResult() {
        return timeResult;
    }
    public SwimmingDisciplines getSwimmingDiscipline () {
        return this.swimmingDiscipline;
    }

    public int getSwimmerID () {
        return swimmerID;
    }

    public String toString () {
        return "Result: " + timeResult;

    }


}
