package Result;
import Enums.*;
import Members.*;



public class Result {
    private String date;
    private double timeResult;
    private int swimmerID;
    private SwimmingDisciplines swimmingDiscipline;
    public Result(String date,double timeResult,int swimmerID, SwimmingDisciplines swimmingDiscipline){
        this.date = date;
        this.timeResult = timeResult;
        this.swimmerID = swimmerID;
        this.swimmingDiscipline = swimmingDiscipline;
        ResultList.getResultList().add(this);
        MembersList.matchIDFromResult(this).getSwimmerResultList().add(this);
    }

    public double getTimeResult() {
        return timeResult;
    }
    public SwimmingDisciplines getSwimmingDiscipline () {
        return swimmingDiscipline;
    }

    public int getSwimmerID () {
        return swimmerID;
    }

    public String toString () {
        return "------------------"+"\nDate: " + date + "\nResult.Result: " + timeResult + "\nSwimmerID: " + swimmerID + "\nDiscipline: " + swimmingDiscipline + "\n------------------";
    }
    public String writeResultData () {
        return date + ";" + timeResult + ";" + swimmerID + ";" + swimmingDiscipline.toString();
    }
    public String getDate () {
        return date;
    }


}
