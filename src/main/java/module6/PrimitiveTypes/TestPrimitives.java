package module6.PrimitiveTypes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class TestPrimitives {

    @Test
    void testPrimitive()
    {

        LongSummaryStatistics stat = LongStream.empty().summaryStatistics();
        System.out.println(stat);
    }
}
