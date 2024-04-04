import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class jobSequencing {
  public static void main(String[] args) {
    Integer jobsInfo[][]={{0,4,20},{1,1,10},{2,1,40},{3,1,30}};
    Arrays.sort(jobsInfo,Comparator.comparingDouble(o->o[2]));
    int maxProfit=0,time=0;
    ArrayList<Integer>ans=new ArrayList<>(); 
    for(int i=jobsInfo.length-1;i>=0;i--){
      if(jobsInfo[i][1]>time){
        maxProfit+=jobsInfo[i][2];
        ans.add(jobsInfo[i][0]);
        time++;
      }
    }  
    System.out.println("max profit = "+maxProfit);
    for(int i=0;i<ans.size();i++){
      System.out.print(ans.get(i)+1+" ");
    }
  
  
  }
  
}
