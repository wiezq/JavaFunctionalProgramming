package module3.LamdaExpression;
import java.util.Scanner;
import java.util.function.Function;

class DigitsSubstitution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextInt();

        int result = Utils.substitution(n, (digit) -> {
            return switch (digit) {
                case 5 -> 1;
                case 6 -> 2;
                case 7 -> 3;
                case 8 -> 4;
                case 9 -> 5;
                default -> digit;
            };
        }); // modify the lambda expression

        System.out.println(result);
    }
}

class Utils {

    public static int substitution(long n, Function<Integer, Integer> digitRule) {
        String numberAsString = String.valueOf(n);
        int result = 0;

        for (int i = 0; i < numberAsString.length(); i++) {
            result *= 10;
            int nextDigit = Integer.parseInt(String.valueOf(numberAsString.charAt(i)));
            result += digitRule.apply(nextDigit);
        }

        return result;
    }
}