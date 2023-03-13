import java.util.Random;
import java.io.*;

public class RandomMain {
    private static final String WORD_FILE = "words.txt";

    public static void main(String[] args) throws IOException {
        int count = 0;
        int line = 1;

        FileWriter fw = new FileWriter(WORD_FILE);
        BufferedWriter bw = new BufferedWriter(fw);

        while(count<100){
            int l = rand_length();
            String word = generate_word(l);
            bw.write(word + "\n");
//            if(line % 10 == 0){
//                bw.write("\n");
//            }
            line ++;
            count++;
        }

        bw.close();
    }

    public static int rand_length(){
        Random rand = new Random();
        int n = rand.nextInt(7) + 2;
        return n;
    }

    public static String generate_word(int l) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < l; i++){
            String let = letter();
            sb.append(let);
        }
        return sb.toString();
    }

    public static String capitalize(String w){
        String s1 = w.substring(0, 1).toUpperCase();  // first letter = J
        String s2 = w.substring(1);     // after 1st letter = avatpoint
        String res = s1 + s2;
        return res;
    }

    public static String letter(){
        int random = (int)(Math.random() * 104);
        if(random <= 13){
            return "e";
        } else if(random > 13 && random <= 22){
            return "t";
        } else if(random > 22 && random <= 30){
            return "a";
        } else if(random > 30 && random <= 37){
            return "o";
        } else if(random > 37 && random <= 44){
            return "i";
        } else if(random > 44 && random <= 51){
            return "n";
        } else if(random > 51 && random <= 57){
            return "s";
        } else if(random > 57 && random <= 63){
            return "h";
        } else if(random > 63 && random <= 69){
            return "r";
        } else if(random > 69 && random <= 74){
            return "d";
        } else if(random > 74 && random <= 77){
            return "l";
        } else if(random > 77 && random <= 80){
            return "c";
        } else if(random > 80 && random <= 83){
            return "u";
        } else if(random > 83 && random <= 86){
            return "m";
        } else if(random > 86 && random <= 88){
            return "w";
        } else if(random > 88 && random <= 90){
            return "f";
        } else if(random > 90 && random <= 92){
            return "g";
        } else if(random > 92 && random <= 94){
            return "y";
        } else if(random > 94 && random <= 96){
            return "p";
        } else if(random > 96 && random <= 98){
            return "b";
        } else if(random > 98 && random <= 99){
            return "v";
        } else if(random > 99 && random <= 100){
            return "k";
        } else if(random > 100 && random <= 101){
            return "j";
        } else if(random > 101 && random <= 102){
            return "x";
        } else if(random > 102 && random <= 103){
            return "q";
        } else if(random > 103 && random <= 104){
            return "z";
        }
        return null;
    }

}