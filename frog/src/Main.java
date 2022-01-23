import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Frog frog = new Frog();

    public static void main(String[] args) {
        String[] field = new String[11];
        Scanner scanner = new Scanner(System.in);
        String command;
        int steps;
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;

        do {
            Arrays.fill(field, "_");
            command = scanner.nextLine();

            if ("<<".equals(command)) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (">>".equals(command)) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего отменять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).doit();
                }
            } else if ("!!".equals(command)) {
                if (curCommand < 0) {
                    System.out.println("Нечего повторять");
                } else {
                    commands.get(curCommand).doit();
                }
            } else {
                if (curCommand != commands.size() - 1) {
                    commands.clear();
                }
                steps = Integer.parseInt(command);
                FrogCommand cmd = FrogCommands.jumpRightCommand(frog, steps);
                curCommand++;
                commands.add(cmd);
                cmd.doit();
            }

            field[frog.position] = frog.name;
            for (String s : field) {
                System.out.print(" " + s);
            }
            System.out.println();
        } while (!"0".equals(command));
    }
}