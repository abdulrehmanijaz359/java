public class HolderDemo {

    public static void main(String[] args) {
        Holder<Integer> intHolder = new Holder<>(4, 7);
        Holder<String> stringHolder = new Holder<>("Hello", "World");

        System.out.println(intHolder);
        System.out.println(stringHolder);
    }
}