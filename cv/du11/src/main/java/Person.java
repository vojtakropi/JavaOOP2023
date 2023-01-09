package du11.src.main.java;

public class Person {
    private String name;
    private int age;
    private String animal;

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public Person setAnimal(String animal) {
        this.animal = animal;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", animal='" + animal + '\'' +
                '}';
    }
}
