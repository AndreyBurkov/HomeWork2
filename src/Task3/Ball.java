package Task3;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        if (Math.abs(direction) >= 360 ) direction %= 360;
        if (direction > 180) direction = direction - 360;
        if (direction <= -180) direction = 360 + direction;
        xDelta = (float)(speed * Math.cos(direction * Math.PI / 180.0));
        yDelta = (float)(-speed * Math.sin(direction * Math.PI / 180.0));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" + x + "," + y + "),speed=(" + xDelta + "," + yDelta + ")]";
    }

    public void turnBall(Container container) { // Меняет направление движения мяча при выходе за границы контейнера
        if (x - radius < container.getX()) reflectHorizontal();
        if (x + radius > container.getX() + container.getWidth()) reflectHorizontal();
        if (y - radius < container.getY()) reflectVertical();;
        if (y + radius > container.getY() + container.getHeight()) reflectVertical();
    }
}
