package module35;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class XorPredicate {
    public static <T> Predicate<T> xor(Predicate<T> predicate1, Predicate<T> predicate2) {
        return t -> predicate1.or(predicate2).and(predicate1.negate().or(predicate2.negate())).test(t);
    }


}
