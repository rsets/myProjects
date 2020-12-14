package Projects.JavaRush;

import java.util.HashMap;
import java.util.Map;

/* Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.
  */
public class task0815 {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Plotnikov", "Pavel");
        map.put("Donchenko", "Pavel");
        map.put("Dizhevskiy", "Aleksey");
        map.put("Milashenko", "Dmitriy");
        map.put("Melkonyan", "Alexander");
        map.put("Zelenskiy", "Vladimir");
        map.put("Kostiuk", "Ruslan");
        map.put("Dyachenko", "Gleb");
        map.put("Hellscream", "Pavel");
        map.put("Menethil", "Arthas");
        return map;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int number = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String value = pair.getValue();
            if (name.equals(value)) {
                number++;
            }

        }
        return number;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String key = pair.getKey();
            if (lastName.equals(key)) {
                return 1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "Pavel"));
        System.out.println(getCountTheSameLastName(map,"Plotnikov"));
    }
}
/*
Second option :
---------------------------
     public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
     int number = 0;
     for (String s : map.values()){
       if(name.equals(s)){
           number++;
       }
     }
     return number;
     }
-------------------------

public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int number = 0;
        for (String s : map.keySet())
            if (s.equals(lastName))
                number++;
        return count;
    }
------------------------
 */

