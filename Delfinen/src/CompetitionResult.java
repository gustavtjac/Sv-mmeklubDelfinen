public class CompetitionResult extends Result{
    private String tournamentName;
    private int tournamentPlacement;
    private SwimmingDisciplines swimmingDiscipline;

    CompetitionResult(String tournamentName,String date, double timeResult,int tournamentPlacement, SwimmingDisciplines swimmingDiscipline, int swimmerID) {
    super(date, timeResult, swimmerID, swimmingDiscipline);
        this.tournamentName = tournamentName;
        this.tournamentPlacement = tournamentPlacement;
         //Tilføjer nyoprettet resultat til resultList
    }
    public SwimmingDisciplines getSwimmingDiscipline() {
        return swimmingDiscipline;
    }

    public double getTimeResult() {
        return timeResult;
    }

    public String toString() {
        return "Svømmer ID: " + swimmerID +". Tid: "+ timeResult;
    }
}
