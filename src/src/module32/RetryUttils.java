package src.module32;

import java.util.Scanner;

@FunctionalInterface
interface Retry<R, T, I, P> {
    R run(T t, I i, P p);
}


final class RetryUtils {
    public static Retry<Integer, Runnable, Integer, Long> retry = RetryUtils::retryAction;

    private RetryUtils() {
    }

    public static int retryAction(
            Runnable action, int maxAttempts, long delayBeforeRetryMs) {

        int fails = 0;
        while (fails < maxAttempts) {
            try {
                action.run();
                return fails;
            } catch (Exception e) {
                System.out.println("Something goes wrong");
                fails++;
                try {
                    Thread.sleep(delayBeforeRetryMs);
                } catch (InterruptedException interruptedException) {
                    throw new RuntimeException(interruptedException);
                }
            }
        }
        return fails;
    }
}

class Retrying {
    private static final int MAX_ATTEMPTS = 10;
    private static final long DELAY_MS = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RetryUtils.retry.run(() -> System.out.println(scanner.nextLine()), MAX_ATTEMPTS, DELAY_MS);
    }
}