package du7.src.main.java;

    public abstract class AbstractAnimal implements InterFaceConstructor {

        private String name;

        public abstract void makeSound();

        public void jumpAndMakeSound() {
            System.out.println("JUMPED");
            makeSound();
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }
    }

