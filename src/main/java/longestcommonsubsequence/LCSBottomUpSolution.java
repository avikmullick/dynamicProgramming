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
public class LCSBottomUpSolution {

  int dp[][];
  int dir[][];
  public static void main(String args[]){
    String s1="cloud";
    String s2="found";
    LCSBottomUpSolution lcs=new LCSBottomUpSolution();
    lcs.dp=new int[s1.length()+1][s2.length()+1];
    lcs.dir=new int[s1.length()+1][s2.length()+1];
    System.out.println("Result : "+lcs.lcsDP(s1,s2));
    lcs.printlcs(s1,s2,s1.length(),s2.length());

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

      LCSBottomUpSolution lcs1=new LCSBottomUpSolution();
      lcs1.dp=new int[firstStrings[i].length()+1][secondStrings[i].length()+1];
      lcs1.dir=new int[firstStrings[i].length()+1][secondStrings[i].length()+1];
      System.out.println(i + 1 + ".\tstr1: " + firstStrings[i] + "\n\tstr2: " + secondStrings[i]
        + "\n\n\tThe length of the longest common subsequence is: " + lcs1.lcsDP(firstStrings[i], secondStrings[i]));
      lcs1.printlcs(firstStrings[i],secondStrings[i],firstStrings[i].length(),secondStrings[i].length());
      //System.out.println(PrintHyphens.repeat("-", 100));
    }
  }


  public int lcsDP(String s1,String s2){
    int m=s1.length()+1;
    int n=s2.length()+1;
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        dp[i][j]=0;
        dir[i][j]=0;
      }
    }

    for(int i=1;i<m;i++){
      for(int j=1;j<n;j++){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
          dp[i][j]=1+dp[i-1][j-1];
          dir[i][j]=1;
        } else if(dp[i-1][j]>dp[i][j-1]) {
          dp[i][j]=dp[i-1][j];
          dir[i][j]=2;
        } else {
          dp[i][j]=dp[i][j-1];
          dir[i][j]=3;
        }
        }
    }

    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        System.out.print(dp[i][j]+"  ");
      }
      System.out.println();
    }

    return dp[m-1][n-1];
  }

  public void printlcs(String s1,String s2,int m,int n){

    if(m==0 || n==0){
      return;
    }
    if(dir[m][n]==1){
      printlcs(s1,s2,m-1,n-1);
      System.out.print(s1.charAt(m-1));
    } else if(dir[m][n]==2){
      printlcs(s1,s2,m-1,n);

    } else{
      printlcs(s1,s2,m,n-1);
    }
  }

}
