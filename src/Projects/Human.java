package Projects;

import java.util.Arrays;

public class Human {
    private int age;
    private String name;
    private String sex;

    public Human(){

    }

    public Human(int age, String name, String sex){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public void sayHello(String name){
        System.out.println("Hello " + name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 15 | age > 100){
            System.out.println("Wrong age, use age from 15 to 100");
        }
        else this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
