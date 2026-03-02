package lab1.task3;

class MainTask3 {

    public static void main(String[] args) throws Exception {

        TestClass obj = new TestClass(1);

        Object result1 = MethodInvoker.invoke(obj, "func", 1.0);
        System.out.println("Result 1: " + result1);

        Object result2 = MethodInvoker.invoke(obj, "func", 1.0, 1);
        System.out.println("Result 2: " + result2);
    }
}
