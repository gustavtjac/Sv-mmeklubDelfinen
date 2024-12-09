public class CompetitionResult {
    private String tournamentName;
    private String date;
    private double timeResult;
    private int tournamentPlacement;
    private SwimmingDisciplines swimmingDiscipline;
    CompetitionResult(String tournamentName,String date, double timeResult,int tournamentPlacement, SwimmingDisciplines swimmingDiscipline) {
        this.tournamentName = tournamentName;
        this.date = date;
        this.timeResult = timeResult;
        this.tournamentPlacement = tournamentPlacement;
        this.swimmingDiscipline = swimmingDiscipline;
    }
}
