import java.io.*;
import java.util.Scanner;



public class mat2 implements Serializable {
    public double x;
    public double y;

    public mat2(double x) {
        this.x = x;
        this.y = x - Math.sin(x);
    }




    public void save() {
        try {
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("state.txt"));
            objOut.writeObject(this);
            System.out.println("Состояние объекта сохранено в файл 'state.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void upload() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("state.txt"));
            mat2 calculator = (mat2) in.readObject();
            System.out.println("Восстановленное состояние:");
            System.out.println("Значение x: " + calculator.x);
            System.out.println("Значение y: " + calculator.y);

        } catch (Exception e) {
            System.out.println(e);
        }

    }




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите x");
        mat2 calc = new mat2(Math.toRadians(in.nextDouble()));
        System.out.println("Введите save, если хотите сохранить в файл состояние объекта");
        String state = in.next();
        if (state.equals("save")){
            calc.save();
        }
        else {
            System.out.println("что-то не так");
        }
        System.out.println("Введите upload, если хотите восстановить сохраненные данные");
        state = in.next();
        if (state.equals("upload")){
            upload();
        }
        else {
            System.out.println("что-то не так");
        }

    }
}