package Practicum_20_12_22;

public class program20_12 {
    
  public static void main(String[] args) {

    String s1 = "5127381";
    String s2 = "523891";

    // System.out.println(LEN(s1, s2));
    System.out.println(LEN3(0, 0));
  }

  static int LEN(String a, String b) {
    if (a.length() == 0 || b.length() == 0)
      return 0;
    else if (a.charAt(0) == b.charAt(0))
      return LEN(a.substring(1), b.substring(1)) + 1;
    else
      return Math.max(LEN(a, b.substring(1)), LEN(a.substring(1), b));
  }

  static int LEN2(String a, String b, int i, int j) {
    if (i >= a.length() || j >= b.length())
      return 0;
    else if (a.charAt(i) == b.charAt(j))
      return LEN2(a, b, i + 1, j + 1) + 1;
    else
      return Math.max(LEN2(a, b, i, j + 1), LEN2(a, b, i + 1, j));
  }

  static char[] a = { '5', '1', '2', '7', '3', '8', '1' };
  static char[] b = { '5', '2', '3', '8', '9', '1' };

  static int LEN3(int i, int j) {
    if (i >= a.length || j >= b.length)
      return 0;
    else if (a[i] == b[j])
      return LEN3(i + 1, j + 1) + 1;
    else
      return Math.max(LEN3(i, j + 1), LEN3(i + 1, j));
  }

}
