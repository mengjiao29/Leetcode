package code;

public class Solution {
    public static  void main(String[] args){
        String[] equations={"e==d","e==a","f!=d","b!=c","a==b"};
        System.out.println(equationsPossible(equations));
    }
    public static boolean equationsPossible(String[] equations) {
        String[] arr=new String[1000];
        for(int i=0;i<equations.length*2;i++){
         arr[i]="";
        }
        int j=0;
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1)=='!'){
                continue;
            }
            else if(equations[i].charAt(0)==equations[i].charAt(3)  ){
                    continue;
            }

            int first= find(arr,equations[i].charAt(0),j);
            int second = find(arr,equations[i].charAt(3),j);
            System.out.println(first);
            System.out.println(second);
                int n=0;
                if(first != second &&first!=-1&&second!=-1){
                    arr[first] += arr[second];
                    arr[second] ="";
                }

                if(first ==-1 &&second!=-1)//左边儿找到，右边儿未找到
                    arr[second] += equations[i].charAt(0);
                else if(first !=-1&& second==-1)
                    arr[first] += equations[i].charAt(3);
                else{//都找不到
                    arr[j] += equations[i].charAt(0);
                    arr[j] += equations[i].charAt(3);
                    j++;

                }

        }
        for(int i=0;i<equations.length;i++){
             if(equations[i].charAt(1) != '!')
                 continue;
             else if(equations[i].charAt(0)==equations[i].charAt(3))
                 return false;
            int first= find(arr,equations[i].charAt(0),j);
            int second = find(arr,equations[i].charAt(3),j);
             if(first==second && first!=-1 )//找到在同一行
                    return false;
                else if(first==-1){//都未找到
                    arr[j] += equations[i].charAt(0);
                    j++;

                }else if(second == -1){
                    arr[j] += equations[i].charAt(3);
                    j++;
                }
            }
        return true;

    }
    public static int find(String[] arr, char char1,int j){
        if(j==0) return -1;
        for (int i=0;i<j;i++){
            if(arr[i].indexOf(char1)!=-1){
                return  i;
            }
        }
        return -1;
    }

}
