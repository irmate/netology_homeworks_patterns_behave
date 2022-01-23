public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;
    protected String name = "F";

    public Frog() {
        position = 5;
    }

    public boolean jump(int steps) {
        if (position + steps > MAX_POSITION || position + steps < MIN_POSITION) {
            return false;
        } else position = position + steps;
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}