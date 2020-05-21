import java.util.*;

public class Viewer {

   private Reader reader;

    public Viewer() {
        reader = new Reader();
    }

    public void showList() {
        reader.getListOfWords().forEach((k,v)-> System.out.println("Слово:  " +k + "    Встречается :   " + v +" раз"));
    }

    public void mostCommonValue() {
        System.out.println("----------------------------------------");
        System.out.println("Наиболее часто встречаемое слово:");
        List<Integer> values = new ArrayList<>(reader.getListOfWords().values());
        Collections.sort(values);
        Collections.reverse(values);
        Integer mostCV = values.get(0);
        for (Map.Entry<String,Integer> entry : reader.getListOfWords().entrySet())

            if (entry.getValue().equals(mostCV)) {
                System.out.println("Слово :  " + entry.getKey() + "   Встречается :"  +  entry.getValue() + "  раза");
            }
    }
}
