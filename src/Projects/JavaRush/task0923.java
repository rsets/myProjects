package Projects.JavaRush;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class task0923 {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine().replace(" ", "");

        char[] charString = s.toCharArray();

        ArrayList<Character> vowelList = new ArrayList<>();
        ArrayList<Character> notVowelList = new ArrayList<>();


        for (int i = 0; i < charString.length; i++){
            if (isVowel(charString[i])){
                vowelList.add(charString[i]);
            }else if (!(isVowel(charString[i]))){
                notVowelList.add(charString[i]);
            }
        }

        for (Character q : vowelList){
            System.out.print(q + " ");
        }
        System.out.println(" ");

        for (Character w : notVowelList){
            System.out.print(w + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);
        for (char vowel : vowels) {
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}
