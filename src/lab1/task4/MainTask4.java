package lab1.task4;

public class MainTask4 {

    public static void main(String[] args) {

        Object arr = ArrayUtil.create1DArray(int.class, 5);
        System.out.println(ArrayUtil.arrayToString(arr));

        Object matrix = ArrayUtil.create2DArray(int.class, 3, 3);
        System.out.println(ArrayUtil.arrayToString(matrix));
    }
}
