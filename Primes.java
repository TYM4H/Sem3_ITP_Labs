package lab_no1;

public class Primes {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int j = 3; j <= Math.sqrt(n); j+=2) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        for (int n = 2; n <= 100; n++) {
            if (isPrime(n)) {
                System.out.print(n + " ");
            }
        }
    }
    
}
