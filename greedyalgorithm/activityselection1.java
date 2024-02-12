package greedyalgorithm;
import java.util.*;
//for sorted
public class activityselection1 {
    
    public static void main (String args[]){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,8,9,9};
    

    ArrayList<Integer> ans = new ArrayList<>();

    int max = 1;
    int lastend = end[0];
    ans.add(0);

    for(int i=1; i<end.length; i++){
        if(start[i] >= lastend){
            max++;
            ans.add(i);
            lastend = end[i];
        }
    }

    System.out.println("max activities ="+ max);
    for(int i=0; i<ans.size(); i++){
        System.out.print("A"+ans.get(i)+" ");
    }
    System.out.println();
        
    }
}