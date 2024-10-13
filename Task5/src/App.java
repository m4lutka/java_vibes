// Kibitkin Ilya IT3-2307

abstract class Shape {

    protected String color = "red";
    protected Boolean filled = true;

    public Shape(){

    }
    public Shape(String color, Boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Boolean isFilled(){
        return this.filled;
    }
    public void setFilled(Boolean filled){
        this.filled = filled;
    }



    public abstract Double getArea();
    public abstract Double getPerimeter();

    @Override
    public String toString(){
        return "Shape=[color= " + this.color + ", filled= " + this.filled + "]";
    }

}

class Circle extends Shape{
    protected Double radius = 1.0;

    public Circle(){
        super();
    }
    public Circle(Double radius){
        this.radius = radius;
    }
    public Circle(Double radius, String color, Boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public Double getRadius(){
        return this.radius;
    }
    public void setRadius(Double radius){
        this.radius = radius;
    }

    @Override
    public Double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public Double getPerimeter() {
        return this.radius * 2 * Math.PI;
    }

    @Override
    public String toString(){
        return "Circle[Shape=[color= " + this.color + ", filled= " + this.filled + "]" + ", radius=" + this.radius + "]";
    }

}





class Rectangle extends Shape {
    protected Double width = 1.0;
    protected Double length = 1.0;

    public Rectangle(){
        super();
    }

    public Rectangle(Double width, Double length){
        this.width = width;
        this.length = length;
    }

    public Rectangle(Double width, Double length, String color, Boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Double getWidth(){
        return this.width;
    }
    public void setWidth(Double width){
        this.width = width;
    }

    public Double getLength(){
        return this.length;
    }
    public void setLength(Double length){
        this.length = length;
    }
    public Double getArea(){
        return this.width * this.length;
    }
    public Double getPerimeter(){
        return (this.width + this.length) * 2;
    }
    @Override
    public String toString(){
        return "Rectangle[Shape[color=" + this.color + ", filled=" + this.filled + "], width=" + this.width + ", length=" + this.length + "]";
    }
}

class Square extends Rectangle{
    public Square(){
        super();
    }

    public Square(Double side){
        super(side, side);

    }
    public Square(Double side, String color, Boolean filled){
        super(side, side, color, filled);

    }

    public Double getSide(){
        return this.width;
    }

    public void setSide(Double side){
        this.width = side;
        this.length = side;
    }

    public void setWidth(Double side){
        this.width = side;
    }

    public void setLength(Double side){
        this.length = side;
    }

    @Override
    public String toString(){
        return "Square[Rectangle[Shape[color=" + this.color + ", filled=" + this.filled + "], width=" + this.width + ", length=" + this.length + "]]";
    }

}

interface Test {
    static void makeGood() {
        System.out.println("hmm");
    }
}

public class App {
    public static void main(String[] args) {
        Shape s1 = new Circle(5.5, "red", false);  // Upcast Circle to Shape
        System.out.println(s1);                    // which version?
        System.out.println(s1.getArea());          // which version?
        System.out.println(s1.getPerimeter());     // which version?
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        System.out.println(((Circle) s1).getRadius());

        Circle c1 = (Circle)s1;                   // Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        // Shape s2 = new Shape();

        Shape s3 = new Rectangle(1.0, 2.0, "red", false);   // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        System.out.println(((Rectangle)s3).getLength());

        Rectangle r1 = (Rectangle)s3;   // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape s4 = new Square(6.6);     // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        System.out.println(((Square)s4).getSide());

        // Take note that we downcast Shape s4 to Rectangle,
        //  which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        System.out.println(((Square) r2).getSide());
        System.out.println(r2.getLength());

        // Downcast Rectangle r2 to Square
        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());

        Test.makeGood();
    }
}