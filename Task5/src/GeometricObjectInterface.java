// Kibitkin Ilya IT3-2307

public interface GeometricObjectInterface {
    public Double getArea();
    public Double getPerimeter();
}

class Circle implements GeometricObjectInterface {
    private Double radius;

    public Circle(Double radius){
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + this.radius + "]";
    }

    @Override
    public Double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public Double getPerimeter() {
        return this.radius * 2 * Math.PI;
    }

}


class Rectangle implements GeometricObjectInterface {
    private Double width;
    private Double length;

    public Rectangle(Double width, Double length){

    }

    public Double getArea(){
        return this.width * this.length;
    }
    public Double getPerimeter(){
        return (this.width + this.length) * 2;
    }

    @Override
    public String toString(){
        return "Rectangle[width=" + this.width + ", length=" + this.length + "]";
    }
}
