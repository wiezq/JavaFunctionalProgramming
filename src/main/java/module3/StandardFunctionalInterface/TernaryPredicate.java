package module3.StandardFunctionalInterface;


import java.util.Objects;

public class TernaryPredicate {
    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (a, b, c) ->
            !Objects.equals(a, b) && !Objects.equals(b, c) && !Objects.equals(a, c);
}


@FunctionalInterface
interface TernaryIntPredicate {
    Boolean test(Integer t, Integer u, Integer i);
}