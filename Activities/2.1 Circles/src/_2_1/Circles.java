package _2_1;

public class Circles {

    // ACTIVITY 2.1 - Complete the project by creating the Circle class and all
    // of the required code. Include good comments and ensure your code is
    // readable by utilizing good spacing, both horizontal and vertical. The
    // main method and its class should not be changed at all.

    // 1. Create a class Circle (in the default package) with the required
    //    instance fields (all double).

    // 2. Write the accessor and mutator methods for each of the instance
    //    fields. Write a mutator method for all three fields at once.

    // 3. Write a constructor method that has no parameters. The method should
    //    construct a "unit" Circle object with centre (0, 0) and radius 1.

    // 4. Write a constructor method that has three parameters representing the
    //    coordinates of the centre and the radius of the circle to be
    //    constructed. The method should ensure that the circle’s radius is not
    //    negative by changing the sign of any negative radius parameters.

    // 5. Write a constructor method with one parameter, an object of type
    //    Circle.  The method should construct a new Circle object with the
    //    same field values as those of the parameter.

    // 6. Write an instance method area() that returns, as a double value, the
    //    area of the implicit Circle object.


    // 7. Write an instance method circumference() that returns, as a double
    //    value, the circumference of the implicit Circle object.


    // 8. Write an instance method diameter() that returns, as a double value,
    //    the diameter of the implicit Circle object.


    // 9. Write an instance method smaller(Circle c) that could be called by a
    //    statement like:

    // Circle c3 = c1.smaller(c2);

    //     where c1, c2, and c3 are objects of type Circle. The method should
    //     make c3 refer to the smaller of the circles, by area, represented by
    //     c1 and c2 (or c1 if c1 and c2 are the same size)

    // 10. Write an instance method distance(Circle c) that returns the
    //     distance between the centres of the two circles specified by the
    //     implicit and the explicit object parameters.

    // Usage: double d = c1.distance(c2);

    // 11. Write an instance method isInside() that could be called by a
    //     statement like

    //     boolean contained = c1.isInside(c2);

    // The method should return true if c1 is entirely inside and not touching
    // c2 and return false otherwise. Hint: use the distance method.

    // 12. Write an instance method equals(Circle c) that takes a Circle object
    //     as parameter and returns true if and only if the implicit Circle is
    //     equivalent to the parameter object. You will need to decide on what
    //     conditions two circles should be considered "equal".

    // 13. Write a class method printEquation(Circle c) which prints the
    //     equation of the circle nicely in Cartesian form. For a Circle object
    //     with x = 3, y = -4, and r = 2, it should print:

    //     (x - 3.0)² + (y + 4.0)² = 4.0

    // Note: you can use the ² character, if you like, just copy and paste.
    // Also, notice the sign change inside the parentheses.


    // 14. Write an override for the toString() method for the Circle class.
    //     For the same circle as above, the toString method should produce:

    //     Circle: centre at (3.0, -4.0) and radius 2.0

    /*
     * DO NOT CHANGE ANY CODE BELOW
     */
    public static void main(String[] args) {
        // create two circles
        Circle c1 = new Circle(4, -1, 6);
        Circle c2 = new Circle(3, -2, -2);

        // print them both using toString and printEquation
        System.out.println("c1:");
        System.out.println(c1);
        Circle.printEquation(c1);
        System.out.println("");

        System.out.println("c2:");
        System.out.println(c2);
        Circle.printEquation(c2);
        System.out.println("");

        // print the radius, diameter, circumference, and area, rounded nicely
        System.out.printf("Radius of c1: %.2f units%n", c1.getR());
        System.out.printf("Diameter of c1: %.2f units%n", c1.diameter());
        System.out.printf("Circumference of c1: %.2f units%n", c1.circumference());
        System.out.printf("Area of c1: %.2f units²%n", c1.area());
        System.out.println("");

        // find the smaller circle
        Circle smaller = c1.smaller(c2);
        System.out.println("Smaller of c1 and c2: " + smaller);
        System.out.println("");

        // create new circles and references
        Circle c3 = c1;
        Circle c4 = new Circle(c1);
        Circle c5 = new Circle();

        // test inside
        System.out.println("Is c2 entirely inside c1? " + c2.isInside(c1));
        System.out.println("Is c5 entirely inside c4? " + c5.isInside(c2));
        System.out.println("");

        // test equality/equivalence
        System.out.println("smaller == c2? " + (smaller == c2) );
        System.out.println("c1 == c3? " + (c1 == c3) );
        System.out.println("c1 == c4? " + (c1 == c4) );
        System.out.println("c1 equivalent to c4? " + (c1.equals(c4)) );

    }

}
