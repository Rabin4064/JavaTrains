class Animal {
    void makeSound() {
        System.out.println("Some Sound");
    };    
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
