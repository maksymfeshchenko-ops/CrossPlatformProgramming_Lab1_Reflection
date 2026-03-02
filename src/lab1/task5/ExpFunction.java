package lab1.task5;

public class ExpFunction implements Evaluatable {

    private double a;

    public ExpFunction(double a) {
        this.a = a;
    }

    @Override
    public double evalf(double x) {
        return Math.exp(-Math.abs(a) * x) * Math.sin(x);
    }
}
