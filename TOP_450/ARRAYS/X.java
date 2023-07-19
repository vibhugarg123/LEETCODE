public class X {
    private int fib(int[] f, int n) {

        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public int sum(String s) {
        int[] f = new int[26 + 2];
        fib(f, 26);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int value = c - 'A';
            sum += f[value];
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "MAN";
        System.out.println(new X().sum(s));
    }
}