package du7.src.main.java;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        interfaces();
        abstractClass();
        inheritance();
    }
    public static void abstractClass(){
        AbstractAnimal cat = new Cat();
        cat.jumpAndMakeSound();

    }

    public static void interfaces(){
        InterFaceConstructor animal = new Animal();
        InterFaceConstructor cat = new Cat();
        InterFaceConstructor dog = new Dog();
        InterFaceConstructor person = new Person();

        dog.setName("Benik");
        person.setName("vojta");

        ArrayList<InterFaceConstructor> namedList = new ArrayList<>();
        namedList.add(animal);
        namedList.add(cat);
        namedList.add(dog);
        namedList.add(person);
        for(InterFaceConstructor named: namedList){
            System.out.println(named.getName());
        }
    }

    public static void inheritance() {
        Animal animal = new Animal();
        animal.setName("defanimal");

        Animal animal2 = new Animal();
        animal2.setName("defanimal2");
        animal2.makeSound();

        Cat cat = new Cat();
        cat.setName("Tom");
        cat.makeSound();

        Dog dog = new Dog();
        dog.setName("jerry");
        dog.makeSound();

        makeSound(dog);
        makeSound(animal);

    }

    public static void makeSound(Animal a) {
        //check ze realna instance je daneho typu
        if (a instanceof Dog dog) {
            dog.jump();
        }
        a.makeSound();
    }

}
