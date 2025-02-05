import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordStatCountPrefixL {
    private final String inputFilename;
    private final String outputFilename;
    private final Map<String, Integer> wordStats;
    private String[] words;
    private int[] cnt;

    public WordStatCountPrefixL(String inputFilename, String outputFilename) {
        this.inputFilename = inputFilename;
        this.outputFilename = outputFilename;
        this.wordStats = new LinkedHashMap();
    }

    public void processFile() {
        try {
            this.readAndCountWords();
            this.writeWordStatsToFile();
        } catch (IOException var2) {
            IOException e = var2;
            e.printStackTrace();
        }

    }

    public static void bubbleSort(String[] words, int[] wordsCount, int wordsAmount) {
        for(int i = 0; i < wordsAmount; ++i) {
            for(int j = 0; j < wordsAmount - i - 1; ++j) {
                if (wordsCount[j] > wordsCount[j + 1]) {
                    String tempString = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = tempString;
                    int tempNumber = wordsCount[j];
                    wordsCount[j] = wordsCount[j + 1];
                    wordsCount[j + 1] = tempNumber;
                }
            }
        }

    }

    public void readAndCountWords() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.inputFilename), StandardCharsets.UTF_8));

        try {
            String line;
            while((line = reader.readLine()) != null) {
                int start = -1;
                int end = -1;
                char[] chars = line.toCharArray();

                for(int i = 0; i < chars.length; ++i) {
                    char c = chars[i];
                    if (this.isWordCharacter(c)) {
                        if (start == -1) {
                            start = i;
                        }

                        end = i;
                    } else if (start != -1) {
                        String word = line.substring(start, end + 1).toLowerCase();
                        if (word.length() >= 3) {
                            this.wordStats.put(word.substring(0, 3), (Integer)this.wordStats.getOrDefault(word.substring(0, 3), 0) + 1);
                        }

                        start = -1;
                    }
                }

                if (start != -1) {
                    String word = line.substring(start, end + 1).toLowerCase();
                    this.wordStats.put(word.substring(0, 3), (Integer)this.wordStats.getOrDefault(word.substring(0, 3), 0) + 1);
                }
            }

            try {
                reader.close();
            } catch (IOException var10) {
                System.err.println(var10.getMessage());
            }
        } catch (Throwable var11) {
            try {
                reader.close();
            } catch (Throwable var9) {
                var11.addSuppressed(var9);
            }

            throw var11;
        }

        reader.close();
        this.words = new String[this.wordStats.size()];
        this.cnt = new int[this.wordStats.size()];
        int i = 0;

        for(Iterator var13 = this.wordStats.entrySet().iterator(); var13.hasNext(); ++i) {
            Map.Entry<String, Integer> pair = (Map.Entry)var13.next();
            this.words[i] = (String)pair.getKey();
            this.cnt[i] = (Integer)pair.getValue();
        }

        bubbleSort(this.words, this.cnt, i);
    }

    public boolean isWordCharacter(char c) {
        return Character.isLetter(c) || c == '\'' || Character.getType(c) == 20;
    }

    public void writeWordStatsToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.outputFilename), StandardCharsets.UTF_8));

        try {
            int i = 0;

            while(true) {
                if (i >= this.words.length) {
                    try {
                        writer.close();
                    } catch (IOException var5) {
                        System.err.println(var5.getMessage());
                    }
                    break;
                }

                String var10001 = this.words[i];
                writer.write(var10001 + " " + this.cnt[i]);
                writer.newLine();
                ++i;
            }
        } catch (Throwable var6) {
            try {
                writer.close();
            } catch (Throwable var4) {
                var6.addSuppressed(var4);
            }

            throw var6;
        }

        writer.close();
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println();
        } else {
            String inputFilename = args[0];
            String outputFilename = args[1];
            WordStatCountPrefixL wordStatCountPrefixL = new WordStatCountPrefixL(inputFilename, outputFilename);
            wordStatCountPrefixL.processFile();
        }

    }
}
