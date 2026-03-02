package lab1.task1;

import java.util.Scanner;

public class MainConsole {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full class name: ");

        String name = scanner.nextLine();

        System.out.println(ClassAnalyzer.analyze(name));
    }
}
