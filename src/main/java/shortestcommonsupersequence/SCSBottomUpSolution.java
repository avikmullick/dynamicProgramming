package shortestcommonsupersequence;

/**
 * Let’s assume that we have two strings as follows:
 *
 * str1 = "yabc"
 * str2 = "xabc"
 * There can be multiple strings that have str1 and str2 as subsequences, for example, "xyaabcc" and "xyabbc",
 * but the shortest string that has these input strings as subsequences is "xyabc". Please note that the sequence of alphabets in the string can be altered.
 *
 */
public class SCSBottomUpSolution {
  int dp[][];
  int dir[][];
  public static void main(String args[]){
    String s1="yabc";
    String s2="xabc";
    int m=s1.length();
    int n=s2.length();
    SCSBottomUpSolution scs=new SCSBottomUpSolution();
    scs.dp=new int[s1.length()+1][s2.length()+1];
    scs.dir=new int[s1.length()+1][s2.length()+1];
    System.out.println("Result: "+scs.lcsDP(s1,s2));
    scs.printscs(s1,s2,s1.length(),s2.length());


    String[] input1Strings = {"abcd", "educativeisfun", "cpprocks", "abcf", "dynamic"};
    String[] input2Strings = {"efgh", "algorithmsarefun", "cppisfun", "bdcf", "programming"};

    // you can uncomment the lines below and check how this recursive solution causes a time-out

    // String newArr[] = Arrays.copyOf(input1Strings, input1Strings.length + 1);
    // newArr[input1Strings.length] = "iloveprogrammingbutprogrammingdoesnotloveme";
    // input1Strings = newArr;
    // newArr = Arrays.copyOf(input2Strings, input2Strings.length + 1);
    // newArr[input2Strings.length] = "computersarefastprogrammerskeepthemslow";
    // input2Strings = newArr;

    for (int i = 0; i < input1Strings.length; i++) {
      System.out.println(i + 1);
      System.out.println("\tString 1: " + input1Strings[i]);
      System.out.println("\tString 1: " + input2Strings[i]);

      SCSBottomUpSolution scs1=new SCSBottomUpSolution();
      scs1.dp=new int[input1Strings[i].length()+1][input2Strings[i].length()+1];
      scs1.dir=new int[input1Strings[i].length()+1][input2Strings[i].length()+1];
      System.out.println("Result: "+scs1.lcsDP(input1Strings[i],input2Strings[i]));
      scs1.printscs(input1Strings[i],input2Strings[i],input1Strings[i].length(),input2Strings[i].length());
      System.out.println();
    }
  }

  public int lcsDP(String s1,String s2){
    int m=s1.length()+1;
    int n=s2.length()+1;
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        dp[i][j]=0;
      }
    }


    for(int i=1;i<m;i++) {
      for (int j = 1; j < n; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          dir[i][j]=1;
        } else if (dp[i-1][j] > dp[i][j]) {
          dp[i][j] = dp[i-1][j];
          if(dp[i][j]!=0) {
            dir[i][j] = 2;
          } else{
            dir[i][j] = 4;
          }
        } else {
          dp[i][j] = dp[i][j-1];
          if(dp[i][j]!=0) {
            dir[i][j] = 3;
          }else{
            dir[i][j] = 4;
          }
        }

      }
    }


    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        System.out.print(dp[i][j]+"  ");
      }
      System.out.println();
    }

    System.out.println("_____LCS_____");

    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        System.out.print(dir[i][j]+"  ");
      }
      System.out.println();
    }
      return (m+n-2)-dp[m-1][n-1];
  }

  public void printscs(String s1,String s2,int m,int n){
    if(m==0 || n==0){
      return;
    }
    if(dir[m][n]==4){
      printscs(s1,s2,m-1,n-1);
      System.out.print(s1.charAt(m-1)+""+s2.charAt(n-1));
    }else if(dir[m][n]==1){
      printscs(s1,s2,m-1,n-1);
      System.out.print(s1.charAt(m-1));
    } else if(dir[m][n]==2){
      printscs(s1,s2,m-1,n);
      //System.out.print("ABC"+s1.charAt(m-2)+""+s2.charAt(n-1));
    } else if(dir[m][n]==3){
      printscs(s1,s2,m,n-1);
      //System.out.print("DEF"+s1.charAt(m-1)+""+s2.charAt(n-2));
    }
  }
}
