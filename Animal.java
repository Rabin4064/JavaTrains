class Animal {
    void makeSound() {
        System.out.println("Some Sound");
    };

    public static void main(String[] args) {
    Cat myCat = new Cat();
    System.out.print("The cat sounds like: ");
    myCat.makeSound();

    Dog myDog = new Dog();
    System.out.print("The dog sounds like: ");
    myDog.makeSound();

    Bird myBird = new Bird();
    System.out.print("The bird sounds like: ");
    myBird.makeSound();
}
    
}

class Cat extends Animal {
    @Override void makeSound() {
        System.out.println("Meow!");
    }
}

class Dog extends Animal {
    @Override void makeSound() {
        System.out.println("Woof!");
    }
}

class Bird extends Animal {}
