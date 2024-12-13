package Result;
import Enums.*;



public class CompetitionResult extends Result {
    protected String tournamentName;
    protected int tournamentPlacement;

    public CompetitionResult(String date, double timeResult, int swimmerID, SwimmingDisciplines swimmingDiscipline, String tournamentName, int tournamentPlacement) {
        super(date, timeResult, swimmerID, swimmingDiscipline);
        this.tournamentPlacement = tournamentPlacement;
        this.tournamentName = tournamentName;
    }
    public String checkForNullSwimmingDiscipline(){
        if(this.swimmingDiscipline == null){
            return "";
        }
        else{
            return this.swimmingDiscipline.toString();
        }

    }

    public String toString() {
        return "------------------\n"+ "Tournament name: " + tournamentName + "\nPlacement: "
                + tournamentPlacement + "\nDate: " + date + "\nResult.Result: "
                + timeResult + "\nSwimmerID: " + swimmerID + "\nDiscipline: " + swimmingDiscipline + "\n------------------";
    }
    public String writeResultData () {
        return date + ";" + timeResult + ";" + swimmerID + ";" + checkForNullSwimmingDiscipline() + ";" + tournamentName + ";" + tournamentPlacement;
    }
}
