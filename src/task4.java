import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class task4 {
    public static void main(String[] args){
        bessie(10,7, "hello my name is Bessie and this is my essay");
        System.out.println(splitBrackets("(((())))()()"));
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("getColor"));
        System.out.println(overTime(13.25, 15, 30, 1.5));
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(bugger(999));
        System.out.println(toStarShorthand("77777ceff"));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(trouble(123444,12344455));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
    }
    public static void bessie(int n, int k, String a){
        String str="";
        int len = 0;
        String[] words = a.split(" ");
        for (int i = 0; i<words.length;i++) {
            if (len + words[i].length() > k) {
                System.out.println(str);
                str = "";
                len = 0;
            }
            str += words[i] + " ";
            len+=words[i].length();
        }
        System.out.println(str);
    }

    public static ArrayList<String> splitBrackets(String a) {
        ArrayList<String> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        String element = "";
        for (int i = 0; i<a.length();i++){
            if (a.charAt(i) == '('){
                element += '(';
                left+=1;
            }
            else if (a.charAt(i) == ')'){
                element += ')';
                right+=1;
            }
            if (left == right){
                ans.add(element);
                element = "";
                left = right = 0;
            }
        }
        return ans;
    }

    public static String toCamelCase(String a){
        String[] words = a.split("_");
        String ans = words[0];

        for (int i = 1; i< words.length;i++){

            String elm = words[i];
            int asci = elm.charAt(0);
            ans += (char) (asci-32) + elm.substring(1);
        }
        return ans;
    }
    public static String toSnakeCase(String a){
        String ans = "";
        for (int i = 0; i < a.length(); i++){
            int chr = a.charAt(i);
            if( chr <=122 && chr >=97){
                ans += (char) chr;
            }
            else {
                ans += "_" + (char) (chr+32);
            }
        }
        return ans;
    }
    public static String overTime(double start, double end, double pay, double mult){
        double sum;
        DecimalFormat dF = new DecimalFormat( "#.##" );
        if (end <= 17){
            sum = pay*(end-start);
        }
        else {
            if (start >= 17){
                sum = pay*mult*(end-start);
            }
            else {
                sum = pay*(17-start) + mult*pay*(end-17);
            }
        }
        return ("$" + String.format("%.2f", sum)).replace(',','.');
    }
    public static String BMI(String weight, String height){
        double w = Double.parseDouble(weight.substring(0,weight.indexOf(" ")));
        double h = Double.parseDouble(height.substring(0,weight.indexOf(" ")));
        if (weight.contains("pound")){
            w = w * 0.45;
        }
        if (height.contains("inch")){
            h = h * 0.0254;
        }
        double imt = w/(h*h);
        DecimalFormat dF = new DecimalFormat( "#.#" );
        if (imt < 18.5){return dF.format(imt) + " Underweight";}
        else if (imt >= 18.5 && imt <= 24.9){return dF.format(imt) + " Normal weight";}
        else {return dF.format(imt) + " Overweight";}
    }
    public static int bugger(int a){
        int ans = 0;
        while (true){
            int second = 1;
            int cnt = 0;
            while (a != 0){
                second *= a % 10;
                cnt++;
                a/=10;
            }
            if (cnt == 1){return ans;}
            else {
                a = second;
                ans++;
            }
        }
    }
//    public static String toStarShorthand(String a){
//        String ans = "";
//        if (a.length()==0) return "";
//        while (a != ""){
//            char chr = a.charAt(0);
//            if (a.length()==1){
//                ans += chr;
//            }
//            else {
//                int cnt = 0;
//                for (int i = 0; i < a.length(); i++) {
//                    if (a.charAt(i) == chr) cnt++;
//                }
//                if (cnt > 1) {
//                    ans += chr + "*" + cnt;
//                } else {
//                    ans += chr;
//                }
//            }
//            a = a.replaceAll(String.valueOf(chr), "");
//        }
//        return ans;
//    }
    public static String toStarShorthand(String a){
        String ans = "";
        ArrayList<Integer> chars = new ArrayList<>();
        for (int i = 0; i< a.length(); i++){
            if (!chars.contains((int) a.charAt(i))){
                chars.add((int) a.charAt(i));
            }
        }
        for (int i = 0; i < chars.size(); i++){
            int cnt = 0;
            for (int j = 0; j < a.length(); j++) {
                if ((int)a.charAt(j) == chars.get(i)) cnt++;
            }
            int currchar = chars.get(i);
            if (cnt > 1) {
                ans += (char) currchar + "*" + cnt;
            }
            else ans += (char) currchar;
        }
        return ans;
    }
    public static boolean doesRhyme(String a, String b){
        String glasn = "aeiouyAEIOUY";
        String lastA = a.split(" ")[a.split(" ").length-1];
        String lastB = b.split(" ")[b.split(" ").length-1];
        ArrayList <Character> chars1 = new ArrayList<>();
        ArrayList <Character> chars2 = new ArrayList<>();
        for (int i = 0; i < lastA.length(); i++){
            if (glasn.indexOf(lastA.charAt(i))!=-1){
                chars1.add(lastA.charAt(i));
            }
        }
        for (int i = 0; i < lastB.length(); i++){
            if (glasn.indexOf(lastB.charAt(i))!=-1){
                chars2.add(lastB.charAt(i));
            }
        }
        boolean flag = true;
        for (int i = 0; i<chars1.size();i++){
            if (chars1.get(i)!=chars2.get(i) && (int)chars1.get(i)-32!=(int)chars2.get(i) && (int)chars1.get(i)!=(int)chars2.get(i)-32){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static boolean trouble(int a, int b){
        Set<Integer> allnums = new HashSet<>();
        String first = Integer.toString(a);
        String sec = Integer.toString(b);
        for (int i = 0; i< first.length(); i++){
            allnums.add(Integer.parseInt(String.valueOf(first.charAt(i))));
        }
        for (int i = 0; i< sec.length(); i++){
            allnums.add(Integer.parseInt(String.valueOf(sec.charAt(i))));
        }
        ArrayList<Integer> allnums2 = new ArrayList<>(allnums);

        for (int i = 0; i < allnums2.size(); i++){
            char a1=first.charAt(0);
            char a2=first.charAt(1);
            boolean flag1 = false;
            boolean flag2 = false;

            int curr1 = allnums2.get(i);
            char curr = (char) (curr1+'0');

            for (int j = 2; j < first.length(); j++){
                if (a1 == a2 && a2 == first.charAt(j) && a1 == curr){
                    flag1 = true;
                    break;
                }
                a1 = a2;
                a2 = first.charAt(j);
            }
            if (flag1) {
                a1=sec.charAt(0);
                a2=sec.charAt(1);
                for (int j = 2; j < sec.length(); j++) {
                    if (a1 == a2 && a2 == sec.charAt(j) && a1 == curr) {
                        flag2 = true;
                        break;
                    }
                    a1 = a2;
                    a2 = sec.charAt(j);
                }
                return flag2;
            }
        }
        return false;
    }
    public static int countUniqueBooks(String a, char b){
        Set<Integer> uniqueBooks = new HashSet<>();
        while (a.indexOf(b,a.indexOf(b)+1)!=-1){

            if (a.indexOf(b, a.indexOf(b)+1)-a.indexOf(b)>1) {

                for (int i = a.indexOf(b)+1; i < a.indexOf(b, a.indexOf(b)+1); i++) {

                    uniqueBooks.add((int) a.charAt(i));
                }
            }
            a = a.substring(a.indexOf(b, a.indexOf(b) + 1) + 1);
        }
        return uniqueBooks.size();
    }
}
