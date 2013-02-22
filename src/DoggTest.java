
class Dog {
    int size;
    String breed;
    String name;

    void bark() {
        System.out.println("Ruff! Ruff! ... ridiculous sample program.");
    }
}

class DoggTest {
    public static void main (String[] args){
        Dog doggie = new Dog();
        doggie.size = 40;
        doggie.bark();
    }
}