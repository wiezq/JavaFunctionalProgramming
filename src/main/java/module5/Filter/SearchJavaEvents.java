package module5.Filter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SearchJavaEvents {

    public static void printSortedJavaEvents(List<String> events) {
        events.stream()
                .filter(s -> s.toLowerCase().contains("java"))
                .sorted()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> events = Stream
                .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine())
                .collect(Collectors.toList());

        printSortedJavaEvents(events);
    }
}