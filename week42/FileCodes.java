import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileCodes {
    private static final int[] KEY = { 5, 12, -3, 8, -9, 4, 10 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input file name: ");
        String inName = in.nextLine().trim();
        System.out.print("Output file name: ");
        String outName = in.nextLine().trim();
        System.out.print("Encrypt (E) or decrypt (D)? ");
        String mode = in.nextLine().trim().toUpperCase();

        int sign;
        if (mode.equals("E"))
            sign = 1;
        else if (mode.equals("D"))
            sign = -1;
        else {
            System.out.println("Mode must be E or D.");
            return;
        }

        try {
            String text = new String(Files.readAllBytes(Paths.get(inName)),
                    StandardCharsets.ISO_8859_1);

            Queue<Integer> keyQueue = new LinkedList<Integer>();
            for (int k : KEY)
                keyQueue.add(k);

            StringBuilder result = new StringBuilder();
            for (int scan = 0; scan < text.length(); scan++) {
                Integer keyValue = keyQueue.remove();
                result.append((char) ((text.charAt(scan) + sign * keyValue + 256) & 0xFF));
                keyQueue.add(keyValue);
            }

            Files.write(Paths.get(outName),
                    result.toString().getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("Done. Wrote " + result.length() + " characters to " + outName);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}