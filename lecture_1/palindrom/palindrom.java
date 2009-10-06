class Palindrom {
  static boolean is_palindrom(String input) {
    int i;
    for (i=0; i<input.length()/2;i++) {
	    if (input.charAt(i) != input.charAt(input.length()-i-1)) 
        return false
    }
    return true; 
  }
  public static void main(String args[]) {
      if (args.length != 1) {
	  System.err.println("usage: java Palindrom <word>");
      } else {
	  System.out.println(is_palindrom(args[0]));
      }
  }
}
