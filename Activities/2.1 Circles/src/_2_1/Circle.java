package _2_1;

public class Circle {

    // ACTIVITY 2.1 - Complete the project by creating the Circle class and all
    // of the required code. Include good comments and ensure your code is
    // readable by utilizing good spacing, both horizontal and vertical. The
    // main method and its class should not be changed at all.

    // 1. Create a class Circle (in the default package) with the required
    //    instance fields (all double).

    private double x;
    private double y;
    private double radius;

    // -------------- REPLACED BY CONSTRUCTOR IN EXERCISE 4 --------------
    // public Circle(double x, double y, double radius) {
    //     this.x = x;
    //     this.y = y;
    //     this.radius = radius;
    // }

    // 2. Write the accessor and mutator methods for each of the instance
    //    fields. Write a mutator method for all three fields at once.

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setAttributes(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // 3. Write a constructor method that has no parameters. The method should
    //    construct a "unit" Circle object with centre (0, 0) and radius 1.

    public Circle() {
        x = 0;
        y = 0;
        radius = 1;
    }

    // 4. Write a constructor method that has three parameters representing the
    //    coordinates of the centre and the radius of the circle to be
    //    constructed. The method should ensure that the circle’s radius is not
    //    negative by changing the sign of any negative radius parameters.

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;

        if (radius < 0) {
            radius *= -1;
        }
        this.radius = radius;
    }

    // 5. Write a constructor method with one parameter, an object of type
    //    Circle.  The method should construct a new Circle object with the
    //    same field values as those of the parameter.

    public Circle(Circle circle) {
        x = circle.x;
        y = circle.y;
        radius = circle.radius;
    }

    // 6. Write an instance method area() that returns, as a double value, the
    //    area of the implicit Circle object.

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    // 7. Write an instance method circumference() that returns, as a double
    //    value, the circumference of the implicit Circle object.

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    // 8. Write an instance method diameter() that returns, as a double value,
    //    the diameter of the implicit Circle object.

    public double diameter() {
        return 2 * radius;
    }

    // 9. Write an instance method smaller(Circle c) that could be called by a
    //    statement like:

    // Circle c3 = c1.smaller(c2);

    //     where c1, c2, and c3 are objects of type Circle. The method should
    //     make c3 refer to the smaller of the circles, by area, represented by
    //     c1 and c2 (or c1 if c1 and c2 are the same size)

    public Circle smaller(Circle c) {
        if (area() <= c.area()) {
            return this;
        }
        return c;
    }

    // 10. Write an instance method distance(Circle c) that returns the
    //     distance between the centres of the two circles specified by the
    //     implicit and the explicit object parameters.

    // Usage: double d = c1.distance(c2);

    public double distance(Circle c) {
        return Math.sqrt(Math.pow(x - c.x, 2) + Math.pow(y - c.y, 2));
    }

    // 11. Write an instance method isInside() that could be called by a
    //     statement like

    //     boolean contained = c1.isInside(c2);

    // The method should return true if c1 is entirely inside and not touching
    // c2 and return false otherwise. Hint: use the distance method.

    public boolean isInside(Circle c) {
        if (distance(c) + radius < c.radius) {
            return true;
        }
        return false;
    }

    // 12. Write an instance method equals(Circle c) that takes a Circle object
    //     as parameter and returns true if and only if the implicit Circle is
    //     equivalent to the parameter object. You will need to decide on what
    //     conditions two circles should be considered "equal".

    public boolean equals(Circle c) {
        if (x == c.x && y == c.y && radius == c.radius) {
            return true;
        }
        return false;
    }

    // 13. Write a class method printEquation(Circle c) which prints the
    //     equation of the circle nicely in Cartesian form. For a Circle object
    //     with x = 3, y = -4, and r = 2, it should print:

    //     (x - 3.0)² + (y + 4.0)² = 4.0

    // Note: you can use the ² character, if you like, just copy and paste.
    // Also, notice the sign change inside the parentheses.

    public static void printEquation(Circle c) {
        String equation = "(x ";

        if (c.x < 0) {
            equation += "+ " + Double.toString(c.x * -1);
        } else {
            equation += "- " + Double.toString(c.x);
        }

        equation += ")² + (y ";

        if (c.y < 0) {
            equation += "+ " + Double.toString(c.y * -1);
        } else {
            equation += "- " + Double.toString(c.y);
        }

        equation += ")² = " + Double.toString(c.radius*c.radius);

        System.out.println(equation);
    }

    // 14. Write an override for the toString() method for the Circle class.
    //     For the same circle as above, the toString method should produce:

    //     Circle: centre at (3.0, -4.0) and radius 2.0

    public String toString() {
        return "Circle: centre at (" + x + ", " + y +") and radius " + radius;
    }

}
