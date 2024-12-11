import java.util.ArrayList;
import java.util.Comparator;

public class CompetitionResultList {

    protected static ArrayList<CompetitionResult> resultList = new ArrayList<>();

    public static void showTopFiveResults() {
        resultList.sort(Comparator.comparingDouble(CompetitionResult::getTimeResult)); //Sorterer resultList
        for (CompetitionResult result : resultList) {
            if (result.getSwimmingDiscipline().equals("")) {
                System.out.println(result);
            }
        }

    }
}

