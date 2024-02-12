package greedyalgorithm;
import java.util.*;

public class minabsolutedif {
    public static void main(String[] args) {
        int a[]={4,1,8,7};
        int b[] = {2,3,6,5};

        int mindif =0;

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0; i<a.length; i++){
            mindif += Math.abs(a[i] - b[i]);
        }
        System.out.println("Minimum difference:"+mindif);
    }
}
