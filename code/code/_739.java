package code;

import java.util.Stack;

public class _739 {
    public static  void main(String[] args){
        //长度[1,30000] 温度，[30,100]
     int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
     for(int item : dailyTemperatures3(temperatures)){
         System.out.println(item);
     }

    }
    //该方法时间和空间复杂度较高。
    public static int[] dailyTemperatures1(int[] T) {
        int i=0,j=0;
        for(i=0;i<T.length;i++){
            for(j=i+1;j<T.length;j++){
                if(T[i]<T[j]){
                    T[i] = j-i;
                    break;
                }
            }
            if(j==T.length)
                T[i] =0;

        }
        for( int item :T)
            System.out.println(item);
        return  T;
    }

    //时间34， 33%，内存6%
    public static int[] dailyTemperatures2(int[] T) {
        if (T.length==1) {
            T[0]=0;
            return  T;
        }
        Stack<Integer>  stack= new Stack<>();
        int i=0;
         for (i=0;i<T.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            while ( T[i]>T[stack.peek()] ){
                System.out.println("弹出的是:"+T[stack.peek()]+"现在:"+T[i]);
                T[stack.peek()]=i-stack.peek();
                stack.pop();//弹出
                if(stack.isEmpty()) break;
            }
                stack.push(i);
        }
        while (!stack.isEmpty()){
            T[stack.peek()]=0;
            stack.pop();//弹出
        }
        return T;


    }
    //逆序,时间3s，100%，内存47.8M，6%
    //从后往前比较容易时间，
    public static  int[] dailyTemperatures3(int[] T) {
        int[] Tl = new int[T.length];
        if (T.length == 1) {
            Tl[0] = 0;
            return Tl;
        }
        int i = T.length - 1;

        Tl[i] = 0;
        for (; i > 0; i--) {
            int j = i;
            System.out.println(T[i]);
            while (true) {
                if (T[i - 1] < T[j]) {
                    Tl[i - 1] = j - i + 1;
                    break;
                } else if (Tl[j] == 0) {
                    Tl[i - 1] = 0;
                    break;
                }
                j += Tl[j];

            }
        }
        return Tl;
    }

}
