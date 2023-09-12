package longestcommonsubstring;

/**
 * Problem Statement
 * Given two strings s1 and s2, you have to find the length of the Longest Common Substring (LCS) in both these strings.
 * Let’s say we have two strings, “helloworld” and “yelloword”, there are multiple common substrings, such as “llo”, “ello”, “ellowor”, “low”, and “d”.
 * The longest common substring is “ellowor”, with length 7.
 *
 * Time Complexity = O(3^m+n)
 * Space Complexity = O(m+n)
 */

public class LCSRecursive {
  public static void main(String[] args) {
    LCSRecursive lcs = new LCSRecursive();

    String[] s1 = {
      "educative",
      "bcdcdcd",
      "arefun",
      "yourocks",
      "abc"
    };
    String[] s2 = {
      "education",
      "aacdcdcd",
      "isfun",
      "youawesome",
      "def"
    };

    // You can uncomment the lines below and check how this recursive solution causes a time-out
    // String temp1[] = Arrays.copyOf(s1, s1.length + 1);
    // temp1[s1.length] = "ypzrvyigwdiqrnbglvviozqzruvmwivgvqvrfhqi";
    // s1 = temp1;

    // String temp2[] = Arrays.copyOf(s2, s2.length + 1);
    // temp2[s2.length] = "wdiqrnbglvviozqzruvmwivgvqvrfhqiypzrvyigwdiqrn";
    // s2 = temp2;

    for (int i = 0; i < s1.length; i++) {
      System.out.print(i + 1);
      System.out.println(".\tInput string 1: \"" + s1[i] + "\"");
      System.out.println("\tInput string 2: \"" + s2[i] + "\"");
      System.out.println("\n\tThe Length of Longest Common Substring is: " + lcs.lcsRecursive(s1[i],s2[i],0,0,0));
      System.out.println();
    }
  }

  public int lcsRecursive(String input1,String input2,int i1,int i2,int count){
    //base case
    if(i1>=input1.length() || i2>=input2.length()){
      return count;
    }
    //If both characters match, these could be part of a common substring, meaning we should count this character towards the length of the longest common substring
    if(input1.charAt(i1)==input2.charAt(i2)) {
      count = lcsRecursive(input1, input2, i1+1, i2+1, count+1);
    }
    //we take the maximum among all three of these possibilities.
    count=Math.max(count,Math.max(lcsRecursive(input1, input2, i1+1, i2, 0),lcsRecursive(input1, input2, i1, i2+1, 0)));
    return count;
  }

}
