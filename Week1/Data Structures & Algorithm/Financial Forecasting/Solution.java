import java.util.*;

public class Solution{
    public static double predict(double amt,double gr,int time){
        if(time==0){return amt;}
        return predict(amt = amt+((amt/100)*gr),gr,time-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double amt = sc.nextDouble();
        double gr = sc.nextDouble();
        int time = sc.nextInt();

        System.out.println(predict(amt,gr,time));
    }
}