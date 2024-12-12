public class CompetitionResult extends Result {
    protected String tournamentName;
    protected int tournamentPlacement;

    public CompetitionResult(String date, double timeResult, int swimmerID, SwimmingDisciplines swimmingDiscipline, String tournamentName, int tournamentPlacement) {
        super(date, timeResult, swimmerID, swimmingDiscipline);
        this.tournamentPlacement = tournamentPlacement;
        this.tournamentName = tournamentName;
    }


    public String toString() {
        return "------------------\n"+ "Tournament name: " + tournamentName + "\nPlacement: "
                + tournamentPlacement + "\nDate: " + date + "\nResult: "
                + timeResult + "\nSwimmerID: " + swimmerID + "\nDiscipline: " + swimmingDiscipline + "\n------------------";
    }
}
