import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Locale;
import java.util.TreeMap;

public class Reader {
    private TreeMap<String, Integer> listOfWords;
    Locale rus = new Locale("ru", "RU");


    public Reader() {
        listOfWords = ArrayToMap();
    }

    public TreeMap<String, Integer> getListOfWords() {
        return listOfWords;
    }

    public TreeMap<String, Integer> ArrayToMap() {
        TreeMap<String, Integer> result = new TreeMap<String, Integer>();
        for (String word: addStringToArray()) {
            String w = word.toLowerCase(rus);
            if (result.containsKey(w)) {
                result.put(word, result.get(w)+1);
            }
            else {
                result.put(w,1);
            }
        }
        return result;
    }

    public String[] addStringToArray () {
        String regex = "[\\,\\s\\d\\t\\n\\!\\.\\+\\?\\-\\[\\]\\(\\)\\_\\&\\{\\}\\=]+";
        return readFileToString().split(regex);
    }

    public String readFileToString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу: ");
        String path = null;
        String contents = null;
        try {
            path = reader.readLine();
            contents = readUsingBufferedReader(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
        }

        private  String readUsingBufferedReader(String fileName) throws IOException {
            BufferedReader reader = new BufferedReader( new FileReader(fileName));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");
            while( ( line = reader.readLine() ) != null ) {
                stringBuilder.append( line );
                stringBuilder.append( ls );
            }

            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            return stringBuilder.toString();
        }
    }
