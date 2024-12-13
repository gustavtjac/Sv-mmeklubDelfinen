package Result;

import java.util.ArrayList;
import java.util.Comparator;

public class ResultList {

    private static ArrayList<Result> resultList = new ArrayList<>();

    public static void showTopFiveResults() {
        resultList.sort(Comparator.comparingDouble(Result::getTimeResult)); //Sorterer resultList
        for (Result result : resultList) {
            System.out.println(result);
        }

    }
    public static ArrayList<Result> getResultList() {
        return resultList;
    }
}

