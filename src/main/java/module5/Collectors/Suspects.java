package module5.Collectors;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Suspects {

    public static List<String> reduceSuspects(List<String> suspects) {
         return suspects.stream()
                 .filter(s -> s.contains("jo"))
                 .sorted()
                 .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> suspects = Stream
                .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine())
                .collect(Collectors.toList());

        reduceSuspects(suspects)
                .forEach(System.out::println);
    }
}