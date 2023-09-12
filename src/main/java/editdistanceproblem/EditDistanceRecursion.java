package editdistanceproblem;

/**
 *
 * Given two strings, str1 and str2, find the minimum edit distance required to convert str1 into str2.
 * Minimum edit distance is the minimum number of insertions, deletions, or substitutions required to transform str1 into str2.
 */
public class EditDistanceRecursion {

  public static void main(String args[]){
    String s1="the";
    String s2="teh";
    EditDistanceRecursion editDistanceRecursion=new EditDistanceRecursion();
    System.out.println("Result "+editDistanceRecursion.editDistanceRecursion(s1,s2,s1.length(),s2.length()));
  }

  public int editDistanceRecursion(String s1,String s2,int i1,int i2){
    // If first string is empty, the only option is to
    // insert all characters of second string into first
    if(i1==0){
      return i2;
    }
    // If second string is empty, the only option is to
    // remove all characters of first string
    if(i2==0){
      return i1;
    }
    // If last characters of two strings are same, nothing
    // much to do. Ignore last characters and get count for
    // remaining strings.
    if(s1.charAt(i1-1)==s2.charAt(i2-1)){
      return editDistanceRecursion(s1,s2,i1-1,i2-1);
    }

    // If last characters are not same, consider all three
    // operations on last character of first string, recursively
    // compute minimum cost for all three operations and take
    // minimum of three values.
    return 1+Math.min(editDistanceRecursion(s1,s2,i1,i2-1),Math.min(editDistanceRecursion(s1,s2,i1-1,i2),editDistanceRecursion(s1,s2,i1-1,i2-1)));
  }
}
