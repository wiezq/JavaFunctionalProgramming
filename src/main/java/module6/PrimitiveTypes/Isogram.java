package module6.PrimitiveTypes;
import java.util.Scanner;
import java.util.stream.IntStream;

class Isogram {

    public static boolean isIsogram(String word) {
        return word.chars().distinct().count() == word.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        System.out.println(isIsogram(word));
    }
}