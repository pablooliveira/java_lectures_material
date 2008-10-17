public class Numbers {
  static int N = 100;
  public static boolean isPrime(long n) {
    for (int i=2; i<=Math.sqrt(n); i++) {
      if (n%i == 0) return false;
    }
    return true;
  }

  public static void main(String args[]) {
    for (long i=0; i<N; i++){
      /* For exercice 1 */
        System.out.println(i);
      /* For exercice 2 */
        if (isPrime(i)) System.out.println(i);
    }
  }
}
