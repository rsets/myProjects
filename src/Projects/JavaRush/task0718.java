package Projects.JavaRush;
/* Проверка на упорядоченность
1. Введи с клавиатуры 10 слов в список строк.
2. Определить, является ли список упорядоченным по возрастанию длины строки.
3. В случае отрицательного ответа вывести на экран индекс первого элемента, нарушающего такую упорядоченность.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class task0718 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++){
            String s = bufferedReader.readLine();
            arrayList.add(s);
        }


        for (int i = 0; i < arrayList.size() - 1; i++){
            if (arrayList.get(i).length() > arrayList.get(i + 1).length()){
                System.out.println(i+1);
                break;
            }

        }

    }
}

