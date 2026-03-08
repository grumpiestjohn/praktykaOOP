import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String m = null, h = null, target = "1";
        int M = 0, H = 0, record = 0;
        System.out.print("Enter the object's weight: ");
        try {
            M = Integer.parseInt(in.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
        System.out.print("Enter the height the object is at: ");
        try {
            H = Integer.parseInt(in.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.print("Error: " + e);
            System.exit(0);
        }
        long E = Math.round(M * 9.18 * H);
        System.out.println("Potential energy (rounded): " + E);
        String Ebit = Long.toBinaryString(E);
        System.out.println("PE in binary: " + Ebit);
        while (Ebit.contains(target)) {
            target += '1';
            record += 1;
        }
        System.out.print("Most '1' in a row: " + record);
    }
}