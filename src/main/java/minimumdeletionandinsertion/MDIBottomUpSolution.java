package minimumdeletionandinsertion;

/**
 *
 * Given two strings, str1 and str2, find the minimum number of deletions and insertions required to transform str1 into str2.
 *
 * Note: This problem has a direct application in the autocorrect feature. It is also used in bioinformatics to quantify the similarity between two DNA sequences.
 *
 * For example, if we want to transform str1 “pqr” into str2 “tqr”, we need to delete “p” and insert “t” in str1. Therefore, the minimum number of deletions and insertions required are:
 *
 * Deletions:
 * 1
 * 1
 * Insertions:
 * 1
 * 1
 */
public class MDIBottomUpSolution {

  public static void main(String args[]){
    String s1="pqr";
    String s2="tqr";
    MDIBottomUpSolution mdi=new MDIBottomUpSolution();
    System.out.println("Result"+ (s1.length()+s2.length()-(2*mdi.mdiDP(s1,s2))));
  }

  /**
   * Basic Approach
   *
   * s1->s2
   * abcd->aec
   *
   * Insertion-> e
   * Deletion-> bd
   * Length of m s1 -> 4
   * Length of n s2 -> 3
   *
   * Insertion= 4-2 ->2
   * Deletion= 3-2 ->1
   *
   * Deletion= m-lcs(s1,s2)
   * Insertion- n-lcs(s1,s2)
   * @param s1
   * @param s2
   * @return
   */
  public int mdiDP(String s1, String s2){
    int m=s1.length()+1;
    int n=s2.length()+1;
    int dp[][]=new int[m][n];
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        dp[i][j]=0;
      }
    }

    for(int i=1;i<m;i++){
      for(int j=1;j<n;j++){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
          dp[i][j]=1+dp[i-1][j-1];
        } else if(dp[i-1][j]>dp[i][j-1]){
          dp[i][j]=dp[i-1][j];
        } else{
          dp[i][j]=dp[i][j-1];
        }
      }
    }
    return dp[m-1][n-1];
  }
}
