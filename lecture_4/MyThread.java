import java.lang.Thread;

class MyThread extends Thread {
  int delay;

  MyThread(int delay) {
    this.delay = delay;
  }

  public void run() {
    while(true) {
      System.out.println("Thread with delay " + delay);
      try {
        Thread.sleep(1000*delay); 
      } catch(InterruptedException ie) {}
    }
  }

  public static void main(String args[]) {
    (new MyThread(1)).start();
    (new MyThread(2)).start();
    (new MyThread(3)).start();
  }

}

