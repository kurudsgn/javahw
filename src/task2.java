import java.util.Arrays;
import java.util.SplittableRandom;

public class task2 {
    public static void main(String[]args){
        System.out.println(repeat("mice", 5));
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(isAvgWhole(new int[]{1, 2, 3, 4}));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, -2, 3})));
        System.out.println(getDecimalPlaces("400.200"));
        System.out.println(Fibbonacci(7));
        System.out.println(isValid("555 5"));
        System.out.println(isStrangePair("orator","ratio"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("automation","auto-"));
        System.out.println(boxSeq(3));
    }
    public static String repeat(String a, int b){
        String s = "";
        for (int i = 0; i<a.length();i++){
            s += a.charAt(i)*b;
        }
        return s;
    }
    public static int differenceMaxMin(int[]arg){
        int max = arg[0];
        int min = arg[0];
        for (int i = 1;i<arg.length;i++){
            if (arg[i]<min){min = arg[i];}
            else if (arg[i]>max) {max = arg[i];}
        }
        return max-min;
    }
    public static boolean isAvgWhole(int[]arg){
        double s = 0;
        for (int i = 0; i<arg.length; i++){
            s+=arg[i];
        }
        return s / arg.length == Math.round(s / arg.length);
    }
    public static int[] cumulativeSum(int[]arg){
        int s=0;
        int[] ans = new int[arg.length];
        for (int i = 0; i < arg.length; i++){
            ans[i] = arg[i]+s;
            s+=arg[i];
        }
        return ans;
    }
    public static int getDecimalPlaces(String s){
        if (s.indexOf('.')!=-1) {
            return s.length()- s.indexOf('.')-1;
        }
        else return 0;
    }
    public static int Fibbonacci(int a){
        int a1 = 0;
        int a2 = 1;
        int a3 = 0;
        for (int i =0; i<a;i++){
            a3 = a2+a1;
            a1 = a2;
            a2 = a3;
        }
        return a3;
    }
    public static boolean isValid(String a){
        String s = "1234567890";
        if (a.length()<=5) {
            for (int i = 0; i < a.length(); i++) {
                char b = a.charAt(i);
                if (s.indexOf(b)==-1){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static boolean isStrangePair(String a, String b){
        if (a.equals("")&&b.equals("")){return true;}
        if (a.equals("")||b.equals("")){return false;}
        return a.charAt(0)==b.charAt(b.length()-1) && b.charAt(0)==a.charAt(a.length()-1);
    }
    public static boolean isPrefix(String a, String b){
        for (int i = 0; i<b.length()-1;i++){
            if (a.charAt(i)!=b.charAt(i)) {return false;}
        }
        return true;
    }
    public static boolean isSuffix(String a, String b){
        for (int i = 0; i<b.length()-1;i++){
            if (a.charAt(a.length()-i-1)!=b.charAt(b.length()-i-1)) {return false;}
        }
        return true;
    }
    public static int boxSeq(double a){
        if (a==0) {return 0;}
        if (a/2 == Math.round(a/2)) {return (int) a;}
        else return (int) a+2;
    }
}
