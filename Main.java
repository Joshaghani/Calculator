import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var number1 = getInputNumber("عدد اول را وارد کن");

        String temp = number1 + "";

        while (true) {
            var operator = getInputOperator("عملگر را وارد کن");

            if (operator.equals("=")) {
                break;
            }

            var number2 = getInputNumber("عدد دوم را وارد کن");

            temp += " " + operator + " " + number2;

            var result = calculate(number1, number2, operator);

            print(temp + " = " + result);

            number1 = result;
        }

        print(number1 + "");
    }


    static int getInputNumber(String message) {
        print(message);
        try {
            return new Scanner(System.in).nextInt();
        } catch (Exception e) {
            return getInputNumber(message);
        }
    }

    static String getInputOperator(String message) {
        print(message);
        var op = new Scanner(System.in).next();
        return switch (op) {
            case "+", "-", "*", "/", "=" -> op;
            default -> getInputOperator(message);
        };
    }


    static int calculate(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }

    static void print(String message) {
        System.out.println(message);
    }

}
