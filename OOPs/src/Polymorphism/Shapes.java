package Polymorphism;

public class Shapes {
    protected int i;
    Shapes(int i){
        area(i);
    }

    void area(int i) {
        System.out.println("I am in shapes");
        System.out.println(i*i);
    }

//      Early binding: check notes
//    final void area() {
//        System.out.println("I am in shapes");
//    }
}
