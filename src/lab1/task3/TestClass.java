package lab1.task3;

public class TestClass {

    private double a;

    public TestClass(double a) {
        this.a = a;
    }

    public double func(double x) {
        return Math.exp(-Math.abs(a) * x) * Math.sin(x);
    }

    public double func(double x, int dummy) {
        return Math.exp(-Math.abs(a) * x) * Math.sin(x);
    }
}
