package editdistanceproblem;

import java.util.ArrayList;

public class EditDistanceDP {

  public static void main(String args[]){
    String s1="the";
    String s2="teh";
    EditDistanceDP editDistanceDP=new EditDistanceDP();
    System.out.println("Result "+editDistanceDP.editDistanceDP(s1,s2));

    ArrayList<String> str1List = new ArrayList<String>(){{add("sunday"); add("sam"); add("110011010110001"); add("cat"); add("ball");}};
    ArrayList <String> str2List = new ArrayList<String>(){{add("saturday"); add("samson"); add("1100101111110010"); add("cut"); add("baller");}};

    // You can uncomment the lines below and check how this recursive solution causes a time-out

    // str1List.add("iaetnxijfofxwnzfitssulvepiengehcaibfaorvraugndnurjfgixjljuibiaetnxijfofxwnzfitssulvepiengehcaibfaorvraugndnurjfgixjljuib");
    // str2List.add("raetnsijfoyxwnzcitssolveppengeqcaibnaorveaugnvnurjmgixjljuibabcdraetnsijfoyxwnzcitssolveppengeqcaibnaorveaugnvnurjmgixjljuib");

    for(int i = 0; i < str1List.size(); i++)
    {
      System.out.println(i+1 + ".\tstr1: " + str1List.get(i));
      System.out.println("\tstr2: " + str2List.get(i));
      System.out.println("\n\tMinimum Edit Distance: " + editDistanceDP.editDistanceDP(str1List.get(i), str2List.get(i)));
      System.out.println();
    }
  }

  public int editDistanceDP(String s1, String s2){
    int dp[][]=new int[s1.length()+1][s2.length()+1];

    for(int i=0;i<s1.length()+1;i++){
      dp[i][0]=i;
    }
    for(int j=0;j<s2.length()+1;j++){
      dp[0][j]=j;
    }
    for(int i=1;i<s1.length()+1;i++){
      for(int j=1;j<s2.length()+1;j++){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
          dp[i][j]=dp[i-1][j-1];
        } else{
          dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

}
