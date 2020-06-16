package code;

import java.util.Stack;

public class _739 {
    public static  void main(String[] args){
        //����[1,30000] �¶ȣ�[30,100]
     int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
     for(int item : dailyTemperatures3(temperatures)){
         System.out.println(item);
     }

    }
    //�÷���ʱ��Ϳռ临�ӶȽϸߡ�
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

    //ʱ��34�� 33%���ڴ�6%
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
                System.out.println("��������:"+T[stack.peek()]+"����:"+T[i]);
                T[stack.peek()]=i-stack.peek();
                stack.pop();//����
                if(stack.isEmpty()) break;
            }
                stack.push(i);
        }
        while (!stack.isEmpty()){
            T[stack.peek()]=0;
            stack.pop();//����
        }
        return T;


    }
    //����,ʱ��3s��100%���ڴ�47.8M��6%
    //�Ӻ���ǰ�Ƚ�����ʱ�䣬
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
