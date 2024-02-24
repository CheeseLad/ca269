class Point implements GridQuadrant, CompareQuadrant {
    private double x, y;
    public Point(double newX, double newY) {
      x = newX;
      y = newY;
    }
    public double getX() {
      return x;
    }
    public double getY() {
      return y;
    }
    public Quadrant getQuadrant() {
      if ((this.x > 0) && (this.y > 0)) {
        return Quadrant.Q1;
      } else if ((this.x < 0) && (this.y > 0)) {
        return Quadrant.Q2;
      } else if ((this.x < 0) && (this.y < 0)) {
        return Quadrant.Q3;
      } else if ((this.x > 0) && (this.y < 0)) {
        return Quadrant.Q4;
      } else {
        return null;
      }
    }

    public boolean isInSameQuadrant(Point point_other) {
      return this.getQuadrant() == point_other.getQuadrant();
    }
    public static void main(String[] args) {
      //Point point1 = new Point(1, 1);
     // Point point2 = new Point(-1, 1);
      //System.out.println(point1.getQuadrant());
      //System.out.println(point2.getQuadrant());
    }
}

enum Quadrant {
    Q1, // x +ve, y +ve
    Q2, // x -ve, y +ve
    Q3, // x -ve, y -ve
    Q4; // x +ve, y -ve
}

interface GridQuadrant {
    Quadrant getQuadrant();// return which quadrant the point is in
        // if point is at (0,0) return null
}
// TODO: modify Point to implement GridQuadrant

interface CompareQuadrant {
    boolean isInSameQuadrant(Point point_other);// true if given point is
                                     // in the same quadrant as this point
}
// TODO: modify Point to implement CompareQuadrant

interface PointMaker {
    Point makePoint(double x, double y); // returns point with given x,y
    int countPointsCreated(); // returns count of points created via factory
}
// TODO: create class PointFactory which implements the interface PointMaker

class PointFactory implements PointMaker {
  int counter;
  final int MAX_POINTS = 100;
  public Point makePoint(double x, double y) {
    counter++;
    return new Point(x, y);
  } 
  
  public int countPointsCreated() {
    return counter;
  }
}