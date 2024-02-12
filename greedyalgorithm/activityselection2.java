package greedyalgorithm;
import java.util.*;
//for unsorted
public class activityselection2 {
    
    public static void main(String args[]){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,8,9,9};
    
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
            activities[i][0] = i;
             activities[i][1] = start[i];
              activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

    ArrayList<Integer> ans = new ArrayList<>();

    int max = 1;
    int lastend = activities[0][2];
    ans.add(activities[0][0]);

    for(int i=1; i<end.length; i++){
        if(activities[i][1] >= lastend){
            max++;
            ans.add(activities[i][0]);
            lastend = activities[i][2];
        }
    }

    System.out.println("max activities="+ max);
    for(int i=0; i<ans.size(); i++){
        System.out.print("A"+ans.get(i)+" ");
    }
    System.out.println();
    }
}
