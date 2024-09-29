// Kibitkin Ilya IT3-2307
public class TestCylinder {
    public static void main(String[] args) {

        Cylinder c1 = new Cylinder(3.0, 7.0);
        System.out.println("Cylinder 1: "
                + "radius=" + c1.getRadius()
                + ", height=" + c1.getHeight()
                + ", volume=" + c1.getVolume()
                + ", color=" + c1.getColor());
        c1.setColor("orange");
        c1.setHeight(12);
        System.out.println("Cylinder 1: "
                + "radius=" + c1.getRadius()
                + ", height=" + c1.getHeight()
                + ", volume=" + c1.getVolume()
                + ", color=" + c1.getColor());
    }
}
