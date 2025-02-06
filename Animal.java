abstract class Animal {
    public void makeSound() {
        System.out.println("Some Sound");
    };
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Bird extends Animal {}
