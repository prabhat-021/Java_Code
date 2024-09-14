package Polymorphism;

public class Circle extends Shapes {

    // this will run when obj of Circle is created
    // hence it is overriding the parent method
    Circle(){
        super(5);
    }
    @Override
    // this is called annotation
    void area(int i) {
        System.out.println("Area is pi * r * r");
        System.out.println(i*i*i);
    }
}
