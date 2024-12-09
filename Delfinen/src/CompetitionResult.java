public class CompetitionResult {
    private int swimmerID;
    private String tournamentName;
    private String date;
    private double timeResult;
    private int tournamentPlacement;
    private SwimmingDisciplines swimmingDiscipline;
    CompetitionResult(String tournamentName,String date, double timeResult,int tournamentPlacement, SwimmingDisciplines swimmingDiscipline, int swimmerID) {
        this.swimmerID = swimmerID;
        this.tournamentName = tournamentName;
        this.date = date;
        this.timeResult = timeResult;
        this.tournamentPlacement = tournamentPlacement;
        this.swimmingDiscipline = swimmingDiscipline;
    }
}
