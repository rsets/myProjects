package Projects.JavaRush;

/* Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк. Удали 3 - ий элемент списка, и выведи оставшиеся элементы в обратном порядке.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class task0714 {
    public static void main(String[] args) throws Exception{
        ArrayList<String> arrayList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++){
            String s = bufferedReader.readLine();
            arrayList.add(s);
        }

        arrayList.remove(2);

        for (int i = arrayList.size() - 1; i >= 0; i--){
            System.out.println(arrayList.get(i));
        }
    }
}
