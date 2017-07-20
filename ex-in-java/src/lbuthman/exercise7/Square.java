package lbuthman.exercise7;

class Square {

    private double length;
    private double height;

    Square(double length, double height) {
        this.length = length;
        this.height = height;
    }

    double calculateAreaInFeet(Square square) {
        return square.height * square.length;
    }

    double calculateAreaInMeters(Square square) {
        final double CONVERSION_FACTOR = 0.09290304;
        double area = calculateAreaInFeet(square);
        return area * CONVERSION_FACTOR;
    }
}
