package testeMain;

class Two {
    public static void main(String[] args) {
        int x = 0;

        System.out.println("x = " + x);
        x = fxn(x);
        System.out.println("x = " + x);
    }

    static int fxn(int y) {
        y = 5;
        return y;
    }
}