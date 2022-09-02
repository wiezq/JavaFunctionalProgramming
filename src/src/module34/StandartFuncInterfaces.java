package src.module34;

import java.util.function.*;

public class StandartFuncInterfaces {
    public static void main(String[] args) {
        IntBinaryOperator intBinaryOperator = (a, b) -> a > b ? a : b;
        ToIntFunction<String> toIntFunction = string -> string.length();
        BiPredicate<Long, Boolean> tooMuch = (balance, locked) -> !locked && balance >= 100_000_000 ;
    }
}
