package longestcommonsubstring;

/**
 * Problem Statement
 * Given two strings s1 and s2, you have to find the length of the Longest Common Substring (LCS) in both these strings.
 * Let’s say we have two strings, “helloworld” and “yelloword”, there are multiple common substrings, such as “llo”, “ello”, “ellowor”, “low”, and “d”.
 * The longest common substring is “ellowor”, with length 7.
 *
 * Time Complexity =
 * Space Complexity = O(m+n)
 */
public class LCSBottomUpSolution {

  private int dp[][];
  int posi=0;
  int posj=0;
  public static void main(String[] args) {
    LCSBottomUpSolution lcs = new LCSBottomUpSolution();

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
      int m=s1[i].length()+1;
      int n=s2[i].length()+1;
      lcs.dp=new int[m][n];
      System.out.print(i + 1);
      System.out.println(".\tInput string 1: \"" + s1[i] + "\"");
      System.out.println("\tInput string 2: \"" + s2[i] + "\"");
      System.out.println("\n\tThe Length of Longest Common Substring is: " + lcs.lcsBottomUpSolution(s1[i],s2[i]));
      lcs.printLCSBottomUpSolution(s1[i],s2[i]);
      System.out.println();
    }
  }

  public int lcsBottomUpSolution(String input1,String input2) {
    int m=input1.length()+1;
    int n=input2.length()+1;
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        dp[i][j]=0;
      }
    }
    int maxLength = 0; // to keep track of longest substring seen
    for(int i=1;i<m;i++){
      for(int j=1;j<n;j++){
        if(input1.charAt(i-1)==input2.charAt(j-1)){
          //Since characters are matching, we add 1 to the diagonal.
          dp[i][j]=1+dp[i-1][j-1];
          if(maxLength<dp[i][j]){
            posi=i;
            posj=j;
            maxLength=dp[i][j];
          }
        }
      }
    }

    return maxLength;
  }

  public void printLCSBottomUpSolution(String input1,String input2) {
    String output="";
    int i=posi;
    int j=posj;
    while(dp[i][j]!=0 && i!=0 && j!=0){
      output+=input1.charAt(i-1);
      i=i-1;
      j=j-1;
    }

    String output1="";
    for(int s=output.length()-1;s>=0;s--){
      output1+=output.charAt(s);
    }
    System.out.println("Result : "+output1);
  }

}
