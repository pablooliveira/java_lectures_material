class Palindrom {
  static boolean is_palindrom(char[] input) {
    int i;
    for (i=0; i<input.length/2;i++) {
      if (input[i] != input[input.length-i-1]) 
        break;
    }
    return (i >= input.length/2); 
  }
  public static void main(String args[]) {
    System.out.println(is_palindrom("abcba"));
  }
}
