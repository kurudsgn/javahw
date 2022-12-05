import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class task5 {
    public static void main(String[] args){
        System.out.println(encrypt("Hello"));
        System.out.println(decrypt(new int[]{72, 29, 7, 0, 3}));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canComplete("butll", "beautiful"));
        System.out.println(sumDigProd(new int[]{16,28}));
        System.out.println(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"}));
        System.out.println(validateCard("1234567890123452"));
        System.out.println(numToEng(126));
        System.out.println(getSha256Hash("password123"));
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(hexLattice(7));
    }

    public static ArrayList<Integer> encrypt(String a){
        ArrayList<Integer> ans = new ArrayList<>();
        int x = a.charAt(0);
        ans.add(x);
        for (int i = 1; i < a.length(); i++){
            ans.add((int)a.charAt(i)-x);
            x = a.charAt(i);
        }
        return ans;
    }
    public static String decrypt(int[] a){
        String ans = "";
        ans += (char) a[0];
        int pre = a[0];
        for (int i = 1; i < a.length; i++){
            pre +=a[i];
            ans += (char) pre;
        }
        return ans;
    }
    public static boolean canMove(String type, String start, String end){
        int way1 = Math.abs((int) start.charAt(0) - (int) end.charAt(0));
        int way2 = Math.abs((int) start.charAt(1) - (int) end.charAt(1));
        if (type.equals("Pawn")){
            int wayPawn = start.charAt(1) - end.charAt(1);
            if (start.charAt(1)=='2' || start.charAt(1)=='7') return way1 == 0 && wayPawn==2;
            else return way1 == 0 && wayPawn==1;
        }
        else if (type.equals("Rook")){
            return (way1 == 0) || (way2 == 0);
        }
        else if (type.equals("Knight")){
            return (way1==2 && way2==1) || (way1==1 && way2==2);
        }
        else if (type.equals("Bishop")){
            return way2==way1;
        }
        else if (type.equals("Queen")){
            return ((way1 == 0) || (way2 == 0)) || (way2==way1);
        }
        else if (type.equals("King")){
            return (way1==0 || way1==1) && (way2==0 || way2==1);
        }
        return false;
    }
    public static boolean canComplete(String a, String b){
        int cnt = 0;
        for (int i = 0; i < a.length();i++){
            if (cnt == b.length()-1) return false;
            boolean flag = false;
            for (int j =cnt; j<b.length();j++){
                if (a.charAt(i) == b.charAt(j)) {
                    flag = true;
                    cnt = j+1;
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }
    public static int sumDigProd(int[] a){
        int sum = 0;
        for (int i : a){
            sum += i;
        }
        while (true){
            int ans = 1;
            while (sum != 0){
                ans *= sum%10;
                sum /=10;
            }
            if (ans /10 ==0) return ans;
            sum = ans;
        }
    }
    public static ArrayList<String> sameVowelGroup(String[] a){
        HashSet<Character> b = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();
        String glasn = "aeyuio";
        for (int i = 0; i< a[0].length(); i++){
            if (glasn.indexOf(a[0].charAt(i))!=-1) b.add(a[0].charAt(i));
        }
        for (String j:a){
            HashSet<Character> curr = new HashSet<>();
            for (int i = 0; i< j.length(); i++){
                if (glasn.indexOf(j.charAt(i))!=-1) curr.add(j.charAt(i));
            }
            if (b.equals(curr)) ans.add(j);
        }
        return ans;
    }
    public static boolean validateCard(String a){
        if (!(a.length()>=14 && a.length()<=19)) return false;

        int check = a.charAt(a.length()-1)-'0';
        int sum = 0;
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = a.length()-2; i >= 0; i--){
            b.add((int) (a.charAt(i))-'0');
        }
        System.out.println(b);
        for (int i = 0; i<b.size(); i++){
            if (i%2 ==0) {
                if ((b.get(i) * 2 / 10) == 0) {
                    sum += b.get(i) * 2;

                    System.out.println(b.get(i) * 2);
                }
                else {
                    int currsum = 0;
                    int x = b.get(i) * 2;
                    while (x != 0) {
                        currsum += x % 10;
                        x /= 10;
                    }
                    sum += currsum;

                    System.out.println(currsum);
                }
            }
            else {
                sum+=b.get(i);
                System.out.println(b.get(i));
            }

        }
        System.out.println(sum);
        System.out.println(10 - (sum % 10)+" "+check);
        return 10 - sum % 10 == check;
    }
    public static String numToEng(int a){
        HashMap<Integer, String> MP = new HashMap<>(){{
            put(1, "one");put(2, "two");put(3, "three");put(4, "four");
            put(5, "five");put(6, "six");put(7, "seven");put(8, "eight");put(9, "nine");
            put(10, "ten");put(11, "eleven");put(12, "twelve");put(13, "thirteen");put(14, "fourteen");
            put(15, "fifteen");put(16, "sixteen");put(17, "seventeen");put(18, "eighteen");put(19, "nineteen");
        }};
        HashMap<Integer, String> TEN = new HashMap<>(){{
            put(2, "twenty");put(3, "thirty");put(4, "forty");put(5, "fifty");put(6, "sixty");
            put(7, "seventy");put(8, "eighty");put(9, "ninety");
        }};
        if (a==0) return "zero";
        else if (a>0&&a<20) return MP.get(a);
        else{
            String ans = "";
            if (a/100%10!=0) ans+=MP.get(a/100%10)+" hundred";
            if (a/10%10!=0) ans+= " " + TEN.get(a/10%10);
            if (a%10!=0) ans+=" " + MP.get(a%10);
            return ans;
        }
    }
    public static String correctTitle(String a){
        String ans = "";
        String[] words = a.toLowerCase().split(" ");
        for (String i : words){
            if (i.equals("of")|| i.equals("for")|| i.equals("the") || i.equals("in")){
                ans += i + " ";
            }
            else {
                String curr = (char)((int)i.charAt(0)-32) + i.substring(1);
                ans += curr + " ";
            }
        }
        return ans;
    }
    private static String getSha256Hash(String s) {
        try {
            // шифруем в байты строку через MessageDigest
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
            // переводим байты в хеш
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            return null;
        }
    }
    public static String hexLattice(int a){
        double n = (3+ Math.sqrt(12*a-3))/6;
        if (n != Math.round(n)) return "Invalid";
        String curr = "";
        System.out.println(n);
        for (int i = 0; i<n;i++){
            for (int j=0; j<n-i-1;j++){
                curr += " ";
            }
            for (int j=0; j<n+i;j++){
                curr += "o ";
            }
            curr+="\n";
        }
        for (int i = (int) (n-2); i>=0; i--){
            for (int j=0; j<n-i-1;j++){
                curr += " ";
            }
            for (int j=0; j<n+i;j++){
                curr += "o ";
            }
            curr+="\n";
        }
        return curr;
    }

}
