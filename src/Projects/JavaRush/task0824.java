package Projects.JavaRush;

import java.util.ArrayList;
/*
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).
*/
public class task0824 {
    public static void main(String[] args) {

        Human children1 = new Human("Kolya",15,true,null);
        Human children2 = new Human("Misha",16,true,null);
        Human children3 = new Human("Masha",13,false,null);

        ArrayList<Human> child = new ArrayList<>();
        child.add(children1);
        child.add(children2);
        child.add(children3);

        Human father = new Human("Sergey",35,true,child);
        Human mother = new Human("Larisa",33,false,child);

        ArrayList<Human> father1 = new ArrayList<>();
        father1.add(father);
        ArrayList<Human> mother1 = new ArrayList<>();
        mother1.add(mother);

        Human grandfather = new Human("Nikolay",65,true,father1);
        Human grandfather2 = new Human("Vasiliy",66,true,father1);

        Human grandmother = new Human("Natasha",60,false,mother1);
        Human grandmother2 = new Human("Valentina",61,false,mother1);

        System.out.println(grandfather);
        System.out.println(grandfather2);
        System.out.println(grandmother);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);





    }

    public static class Human {

         public String name;
         public boolean sex;
         public int age;
         public ArrayList<Human> children;

         public Human(String name, int age, boolean sex, ArrayList<Human> children){
             this.name = name;
             this.age = age;
             this.sex = sex;
             this.children = children;
         }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
