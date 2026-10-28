import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeTester {

    public static boolean isPalindrome(String text) {
        Deque<Character> stack = new ArrayDeque<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {          // ignore spaces/punctuation
                char lower = Character.toLowerCase(c);   // ignore case
                stack.push(lower);
                queue.add(lower);
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = in.nextLine();
        System.out.println("\"" + s + "\" is "
                + (isPalindrome(s) ? "" : "not ") + "a palindrome.");
    }
}