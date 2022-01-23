public class Main {

    public static void main(String[] args) {
        for (int r : new Randoms(70, 80)) {
            System.out.println("Случайное число: " + r);
            if (r == 80) {
                System.out.println("Выпало число 80, давайте на этом закончим");
                break;
            }
        }
    }
}