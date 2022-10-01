package module6.Spliterators;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomSpliterator implements Spliterator<Integer> {
    private final List<Integer> numbers;
    private int start;
    private int end;

    public CustomSpliterator(List<Integer> numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }


    @Override
    public boolean tryAdvance(Consumer<? super Integer> action) {
        if (start <= end) {
            action.accept(numbers.get(start++));
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Integer> trySplit() {
        if (estimateSize() <= 1000) return null;

        int middle = (start + end) / 2;

        int oldStart = start;
        start = middle + 1;

        return new CustomSpliterator(numbers, oldStart, middle);
    }

    @Override
    public long estimateSize() {
        return end - start + 1;
    }

    @Override
    public int characteristics() {
        return SIZED | ORDERED | SUBSIZED;
    }

    public static void main(String[] args) {

    }
}
