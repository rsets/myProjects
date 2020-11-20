package Projects;

public class test {
    public static void main(String[] args) {
        Human human = new Human(25,"Ruslan","male");

        System.out.println(human.getAge());
        human.setAge(14);
        System.out.println(human.getAge());
        human.sayHello("Veronika");
    }
}
