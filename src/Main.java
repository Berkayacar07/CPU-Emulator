import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String[] split;
    static String[] split2;
    static ArrayList<String> program = new ArrayList<>();
    static Integer[] M = new Integer[(int) Math.pow(2,16)];
    static int AC = 0;
    static int PC = 0;
    static int F = 0;
    public static void main(String args[]) {
        //dosyaOkuX();
    }
    public static void dosyaOkuX() {

        File file = new File("program.txt");

        int index = 0;

        try (BufferedReader okuyucu = new BufferedReader
                (new FileReader("program.txt"))) {
            Scanner text1= new Scanner(file);
            String text;
            aa:
            while ((text = okuyucu.readLine()) != null) {
                split2 = text.split(" ");
                PC = Integer.parseInt(split2[0]);
                //System.out.println(PC);
                try {
                    while (text1.hasNextLine()) {
                        split = text1.next().split(" ");
                        //if(split2[0]!=split[0]){
                            program.add(split[0]);
                        //}
                        continue aa;

                    }
                    text1.close();


                } catch
                (Exception e) {
                }
            }
        } catch (Exception e) {
            System.out.println("Dosya bulunamadı");
        }

    }
    public static void dosyaOku() {
        try (BufferedReader okuyucu = new BufferedReader
                (new FileReader("program.txt"))) {
            String text;
            while ((text = okuyucu.readLine()) != null) {
                split2 = text.split(" ");
                PC = Integer.parseInt(split2[0]);
                System.out.println(PC);
            }
        } catch (Exception e) {
            System.out.println("Dosya bulunamadı");
        }
    }
//        try
//        {
//            File file=new File("program.txt");    //creates a new file instance
//            FileReader fr=new FileReader(file);   //reads the file
//            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
//            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
//            String line;
//            while((line=br.readLine())!=null)
//            {
//                sb.append(line);      //appends line to string buffer
//                sb.append("\n");     //line feed
//            }
//            fr.close();    //closes the stream and release the resources
//            System.out.println(sb.toString());   //returns a string that textually represents the object
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
    }
