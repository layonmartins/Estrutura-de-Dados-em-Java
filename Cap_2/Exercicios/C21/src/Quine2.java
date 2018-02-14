public class Quine2 {

    static String s = "public class Quine2 { public static void main(String[] args) { char c=34; System.out.println(s+c+s+c+';'+'}'); } static String s=";

    public static void main(String[] args) {
        char c = 34;
        System.out.println(s + c + s + c + ';' + '}');
    }
}