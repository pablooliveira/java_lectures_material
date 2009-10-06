import java.io.*;
import java.util.Random;

class NumberGame {
    public static int getNumber() {
	BufferedReader reader = new BufferedReader(
			       new InputStreamReader(System.in));
	while(true) {
	    System.out.println("What is your guess ?");
	    try {
		String input = reader.readLine();
		int number = Integer.parseInt(input);
		return number;
	    } catch (NumberFormatException e) {
		System.out.println("That is not a number !");
	    } catch (IOException e) {
		System.out.println("An IO error occured");
	    }
	}
    }
    public static void main(String args[]) {
	Random rgn = new Random();
	int secretNumber = rgn.nextInt(100) + 1;
	while (true) {
	    int guess = NumberGame.getNumber();
	    if (guess > secretNumber) {
		System.out.println("Too high!");
	    } 
	    else if (guess < secretNumber) {
		System.out.println("Too low!");
	    }
	    else {
		System.out.println("You win!");
		break;
	    }
	    
	}
    }
}