package Projects.JavaRush;

/* Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14: -3-
Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.
 */

import java.util.ArrayList;

public class task0812 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(8);
        arrayList.add(4);
        arrayList.add(12);
        arrayList.add(12);
        arrayList.add(14);

        int number = 0;
        for (int i = 0; i < arrayList.size() -1; i++){
            if (arrayList.get(i).equals(arrayList.get(i + 1))){
                number++;
            }
        }
        System.out.println(number);
    }
}
