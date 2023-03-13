import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordChecker {

    private Map<String, Boolean> dictionary;
    private Map<Integer, Integer> lengthCount;
    private int validWordsCount;
    private Map<String, Integer> longWords;


    public WordChecker() throws IOException {
        dictionary = new HashMap<>();
        lengthCount = new HashMap<>();
        validWordsCount = 0;
        longWords = new HashMap<>();
        populateDictionary();
    }

    private void populateDictionary() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/jimmi/IdeaProjects/random1/src/engmix.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            dictionary.put(line, true);
        }
        br.close();
    }


    public void checkWords(String inputFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (dictionary.containsKey(word)) {
                    validWordsCount++;
                    int length = word.length();
                    if (length > 4) { if (longWords.containsKey(word)) {
                        longWords.put(word, longWords.get(word) + 1);
                    } else {
                        longWords.put(word, 1);
                    }
                    }
                    if (lengthCount.containsKey(length)) {
                        lengthCount.put(length, lengthCount.get(length) + 1);
                    } else {
                        lengthCount.put(length, 1);
                    }
                }
            }
        }
        br.close();
    }

    public void printResults() {
        System.out.println("Number of valid words: " + validWordsCount);
        System.out.println("Valid words by length: ");
        for (Map.Entry<Integer, Integer> entry : lengthCount.entrySet()) {
            System.out.println("  " + entry.getKey() + " letter words: " + entry.getValue());
        }
    }

    public void printLongWords() {
        System.out.println("Valid words with length greater than 4: ");
        for (Map.Entry<String, Integer> entry : longWords.entrySet()) {
            System.out.println("  " + entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        WordChecker checker = new WordChecker();
        checker.checkWords("words.txt");
        checker.printResults();
        checker.printLongWords();
    }
}

