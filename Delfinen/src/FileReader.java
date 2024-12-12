import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    public static void loadMembers(){
        try {
            Scanner sc = new Scanner(new File("Delfinen/src/Members.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(";");
                if(parts.length > 4){
                    ArrayList<SwimmingDisciplines> temp = new ArrayList<>();
                    if (parts[4].length()<=2){

                    }else {
                        String[] disciplines = parts[4].replaceAll("[\\[\\]]", "").split(", ");
                        for (int i = 0; i<disciplines.length; i++){
                            for (SwimmingDisciplines sw : SwimmingDisciplines.values()){
                                if (disciplines[i].equalsIgnoreCase(String.valueOf(sw))){
                                    temp.add(sw);
                                }
                            }
                        }
                    }




                    new CompetitiveSwimmer(String.valueOf(parts[0]), Boolean.parseBoolean(parts[1]), Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]),temp);
                }
                else {
                    new CasualSwimmer(String.valueOf(parts[0]), Boolean.parseBoolean(parts[1]), Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]));
                }
            }




        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void loadResults() {
        try {
            Scanner sc = new Scanner(new File("Delfinen/src/Results.txt"));
            while(sc.hasNextLine()){
                SwimmingDisciplines discipline = null;
                String line = sc.nextLine();
                String[] parts = line.split(";");
                if(parts.length > 4){
                    for (SwimmingDisciplines sw : SwimmingDisciplines.values()){
                        if (parts[3].equalsIgnoreCase(String.valueOf(sw))){
                            discipline = sw;
                        }
                    }

                    new CompetitionResult(parts[0],Double.parseDouble(parts[1]),Integer.parseInt(parts[2]),discipline,parts[4],Integer.parseInt(parts[5]));
                } else {
                    for (SwimmingDisciplines sw : SwimmingDisciplines.values()){
                        if (parts[3].equalsIgnoreCase(String.valueOf(sw))){
                            discipline = sw;
                        }
                    }
new TrainingResult(parts[0],Double.parseDouble(parts[1]),Integer.parseInt(parts[2]),discipline);
                }
            }




        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
