class Point {
    private double x, y;
    public Point(double x, double y) {} // todo
    public double getX() {
      return x;
    }
    public double getY() {
      return y;
    }
}

enum Quadrant {
    Q1, // x +ve, y +ve
    Q2, // x -ve, y +ve
    Q3, // x -ve, y -ve
    Q4; // x +ve, y -ve
}

interface GridQuadrant {
    Quadrant getQuadrant(); // return which quadrant the point is in
        // if point is at (0,0) return null
}
// TODO: modify Point to implement GridQuadrant

interface CompareQuadrant {
    boolean isInSameQuadrant(Point point); // true if given point is
                                     // in the same quadrant as this point
}
// TODO: modify Point to implement CompareQuadrant

interface PointMaker {
    Point makePoint(double x, double y) {}; // returns point with given x,y
    int countPointsCreated(); // returns count of points created via factory
}
// TODO: create class PointFactory which implements the interface PointMaker
class PointFactory implements PointMaker {
  Point makePoint(double x, double y) {
    return Point(x, y);
  }
}