import java.io.*;
import java.util.*;

public class WordStatInput {
    private String inputFilename;
    private String outputFilename;
    private Map<String, Integer> wordStats;

    public WordStatInput(String inputFilename, String outputFilename) {
        this.inputFilename = inputFilename;
        this.outputFilename = outputFilename;
        this.wordStats = new LinkedHashMap<>();
    }

    public void processFile() {
        try {
            readAndCountWords();
            writeWordStatsToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAndCountWords() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename), "UTF-8"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                int start = -1;
                int end = -1;
                char[] chars = line.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char c = chars[i];

                    if (isWordCharacter(c)) {
                        if (start == -1) {
                            start = i;
                        }
                        end = i;
                    } else if (start != -1) {
                        String word = line.substring(start, end + 1).toLowerCase();
                        wordStats.put(word, wordStats.getOrDefault(word, 0) + 1);
                        start = -1;
                    }
                }

                if (start != -1) {
                    String word = line.substring(start, end + 1).toLowerCase();
                    wordStats.put(word, wordStats.getOrDefault(word, 0) + 1);
                }
            }
        }
    }

    public boolean isWordCharacter(char c) {
        return Character.isLetter(c) || c == 39 || Character.getType(c) == Character.DASH_PUNCTUATION;
    }

    public void writeWordStatsToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilename), "UTF-8"))) {
            for (Map.Entry<String, Integer> entry : wordStats.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java WordStatInput input_file output_file");
        } else {
            String inputFilename = args[0];
            String outputFilename = args[1];
            WordStatInput wordStatInput = new WordStatInput(inputFilename, outputFilename);
            wordStatInput.processFile();
        }
    }
}