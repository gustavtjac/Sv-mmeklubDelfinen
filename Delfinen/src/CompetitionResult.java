public class CompetitionResult {
    private int swimmerID;
    private String tournamentName;
    private String date;
    private double timeResult;
    private int tournamentPlacement;

    public SwimmingDisciplines getSwimmingDiscipline() {
        return swimmingDiscipline;
    }

    private SwimmingDisciplines swimmingDiscipline;
    CompetitionResult(String tournamentName,String date, double timeResult,int tournamentPlacement, SwimmingDisciplines swimmingDiscipline, int swimmerID) {
        this.swimmerID = swimmerID;
        this.tournamentName = tournamentName;
        this.date = date;
        this.timeResult = timeResult;
        this.tournamentPlacement = tournamentPlacement;
        this.swimmingDiscipline = swimmingDiscipline;
        CompetitionResultList.resultList.add(this); //Tilføjer nyoprettet resultat til resultList
    }

    public double getTimeResult() {
        return timeResult;
    }

    public String toString() {
        return "Svømmer ID: " + swimmerID +". Tid: "+ timeResult;
    }
}
