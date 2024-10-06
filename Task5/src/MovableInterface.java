// Kibitkin Ilya IT3-2307

public interface MovableInterface {
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
}

class MovablePoint implements MovableInterface{
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void moveUp(){
        this.y = this.y - ySpeed;
    }
    public void moveDown(){
        this.y = this.y + ySpeed;
    }
    public void moveLeft(){
        this.x = this.x - xSpeed;
    }
    public void moveRight(){
        this.x = this.x + xSpeed;
    }

    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ") speed =(" + this.x + ", " + this.y + ")";
    }
}

class MovableCircle implements MovableInterface {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    public void moveUp(){
        center.y = center.y - center.ySpeed;
    }
    public void moveDown(){
        center.y = center.y + center.ySpeed;
    }
    public void moveLeft(){
        center.x = center.x - center.xSpeed;
    }
    public void moveRight(){
        center.x = center.x + center.xSpeed;
    }

    @Override
    public String toString(){
        return "(" + center.x + ", " + center.y + ") speed =(" + center.x + ", " + center.y + "),radius = " + this.radius;
    }

}