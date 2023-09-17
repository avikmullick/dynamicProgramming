package interleavingstrings;

import java.util.ArrayList;
import java.util.Arrays;

public class InterleavingStrings {
  public static void main(String args[]){

    InterleavingStrings is=new InterleavingStrings();
    ArrayList< String > s1 = new ArrayList < String > (
      Arrays.asList("abd", "abc", "abcdef", "", "xyz", "abcdefghijklmnopqrstuvwxyz"));

    ArrayList < String > s2 = new ArrayList < String > (
      Arrays.asList("cef", "def", "mnop", "", "abc", "abcdefghijklmnopqrstuvwxyz"));

    ArrayList < String > s3 = new ArrayList < String > (
      Arrays.asList("adcbef", "abcccf", "mnaobcdepf", "", "abc", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));

    // You can uncomment the three lines below and check how this recursive solution causes a time-out
    // s1.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    // s2.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    // s3.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    for (int i = 0; i < s1.size(); i++) {
      System.out.println("Test Case # " + (i + 1));
      System.out.println("The strings are:");
      System.out.println("s1 = '" + s1.get(i) + "'");
      System.out.println("s2 = '" + s2.get(i) + "'");
      System.out.println("s3 = '" + s3.get(i) + "'");

      String res = "";
      if (is.isInterleave(s1.get(i), s2.get(i), s3.get(i)))
        res = "True";
      else
        res = "False";

      System.out.println("Is s3 a product of interleaving s1 and s2?\n" + res);

      res = "";
      if (is.isInterleaveDP(s1.get(i), s2.get(i), s3.get(i)))
        res = "True";
      else
        res = "False";

      System.out.println("Is s3 a product of interleaving s1 and s2 DP?\n" + res);


      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    return isInterleave(s1,s2,s3,0,0,0);
  }

  public boolean isInterleave(String s1, String s2, String s3,int i1,int i2,int i3) {
    //Base Case
    if(i3>=s3.length() && i1>=s1.length() && i2>=s2.length()){
      return true;
    }else if(i3>=s3.length()){
      return false;
    }
    boolean d1=false;
    boolean d2=false;

    if(i1<s1.length() && s1.charAt(i1)==s3.charAt(i3)){
      d1= isInterleave(s1,s2,s3,i1+1,i2,i3+1);
    }
    if(i2<s2.length() && s2.charAt(i2)==s3.charAt(i3)){
      d2= isInterleave(s1,s2,s3,i1,i2+1,i3+1);
    }
   if(i1<s1.length() && i2<s2.length() && s2.charAt(i2)!=s3.charAt(i3) && s1.charAt(i1)!=s3.charAt(i3)){
      return false;
    } else{
      return d1 || d2;
    }
  }

  public boolean isInterleaveDP(String s1, String s2, String s3) {
    if(s1.length()+s2.length() != s3.length()){
      return false;
    }
    boolean dp[][]=new boolean[s1.length()+1][s2.length()+1];
    for(int i=0;i<s1.length()+1;i++){
      for(int j=0;j<s2.length()+1;j++){
        dp[i][j]=false;
      }
    }

    //Base Case
    dp[0][0]=true;
    for(int i=1;i<s1.length()+1;i++){
      if(s1.charAt(i-1)==s3.charAt(i-1)){
        dp[i][0]=dp[i-1][0] && true;
      }
    }
    for(int j=1;j<s2.length()+1;j++){
      if(s2.charAt(j-1)==s3.charAt(j-1)){
        dp[0][j]=dp[0][j-1] && true;
      }
    }

    for(int i=1;i<s1.length()+1;i++){
      for(int j=1;j<s2.length()+1;j++){
        boolean d1=false;
        boolean d2=false;
        if(i-1<s1.length() && s1.charAt(i-1)==s3.charAt(i+j-1)){
          d1=dp[i-1][j];
        }
        if(j-1<s2.length() && s2.charAt(j-1)==s3.charAt(i+j-1)){
          d2=dp[i][j-1];
        }

        if(i-1<s1.length() && j-1<s2.length() && s2.charAt(j-1)!=s3.charAt(i+j-1) && s1.charAt(i-1)!=s3.charAt(i+j-1)){
          dp[i][j]= false;
        } else{
          dp[i][j]=d1 || d2;
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

}
