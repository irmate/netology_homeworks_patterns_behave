import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        this.random = new Random();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int currentNumber;

            @Override
            public boolean hasNext() {
                return currentNumber < max;
            }

            @Override
            public Integer next() {
                return currentNumber = random.nextInt(min, max + 1);
            }
        };
    }
}