package e04_prime_palindrome;

public class Main {

    private boolean[] primes;

    public Main(int n) {
        primes = new boolean[n + 1];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        primes[0] = false;
        primes[1] = false;

        int max = (int) Math.sqrt(n);
        for (int p = 2; p <= max; p++) {
            if (primes[p]) {
                for (int i = p; i <= n; i += p) {
                    primes[i] = false;
                }
            }
        }
        return;
    }


    public boolean isPrime(int n) {
        return primes[n];
    }


    public static void main(String[] args) {
        Main main = new Main(1000);
        for (int i = 1000; i > 0; i--) {
            String str = new Integer(i).toString();
            if (str.charAt(0) == str.charAt(str.length() - 1)) {
                if (main.isPrime(i)) {
                    System.out.println(str);
                    System.exit(0);
                }
            }
        }
    }
}
