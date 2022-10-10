public class task1 {
    public static void main(){
        System.out.println("remainder: " + remainder(3,4));
        System.out.println("triArea: " + triArea(7,4));
        System.out.println("animals: " + animals(1,2,3));
        System.out.println("profitableGamble: " + profitableGamble(0.9,1,2));
        System.out.println("operation: " + operation(24,26,2));
        System.out.println("ctoa: " + ctoa('['));
        System.out.println("addUpTo: " + addUpTo(3));
        System.out.println("nextEdge " + nextEdge(5,7));
        System.out.println("sumOfCubes " + sumOfCubes(new int[] {1, 5, 9}));
        System.out.println("abcmath: " + abcmath(1, 2, 3));
    }
    public static int remainder(int a, int b){
        return a % b;
    }
    public static int triArea(int a, int h){
        return a * h / 2;
    }
    public static int animals(int a, int b, int c){
        return a*2+b*4+c*4;
    }
    public static boolean profitableGamble(double prob, int prize, int pay){
        return prob * prize > pay;
    }
    public static String operation(int n, int a, int b){
        if (a - b == n) return "subtracted";
        else if (a + b == n) return "added";
        else if (a / b == n) return "divided";
        else if (a * b == n) return "multiplied";
        else return "none";
    }
    public static int ctoa(char a){
        return a;
    }
    public static int addUpTo(int a){
        int sum = 0;
        for(int i = 1; i <= a; i++){
            sum += i;
        }
        return sum;
    }
    public static int nextEdge(int a, int b){
        return a + b - 1;
    }
    public static int sumOfCubes(int[] args){
        int sum = 0;
        for (int i = 0; i< args.length; i++){
            sum += args[i];
        }
        return sum;
    }
    public static boolean abcmath(int a, int b, int c){
        return a * (b + 1) % c == 0;
    }
}