package lab1.task2;

public class Check {

    private double x;
    private double y;

    public Check(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double dist() {
        return Math.sqrt(x * x + y * y);
    }

    public void setRandomData() {
        this.x = Math.random() * 10;
        this.y = Math.random() * 10;
    }

    @Override
    public String toString() {
        return "Check{x=" + x + ", y=" + y + "}";
    }
}
