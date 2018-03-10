package MainPack;

import Task1.*;
import Task2.*;
import Task3.*;

public class Main {
    public static void main(String[] args) {
        /*
                Testing class MyComplex
        */
        System.out.println("\t***Testing class MyComplex***");
        MyComplex complex1 = new MyComplex(0, -8);
        MyComplex complex2 = new MyComplex(-9, 0);
        MyComplex complex3 = new MyComplex(3, 4);
        MyComplex complex4 = new MyComplex(-7, -8);
        MyComplex complex5 = new MyComplex(0,0);

        // toString()
        System.out.println("complex1 = " + complex1);
        System.out.println("complex2 = " + complex2);
        System.out.println("complex3 = " + complex3);
        System.out.println("complex4 = " + complex4);
        System.out.println("complex5 = " + complex5);

        // isReal()
        System.out.println("\ncomplex1.isReal(): " + complex1.isReal());
        System.out.println("complex2.isReal(): " + complex2.isReal());
        System.out.println("complex3.isReal(): " + complex3.isReal());
        System.out.println("complex4.isReal(): " + complex4.isReal());

        // isImaginary()
        System.out.println("\ncomplex1.isImaginary(): " + complex1.isImaginary());
        System.out.println("complex2.isImaginary(): " + complex2.isImaginary());
        System.out.println("complex3.isImaginary(): " + complex3.isImaginary());
        System.out.println("complex4.isImaginary(): " + complex4.isImaginary());

        // equals
        System.out.println("\ncomplex3 == complex4: " + complex3.equals(complex4));
        System.out.println("complex1 == 0-8i: " + complex1.equals(0.0, -8.0));

        // magnitude()
        System.out.println("\ncomplex1.magnitude() = " + complex1.magnitude());
        System.out.println("complex2.magnitude() = " + complex2.magnitude());
        System.out.println("complex3.magnitude() = " + complex3.magnitude());
        System.out.println("complex4.magnitude() = " + complex4.magnitude());
        System.out.println("complex5.magnitude() = " + complex5.magnitude());

        // argument()
        System.out.println("\ncomplex1.argument() = " + complex1.argument());
        System.out.println("complex2.argument() = " + complex2.argument());
        System.out.println("complex3.argument() = " + complex3.argument());
        System.out.println("complex4.argument() = " + complex4.argument());
        System.out.println("complex5.argument() = " + complex5.argument());

        // add() and addNew()
        System.out.println("\ncomplex1.add(complex2) = "  + complex1.add(complex2));
        System.out.println("complex1 = " + complex1);
        System.out.println("complex1.addNew(complex2) = "  + complex1.addNew(complex2));
        System.out.println("complex1 = " + complex1);

        // subtract() and subtractNew()
        System.out.println("\ncomplex1.subtract(complex2) = " + complex1.subtract(complex2));
        System.out.println("complex1 = " + complex1);
        System.out.println("complex1.subtractNew(complex2) = " + complex1.subtractNew(complex2));
        System.out.println("complex1 = " + complex1);

        // multiply()
        complex3.multiply(complex4);
        System.out.println("\ncomplex3.multiply(complex4) = " + complex3);

        // divide()
        complex3.divide(complex4);
        System.out.println("\ncomplex3.divide(complex4) = " + complex3);

        // conjugate()
        System.out.println("\ncomplex4 = " + complex4);
        System.out.println("complex4.conjugate() = " + complex4.conjugate());

        /*
                Testing class MyPolynomial
        */
        System.out.println("\n\n\t***Testing class MyPolynomial***");
        MyPolynomial poly1 = new MyPolynomial(1.0, -1.0, 1.0, -1.0, -1.0, -5.4);
        MyPolynomial poly2 = new MyPolynomial(6.5, -0.5, 0.0, -3.9, -1.2, 5.4);
        System.out.println("poly1 = " + poly1);
        System.out.println("poly2 = " + poly2);
        System.out.println("Degree of poly1: " + poly1.getDegree());
        System.out.println("Degree of poly2: " + poly2.getDegree());
        MyPolynomial poly3 = poly1.add(poly2);
        System.out.println("poly3 = poly1 + poly2");
        System.out.println("poly3 = " + poly3);
        System.out.println("Degree of poly3: " + poly3.getDegree());
        MyPolynomial poly4 = poly3.multiply(poly2);
        System.out.println("poly4 = poly3 * poly2");
        System.out.println("poly4 = " + poly4);

        /*
                Testing classes Ball and Container
        */
        System.out.println("\n\t***Testing classes Ball and Container***");
        Ball ball = new Ball(50f, 100f, 10, 10, 70);
        Container container = new Container(30, 50, 50, 50);
        System.out.println(ball);
        System.out.println(container);

        for (int i = 0; i < 10; i++) {
            System.out.println("\tStep " + (i + 1));
            ball.move();
            if (!container.collides(ball)) {
                ball.turnBall(container);
                ball.move(); // смещаем мяч обратно, чтобы он находился внутри контейнера
            }
            System.out.println(ball);
        }
    }
}