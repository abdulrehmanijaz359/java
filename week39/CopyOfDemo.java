import java.util.Arrays;

public class CopyOfDemo {
    static class Person {
        String name;
        Person(String name) { this.name = name; }
        public String toString() { return name; }
    }

    public static void main(String[] args) {
        // Primitive array
        int[] a = {1, 2, 3};
        int[] b = Arrays.copyOf(a, 5);
        b[0] = 99;
        System.out.println(Arrays.toString(a)); // [1, 2, 3]  -> unchanged
        System.out.println(Arrays.toString(b)); // [99, 2, 3, 0, 0]

        // Object array (Strings are immutable, so use a mutable class to see sharing)
        Person[] p = {new Person("Ann"), new Person("Bob")};
        Person[] q = Arrays.copyOf(p, 3);
        System.out.println(p[0] == q[0]);        // true -> same object
        q[0].name = "Changed";
        System.out.println(Arrays.toString(p));  // [Changed, Bob]  -> original affected
        System.out.println(Arrays.toString(q));  // [Changed, Bob, null]
        q[1] = new Person("Carl");               // replacing a reference
        System.out.println(Arrays.toString(p));  // [Changed, Bob]  -> unaffected

        // With Strings
        String[] s = {"x", "y"};
        String[] t = Arrays.copyOf(s, 2);
        System.out.println(s[0] == t[0]);        // true -> same String object
    }
}