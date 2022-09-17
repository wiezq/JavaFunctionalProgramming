package module5.FindingElems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class HealthChecker {

    public static boolean checkPulseMeasurements(List<Integer> pulseMeasurements) {
        return pulseMeasurements.stream()
                .allMatch(integer -> integer >= 90 && integer <= 150);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> measurements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(checkPulseMeasurements(measurements));
    }
}