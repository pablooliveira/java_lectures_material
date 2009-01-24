import java.lang.Thread;

class MyThread2 extends Thread {
  static final int N = 1000;
  static int sum = 0;

  static void increment() {
      sum++;
  }

  public void run() {
    for(int i=0;i<10;i++) {
      increment();
      try{
      Thread.sleep(i);
      }catch(Exception e) {}
    }
  }

  public static void main(String args[]) throws Exception{
    Thread [] threads = new Thread[N];
    for (int i=0;i<N;i++)
      threads[i] = new MyThread2();
    for (int i=0;i<N;i++)
      threads[i].start();
    for (int i=0;i<N;i++)
      threads[i].join();

    System.out.println("Sum = " + sum);

  }

}

