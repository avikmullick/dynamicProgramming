package longestcommonsubsequence;

/**
 * Suppose you are given two strings. You need to find the length of the longest common subsequence between these two strings.
 *
 * A subsequence is a string formed by removing some characters from the original string, while maintaining the relative position of the remaining characters. For example, “abd” is a subsequence of “abcd”, where the removed character is “c”.
 *
 * If there is no common subsequence, then return 0.
 *
 * Let’s say you have the following two strings:
 *
 * “cloud”
 * “found”
 * The longest common subsequence between these two strings is “oud”, which has a length of
 * 3
 * 3
 * .
 */
public class LCSubsequnceRecursive {
  public static void main(String args[]){
    String s1="cloud";
    String s2="found";
    LCSubsequnceRecursive lcs=new LCSubsequnceRecursive();
    System.out.println("Result : "+lcs.lcsRecursive(s1,s2,0,0));

    String[] firstStrings = {"qstw", "setter", "abcde", "partner", "freedom","educativeisfun"};
    String[] secondStrings = {"gofvn", "bat", "apple", "park", "redeem","algorithmsarefun"};

    // Let's uncomment this to see the benefit of using dynamic programming with tabulation
    // String temp[] = Arrays.copyOf(firstStrings, firstStrings.length + 1);
    // temp[firstStrings.length] = "sjcneiurutvmpdkapbrcapjru";
    // firstStrings = temp;

    // String temp2[] = Arrays.copyOf(secondStrings, secondStrings.length + 1);
    // temp2[secondStrings.length] = "oidhfwepkxwebyurtunvidqlscmjbg";
    // secondStrings = temp2;

    for (int i = 0; i < firstStrings.length; i++){

      LCSubsequnceRecursive lcs1=new LCSubsequnceRecursive();
      System.out.println(i + 1 + ".\tstr1: " + firstStrings[i] + "\n\tstr2: " + secondStrings[i]
        + "\n\n\tThe length of the longest common subsequence is: " + lcs1.lcsRecursive(firstStrings[i], secondStrings[i],0,0));
      //System.out.println(PrintHyphens.repeat("-", 100));
    }
  }

  public int lcsRecursive(String s1, String s2,int i1,int i2){
    if(i1>=s1.length() || i2>=s2.length()){
      return 0;
    }
    if(s1.charAt(i1)==s2.charAt(i2)){
      return 1+lcsRecursive(s1,s2,i1+1,i2+1);
    }
    return Math.max(lcsRecursive(s1,s2,i1+1,i2),lcsRecursive(s1,s2,i1,i2+1));
  }
}
