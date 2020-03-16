package dynamicprogramming;

public class climb_Stairs {
    public int climbStairsApproch1(int n) {
        return climb_StairsApproch1(0,n);
    }
    public int climb_StairsApproch1(int i ,int n){
        if (i > n)
            return 0;
        if (i == n)
            return 1;
        return climb_StairsApproch1(i+1,n) + climb_StairsApproch1(i+2,n);
    }


    public int climbStairsApproch2(int n){
        int [] memo = new int[n+1];
        return climb_StairsApproch2(0,n,memo);
    }

    private int climb_StairsApproch2(int i,int n , int [] memo) {
        if (i > n)
            return 0;
        if (i == n)
            return 1;
        if (memo[i] > n)
            return memo[i];
        memo[i] = climb_StairsApproch2(i+1,n,memo) + climb_StairsApproch2(i+2,n,memo);
        return memo[i];
    }
    public int climb_stairsApproch3(int n){
        if (n == 1)
            return 1;
        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i =3 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int climb_stairsApproch4(int n){
        if (n == 1)
            return 1;
        int first = 1;
        int second =2;
        for (int i = 3 ; i <= n; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    public static void main(String[] args) {
        climb_Stairs c = new climb_Stairs();
        System.out.println(c.climb_stairsApproch4(8));

    }
}
