import java.util.HashSet;
import java.util.Set;

public class task3 {
    public static void main(String[] args){
        System.out.println(solutions(1,0,-1));
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(checkPerfect(28));
        System.out.println(flipEndChars("Ada"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println(isKaprekar(297));
        System.out.println(longestZero("01100001011000"));
        System.out.println(isPrime(24));
        System.out.println(rightTriangle(145,105,100));
    }
    public static int solutions(double a, double b, double c){
        double d = Math.pow(b,2)-4*a*c;
        if (d>0){return 2;}
        else if (d==0) { return 1;}
        else return 0;
    }
    public static int findZip(String a){
        int cnt = 0;
        if (a.contains("zip")){
            cnt = a.indexOf("zip");
            return a.indexOf("zip", cnt+3);
        }
        return -1;
    }
    public static boolean checkPerfect(int a){
        int sum = 1;
        for (int i = 2; i<=a/2;i++){
            if (a%i == 0){sum+=i;}
        }
        return sum==a;
    }
    public static String flipEndChars(String a){
        if (a.length()<2){return "Incompatible";}
        else if (a.charAt(0)==a.charAt(a.length()-1)){return "Two's a pair.";}
        else { return a.charAt(a.length()-1)+a.substring(1,a.length()-1) + a.charAt(0);}
    }
    public static boolean isValidHexCode(String a){
        if (a.length()==7 && a.charAt(0)=='#'){
            String s = "0123456789ABCDEFabcdef";
            for (int i = 1; i<a.length();i++){
                char b = a.charAt(i);
                if (s.indexOf(b)==-1){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static boolean same(int[] a,int[] b){
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        for (int i : a) {
            first.add(i);
        }
        for (int i : b) {
            second.add(i);
        }
        return first.size()==second.size();

    }
    public static boolean isKaprekar(int a){
        int b = a*a;
        int left;
        int right;

        String str = Integer.toString(b);
        if (str.length()==1){
            return a==b;
        }
        else {
            left = Integer.parseInt(str.substring(0, str.length() / 2));
            right = Integer.parseInt(str.substring(str.length()/2));
        }
        return left+right==a;
    }
    public static String longestZero(String a){
        String b = "";
        for (int i =0; i<a.length();i++){
            b += "0";
        }
        //строка из нулей длиной строки а
        while (!b.isEmpty()){
            if (a.contains(b)){return b;}
            b = b.substring(0,b.length()-1);
        }
        return b;
    }
    public static int isPrime(int a){
        int ans = a;
        while (true){
            boolean flag = true;
            for (int i = 2; i<=ans/2; i++){
                if (ans%i==0){
                    flag = false;
                    break;
                }
            }
            if (flag){return ans;}
            else ans+=1;
        }
    }
    public static boolean rightTriangle(int a, int b, int c){
        int a1 = a;
        int b1 = b;
        int c1 = c;
        int acm;
        if (a1<b1){
            acm=a1;
            a1=b1;
            b1=acm;
        }
        if (a1<c1){
            acm=a1;
            a1=c1;
            c1=acm;
        }
        return a1*a1==b1*b1+c1*c1;
    }
}
