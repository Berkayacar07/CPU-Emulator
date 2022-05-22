import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Midterm_20190808036 {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        cpu.dosyaOku();
        cpu.dosyaOkuX();
        cpu.instructionSetOperations();
    }
}

class CPU {
    static String[] split;
    static String[] split2;
    static ArrayList<String> program = new ArrayList<>();
    static ArrayList<Integer> PCarraylist = new ArrayList<>();
    static Integer[] M = new Integer[(int) Math.pow(2, 16)];
    static int AC = 0;
    static int PC;
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

    public void dosyaOku() {
        try (BufferedReader okuyucu = new BufferedReader
                (new FileReader("program.txt"))) {
            String text;
            while ((text = okuyucu.readLine()) != null) {
                split2 = text.split(" ");
                PCarraylist.add(Integer.valueOf(split2[0]));

            }
        } catch (Exception e) {
            System.out.println("Dosya bulunamadı");
        }
    }

    public void instructionSetOperations() {
        while (true) {
            for (int i = 0; i < program.size(); i++) {
                if ((program.get(i)).equals(String.valueOf(PC))) {
                    if (program.get(i + 1).equals("START")) {
                        START();
                    } else if (program.get(i + 1).equals("HALT")) {
                        HALT();
                    } else if (program.get(i + 1).equals("LOAD")) {
                        LOAD(i + 1);
                    } else if (program.get(i + 1).equals("ADD")) {
                        ADD(i + 1);
                    } else if (program.get(i + 1).equals("STORE")) {
                        STORE(i + 1);
                    } else if (program.get(i + 1).equals("DISP")) {
                        DISP();
                    } else if (program.get(i + 1).equals("LOADM")) {
                        LOADM(i + 1);
                    } else if (program.get(i + 1).equals("SUB")) {
                        SUB(i + 1);
                    } else if (program.get(i + 1).equals("MUL")) {
                        MUL(i + 1);
                    } else if (program.get(i + 1).equals("ADDM")) {
                        ADDM(i + 1);
                    } else if (program.get(i + 1).equals("SUBM")) {
                        SUBM(i + 1);
                    } else if (program.get(i + 1).equals("MULM")) {
                        MULM(i + 1);
                    } else if (program.get(i + 1).equals("JMP")) {
                        JMP(i + 1);
                    } else if (program.get(i + 1).equals("CMPM")) {
                        CMPM(i + 1);
                    } else if (program.get(i + 1).equals("CJMP")) {
                        CJMP(i + 1);
                    }
            }
        }
    }
}


public void HALT(){
        System.exit(0);
        }
    public void START() {
        PC++;
    }

public void LOAD(int index){
        AC=Integer.parseInt(program.get(index+1));
        PC=Integer.parseInt(program.get(index+2));
        }

public void ADD(int index){
        AC+=Integer.parseInt(program.get(index+1));
        PC=Integer.parseInt(program.get(index+2));
        }
public void ADDM(int index){
        AC+=M[Integer.parseInt(program.get(index+1))];
        PC=Integer.parseInt(program.get(index+2));
        }
public void SUBM(int index){
        AC-=M[Integer.parseInt(program.get(index+1))];
        PC=Integer.parseInt(program.get(index+2));
        }
public void SUB(int index){
        AC-=Integer.parseInt(program.get(index+1));
        PC=Integer.parseInt(program.get(index+2));
        }
public void MUL(int index){
        AC*=Integer.parseInt(program.get(index+1));
        PC=Integer.parseInt(program.get(index+2));
        }
public void MULM(int index){
        AC*=M[Integer.parseInt(program.get(index+1))];
        PC=Integer.parseInt(program.get(index+2));
        }
public void STORE(int index){
        M[Integer.parseInt(program.get(index+1))]=AC;
        PC=Integer.parseInt(program.get(index+2));

        }
public void DISP(){
        System.out.println(AC);
        PC++;
        }
public void CMPM(int index){
        PC=Integer.parseInt(program.get(index+2));
        if(AC>M[Integer.parseInt(program.get(index+1))]){
        F=1;
        }else if(AC==M[Integer.parseInt(program.get(index+1))]){
        F=0;
        }else{
        F=-1;
        }
        }
public void JMP(int index){
        PC=Integer.parseInt(program.get(index+1));

        }

public void LOADM(int index){
        AC=M[Integer.parseInt(program.get(index+1))];
        PC=Integer.parseInt(program.get(index+2));
        }
public void CJMP(int index){
        if(F==1){
        PC=Integer.parseInt(program.get(index+1));
        }else{
            PC++;
        }
        }


        }


//HOCAYA TEXTIN BASINDA NUMARALAR OLACAK MI DİYE SOR..
