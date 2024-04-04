
import java.util.*;


public class maxActivities{
    public static void main(String[] args) {
        int st[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        int maxact=0;
        ArrayList<Integer> ans=new ArrayList<>();
        int activities[][]=new int[st.length][3];
        for(int i=0;i<st.length;i++){
            activities[i][0]=i;
            activities[i][1]=st[i];
            activities[i][2]=end[i];
        }
        Arrays.sort(activities,Comparator.comparingDouble(c->c[2]));

        //Ist act
        maxact++;
        ans.add(activities[0][0]);
        int lastEnd=activities[0][2];
        for(int i=0;i<st.length;i++){
            if(activities[i][1]>=lastEnd){
                //chose activity
                maxact++;
                ans.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }

        System.out.println("max activities"+maxact);
        System.out.println(ans);
    }
}