public class Point implements Comparable {
    private double x, y;

    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    private boolean checkType(Object point_other) {
        return point_other instanceof Point;
    }

    public int compareTo(Point point_other) {
        if (this.x > point_other.x) {
            return 1;
        } else if (this.x == point_other.x && this.y > point_other.y) {
            return 1;
        } else if (this.x == point_other.x && this.y == point_other.y) {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean equal(Point point) {
        if(this.x == point.x && this.y == point.y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lessThan(Point point_other) {
        if(x > point_other.x) {
            return false;
        } else if (y > point_other.y) {
            return false;
        } else {
            return true;
        }
    }
    public static void main(String[] args) {
         Order O1 = new Point(0, 0);
         Order O2 = new Point(1, 1);
        Order O3 = new Point(0, 1);
 
        System.out.println("O1 less than O2: " + O1.lessThan(O2)); // true
         System.out.println("O1 less than O3: " + O1.lessThan(O3)); // true
         System.out.println("O2 less than O3: " + O2.lessThan(O3)); // false
         System.out.println("O3 less than O3: " + O3.lessThan(O3)); // false
 
         Comparable C1 = new Point(0, 0);
         Comparable C2 = new Point(1, 1);
       Comparable C3 = new Point(0, 1);
 
       System.out.println("C1 less than C2: " + C1.compareTo(C2)); // -1
        System.out.println("C1 less than C3: " + C1.compareTo(C3)); // -1
         System.out.println("C2 less than C3: " + C2.compareTo(C3)); // 1
        System.out.println("C3 less than C3: " + C3.compareTo(C3)); // 0
     }
}