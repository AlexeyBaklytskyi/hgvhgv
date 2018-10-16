public class Animal {
    String name;
    private int age;
    private String color;


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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public static void showNameSAge(String name, int age){

        System.out.println (name+" "+age);
    }
}
