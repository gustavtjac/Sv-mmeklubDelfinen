package Result;
import Enums.*;



public class CompetitionResult extends Result {
    private String tournamentName;
    private int tournamentPlacement;

    public CompetitionResult(String date, double timeResult, int swimmerID, SwimmingDisciplines swimmingDiscipline, String tournamentName, int tournamentPlacement) {
        super(date, timeResult, swimmerID, swimmingDiscipline);
        this.tournamentPlacement = tournamentPlacement;
        this.tournamentName = tournamentName;
    }
    public String checkForNullSwimmingDiscipline(){
        if(this.getSwimmingDiscipline() == null){
            return "";
        }
        else{
            return this.getSwimmingDiscipline().toString();
        }

    }

    public String toString() {
        return "------------------\n"+ "Tournament name: " + tournamentName + "\nPlacement: "
                + tournamentPlacement + "\nDate: " + this.getDate() + "\nResult.Result: "
                + this.getTimeResult() + "\nSwimmerID: " + this.getSwimmerID() + "\nDiscipline: " + this.getSwimmingDiscipline() + "\n------------------";
    }
    public String writeResultData () {
        return this.getDate() + ";" + this.getTimeResult() + ";" + this.getSwimmerID() + ";" + checkForNullSwimmingDiscipline() + ";" + tournamentName + ";" + tournamentPlacement;
    }
}
