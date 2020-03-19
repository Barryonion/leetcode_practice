package recursion;

public class Recursion {
    private int[] results;

    public Recursion() {}
    public Recursion(int n) {
        this.results = new int[n];
    }
    private int fibonacciFunctionV1(int n) {/*基础版*/
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fibonacciFunctionV1(n - 1) + fibonacciFunctionV1(n - 2);
    }

    private int fibonacciFunctionV2(int n) {/*进化版*/
        if (n == 1) return 1;
        if (n == 2) return 2;
        /*新增散列表存储计算结果*/
        if (results[n - 1] != 0) {
            return results[n-1];
        }
        results[n-1] = fibonacciFunctionV2(n - 1) + fibonacciFunctionV2(n - 2);
        return results[n-1];
    }




    public static void main(String[] args) {
        int n = 5;
        Recursion recursion = new Recursion();
        /*Recursion recursion = new Recursion(n);
        long startTime = System.nanoTime();
//        int result = recursion.fibonacciFunctionV1(n);
        int result = recursion.fibonacciFunctionV2(n);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("斐波那契数列第" + n + "项值为： " + result);
        System.out.println("fibonacciFunctionV1函数总用时:" + totalTime + "ns");*/

        int factorial = recursion.factorial(n);
        System.out.println(n + "的阶乘为：" + factorial);



    }

    private int permutation(int[] array) {
        return 0;
    }

    private int factorial(int n) {
        if (n==1) return 1;
        return factorial(n - 1) * n;
    }
}
