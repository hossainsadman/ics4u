package _5_1;

import java.util.Random;

public class Die_2 implements Comparable<Die_2>{
    private int sides;
    private int value;
    private Random random = new Random();

    Die_2(int sides) {
        this.sides = sides;
        roll();
    }

    int getSides() {
        return this.sides;
    }

    void setSides(int sides) {
        this.sides = sides;
        roll();
    }

    int getValue() {
        return value;
    }

    void roll() {
        value = random.nextInt(sides);
    }

    @Override
    public String toString() {
        return "d" + sides + ": " + value;
    }

    @Override
    public boolean equals(Object obj) {
        Die_2 d = (Die_2) obj;
        return this.value == d.value;
    }

    @Override
    public int compareTo(Die_2 d) {
        return this.value - d.value;
    }
}

class Test {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Roll two six-sided dice and display their values until doubles
        // (two of the same) are rolled.
        Die_2 d1 = new Die_2(6);
        Die_2 d2 = new Die_2(6);
        while (!d1.equals(d2)) {
            System.out.println("You rolled " + d1.getValue() + " and " + d2.getValue() + ". Trying again!");
            d1.roll();
            d2.roll();
        }
        System.out.println("You rolled doubles: " + d1.getValue() + ", " + d2.getValue());
    }
}
