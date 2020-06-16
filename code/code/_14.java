package code;
//最长公共前缀
public class _14 {
    public  static void  main(String[] args){
        String[] strs={"faf","faf","ff"};
        System.out.println("结果为："+longestCommonPrefix(strs));
        System.out.println("结果为："+longestCommonPrefix1(strs));
    }
    //12ms 7%, 38.2 5%
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];

        String str ="";

        int length = strs[0].length();
        for(int i=1;i<strs.length;i++)
            if(length>strs[i].length())
                length = strs[i].length();
        for(int j=0;j<length;j++){
            if(equips(j,strs))
                str+=strs[0].charAt(j);
            else
                return str;

        }
        return str;
    }
    public  static boolean  equips( int index, String[] strs){
        for(int i=0;i<strs.length;i++){
            if(index > strs[i].length()) return  false;
            if (strs[0].charAt(index) != strs[i].charAt(index)){
                return false;
            }
        }
        return true;
    }
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String str = "";
        int i=0,j=strs[0].length()-1,
                Zhongjian= (i+j)%2==0 ? (i+j)/2:(i+j-1)/2;
        while(i!=Zhongjian && j!=Zhongjian){

            if(!equips1(Zhongjian,strs)){
                j=Zhongjian;
            }else{
                System.out.println("："+strs[0].substring(i,Zhongjian));
                str += strs[0].substring(i,Zhongjian);
                i=Zhongjian;
            }
            Zhongjian=(i+j)%2==0 ? (i+j)/2:(i+j-1)/2;
        }
        if(equips1(i,strs)){
            System.out.println(strs[0].charAt(j));
            str += strs[0].charAt(i);
        }

        if(equips1(j,strs)){
            System.out.println(strs[0].charAt(j));
            str += strs[0].charAt(j);i
        }

        return str;
    }
    public  static boolean  equips1( int endindex, String[] strs){
        for(int i=0;i<strs.length;i++){
            if(endindex > strs[i].length()) return  false;
            System.out.println("比较："+strs[0].substring(0,endindex)+"和"+strs[i].substring(0,endindex));
            if (!(strs[0].substring(0,endindex) .equals(strs[i].substring(0,endindex))) ){
                return false;
            }
        }

        return true;
    }
}
