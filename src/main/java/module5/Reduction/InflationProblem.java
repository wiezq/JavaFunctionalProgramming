package module5.Reduction;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.pow;

class InflationProblem {

    public static long calculateTotalPriceInFuture(int numberOfYears, List<Grocery> groceries) {
        Long veg = groceries.stream()
                .filter(grocery -> grocery.getCategory().equals(Category.VEGETABLES))
                .map(grocery -> (long) (grocery.getCost() * pow(3,numberOfYears)))
                .reduce(0L, Long::sum);
        Long fruits = groceries.stream()
                .filter(grocery -> grocery.getCategory().equals(Category.FRUITS))
                .map(grocery -> (long) (grocery.getCost() * pow(4,numberOfYears)))
                .reduce(0L, Long::sum);
        Long dairy = groceries.stream()
                .filter(grocery -> grocery.getCategory().equals(Category.DAIRY))
                .map(grocery -> (long) (grocery.getCost() * pow(2,numberOfYears)))
                .reduce(0L, Long::sum);
        return veg + fruits + dairy;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfYears = Integer.parseInt(scanner.nextLine());

        List<Grocery> groceries = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine())
                .map(inputLine -> {
                    String[] parts = inputLine.split("\\s+");
                    return new Grocery(Long.parseLong(parts[0]), Category.valueOf(parts[1]));
                })
                .collect(Collectors.toList());

        long totalPriceInFuture = calculateTotalPriceInFuture(numberOfYears, groceries);

        System.out.println(totalPriceInFuture);
    }
}

enum Category {
    VEGETABLES,
    FRUITS,
    DAIRY
}

class Grocery {
    private final long cost;
    private final Category category;

    // Imagine that this class has some other fields, but they are skipped for simplicity

    public Grocery(long cost, Category category) {
        this.cost = cost;
        this.category = category;
    }

    public long getCost() {
        return cost;
    }

    public Category getCategory() {
        return category;
    }
}