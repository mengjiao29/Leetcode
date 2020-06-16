package code;
//爬楼梯，
public class _70 {
    public static  void main(String[] args){
        int n=35;
        System.out.println("最终结果为："+climbStairs1(n));


    }
    public static int climbStairs(int n) {
       if(n==1) return 1;
       if(n==2) return 2;
       return climbStairs(n-1)+climbStairs(n-2);
    }
    public static int climbStairs1(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int first=1,second=2,sum=0;
        for(int i=0;i<n-2;i ++){
            sum =first+second;
            first =second;
            second=sum;
            System.out.println("值:"+(i+3));
            System.out.println(sum);
        }
        return sum;

    }

}
