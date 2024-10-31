import java.util.*;

public class RandomGenerator {
    public static char generate_character() {
        return (char) (random.nextInt(26) + 'a');
    }

    public static int generate_integer(int min, int max) {
        return random.nextInt(min, max);
    }

    static Random random = new Random();
}
