// Kibitkin Ilya IT3-2307
public class TestMyCircle {
    public static void main(String[] args) {
        MyCircle c1 = new MyCircle();
        System.out.println(c1);

        MyCircle c2 = new MyCircle(5, 5, 10);
        System.out.println(c2);

        MyPoint p = new MyPoint(3, 3);
        MyCircle c3 = new MyCircle(p, 7);
        System.out.println(c3);

        System.out.println("Radius of c2: " + c2.getRadius());
        c2.setRadius(15);
        System.out.println("Updated radius of c2: " + c2.getRadius());

        // Test getCenter() and setCenter()
        System.out.println("Center of c3: " + c3.getCenter());
        c3.setCenter(new MyPoint(8, 8));
        System.out.println("Updated center of c3: " + c3.getCenter());

        // Test getArea() and getCircumference()
        System.out.println("Area of c2: " + c2.getArea());
        System.out.println("Circumference of c2: " + c2.getCircumference());

        // Test distance between c1 and c2
        System.out.println("Distance between c1 and c2: " + c1.distance(c2));
    }
}
