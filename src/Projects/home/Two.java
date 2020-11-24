package Projects.home;

public class Two {
    public Two(){

    }
    public Two(int number){

    }

    private String name;
    private int age;
    private boolean move;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "Two{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", move=" + move +
                '}';
    }
}
