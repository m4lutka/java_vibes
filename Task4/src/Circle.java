// Kibitkin Ilya IT3-2307
public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle[radius = " + radius + ", color = " + color + "]";
    }
}

class Cylinder {
    private double height = 1.0;
    private Circle circle;

    public Cylinder() {
        this.circle = new Circle();
    }

    public Cylinder(double radius) {
        this.circle = new Circle(radius);
    }

    public Cylinder(double radius, double height) {
        this.circle = new Circle(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        this.circle = new Circle(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return height * circle.getRadius() * circle.getRadius() * Math.PI;
    }

    public double getRadius(){
        return circle.getRadius();
    }

    public void setRadius(double radius){
        circle.setRadius(radius);;
    }

    public String getColor(){
        return circle.getColor();
    }

    public void setColor(String color){
        circle.setColor(color);
    }


}
