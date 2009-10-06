class Palindrom {
  static boolean is_palindrom(String input) {
    ...
  }
  public static void main(String args[]) {
      if (args.length != 1) {
	  System.err.println("usage: java Palindrom <word>");
      } else {
	  System.out.println(is_palindrom(args[0]));
      }
  }
}
