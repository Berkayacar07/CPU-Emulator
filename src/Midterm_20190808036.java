
import java.io.File;
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
    static Integer[] M = new Integer[(int) Math.pow(2,16)];
    static int AC = 0;
    static int PC = 0;
    static int F = 0;

    public void dosyaOkuX() {
        File file = new File("program.txt");
        int index = 0;
        try {
            Scanner text = new Scanner(file);
            while (text.hasNextLine()) {
                split = text.next().split(" ");
                program.add(index, split[0]);
                index++;

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
    public void ADDM(int index) {
        AC += M[Integer.parseInt(program.get(index + 1))];
    }
    public void SUBM(int index) {
        AC -= M[Integer.parseInt(program.get(index + 1))];
    }
    public void SUB(int index) {
        AC -= Integer.parseInt(program.get(index + 1));
    }
    public void MUL(int index) {
        AC *= Integer.parseInt(program.get(index + 1));
    }
    public void MULM(int index) {
        AC *= M[Integer.parseInt(program.get(index + 1))];
    }
    public void STORE(int index){
        M[Integer.parseInt(program.get(index+1))]=AC;

    }
    public void DISP() {
        System.out.println(AC);
    }
    public void CMPM(int index){
        if(AC>M[Integer.parseInt(program.get(index + 1))]){
            F=1;
        }else if (AC==M[Integer.parseInt(program.get(index + 1))]){
            F=0;
        }else {
            F=-1;
        }
    }
    public void JMP(int index) {
        PC = Integer.parseInt(program.get(index + 1));
    }

    public void LOADM(int index){
        AC = M[Integer.parseInt(program.get(index+1))];
    }
    public void CJMP(int index){
        if(F==1){
            PC=Integer.parseInt(program.get(index + 1));
        }
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
            } else if (program.get(i).equals("ADD")) {
                ADD(i);
            }else if (program.get(i).equals("STORE")){
                STORE(i);
            }else if (program.get(i).equals("DISP")){
                DISP();
            }else if (program.get(i).equals("LOADM")) {
                LOADM(i);
            }else if (program.get(i).equals("SUB")) {
                SUB(i);
            }else if (program.get(i).equals("MUL")) {
                MUL(i);
            }else if (program.get(i).equals("ADDM")) {
                ADDM(i);
            }else if (program.get(i).equals("SUBM")) {
                SUBM(i);
            }else if (program.get(i).equals("MULM")) {
                MULM(i);
            }else if (program.get(i).equals("JMP")) {
                JMP(i);
            }else if (program.get(i).equals("CMPM")) {
                CMPM(i);
            }else if (program.get(i).equals("CJMP")) {
                CJMP(i);
            }
        }
    }
}

