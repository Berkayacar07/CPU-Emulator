import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Midterm_20190808036 {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        cpu.dosyaOkuX();
        cpu.instructionSetOperations();
    }
}

class CPU {
    static String[] split;
    static ArrayList<String> program = new ArrayList<>();
    static int AC = 0;

    public void dosyaOkuX() {
        File file = new File("program.txt");
        int index = 0;
        try {
            Scanner text = new Scanner(file);
            while (text.hasNextLine()) {
                split = text.next().split(" ");
                program.add(index, split[0]);
                index++;
                System.out.println(program.get(0));

            }
            text.close();

        } catch
        (Exception e) {
        }
    }

    public void HALT() {
        System.exit(0);
    }

    public void LOAD(int index) {
        AC = Integer.parseInt(program.get(index + 1));
    }

    public void ADD(int index) {
        AC += Integer.parseInt(program.get(index + 1));
    }


    public void instructionSetOperations() {
        for (int i = 0; i < program.size(); i++) {
            if (!program.get(0).equals("START")) {
                System.out.println("Instruction set should be start with START");
                HALT();
            } else if (program.get(i).equals("HALT")) {
                HALT();
            } else if (program.get(i).equals("LOAD")) {
                LOAD(i);
                System.out.println(AC);
            } else if (program.get(i).equals("ADD")) {
                ADD(i);
                System.out.println(AC);
            }
        }
    }
}

