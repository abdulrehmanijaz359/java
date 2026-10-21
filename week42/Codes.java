import java.util.LinkedList;
import java.util.Queue;

public class Codes
{
    // sign = +1 encrypts, sign = -1 decrypts
    public static String transform(String text, int[] key, int sign)
    {
        Queue<Integer> keyQueue = new LinkedList<Integer>();
        for (int k : key)
            keyQueue.add(k);

        String result = "";
        for (int scan = 0; scan < text.length(); scan++)
        {
            Integer keyValue = keyQueue.remove();
            result += (char) (text.charAt(scan) + sign * keyValue);
            keyQueue.add(keyValue);
        }
        return result;
    }

    private static void test(String name, int[] key, String message)
    {
        String encoded = transform(message, key, +1);
        String decoded = transform(encoded, key, -1);
        System.out.println("=== " + name + " ===");
        System.out.println("Original: " + message);
        System.out.println("Encoded:  " + encoded);
        System.out.println("Decoded:  " + decoded);
        System.out.println("Match:    " + message.equals(decoded) + "\n");
    }

    public static void main(String[] args)
    {
        String message = "All programmers are playwrights and all " +
                         "computers are lousy actors.";

        test("Lecture key", new int[] {5, 12, -3, 8, -9, 4, 10}, message);
        test("Increment by 1", new int[] {1}, "Hello, World!");
        test("Decrement by 1", new int[] {-1}, "Hello, World!");
        test("Longer key",
             new int[] {3, -7, 11, 2, -5, 9, 14, -2, 6, -10, 1, 8, -4, 13, -6}, message);
    }
}