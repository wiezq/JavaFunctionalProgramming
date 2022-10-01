package module6.ParallelStreams;

import java.util.List;
import java.util.stream.LongStream;

class NumberUtils {
    public static void main(String[] args) {
        int result = List.of(1,2,3,4,5).parallelStream().reduce(100, Integer::sum);
        System.out.println(result);
    }

    public static boolean isPrime(long n) {
        return n > 1 && LongStream
                .rangeClosed(2, n - 1)
                .noneMatch(divisor -> n % divisor == 0);
    }
    public static LongStream createPrimesFilteringStream(long start, long end) {
        return LongStream.rangeClosed(start,end).parallel().filter(NumberUtils::isPrime);
    }
}
