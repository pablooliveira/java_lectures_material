public class Eratosthenes {
  private boolean [] numbers;
  private int [] primes;
  private int last_prime;
  private int N;

  Eratosthenes(int N) {
    this.N = N;
    numbers = new boolean[N];
    primes = new int[N];

    for (int k=0;k<N;k++) {
      numbers[k] = true;
    }

    last_prime = 0;
    computePrimes();
  }

  void computePrimes() {
    for (int k=2;k<N;k++) {
      if (numbers[k] == false) continue;
      // put k in primes
      primes[last_prime++] = k;

      // if k is larger than sqrt(N) then all its multiples smaller than N
      // have already been marked in previous iterations.
      if (k>Math.sqrt(N)) continue;

      // mark all multiples as false in numbers
      int m = 2;
      while(m*k<N) {
        numbers[m*k] = false;
        m++;
      }
    }
  }

  void printPrimes() {
    for (int i=0; i<last_prime; i++) {
      System.out.println(primes[i]);
    }
  }

  public static void main(String args[]) {
    Eratosthenes e = new Eratosthenes(100);
    e.printPrimes();
  }
}
