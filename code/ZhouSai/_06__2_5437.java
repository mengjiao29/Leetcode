package ZhouSai;
import java.util.*;

public class _06__2_5437 {
    public static void main(String[] args){
        int[] arr = {4,3,1,1,3,3,2,4};
        int k = 1;

        System.out.println(findLeastNumOfUniqueInts1(arr,k));
    }
    //ֻ��Ҫͳ��
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k== arr.length ) return 0;
        if (k== arr.length-1 ) return 1;
        Arrays.sort(arr);
        System.out.println("����������������£�");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count=1,i=0;
        for(;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                count++;
                if(i+1==arr.length-1){
                    map.put(arr[i],count);
                }
                continue;
            }else{
                map.put(arr[i],count);
                count=1;
                if(i+1==arr.length-1){
                    map.put(arr[i+1],count);

                }
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            //compareTo() �������ڽ� Number �����뷽���Ĳ������бȽϡ������ڱȽ� Byte, Long, Integer�ȡ�
            //�÷�������������ͬ�������͵ıȽϣ�������ͬ���͵����ݲ����ô˷������Ƚϡ�
            //��ȷ���0��С�ڷ���-1�����ڷ���1
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return  o1.getValue().compareTo(o2.getValue());
            }//o1,o2 ���� o2,o1����
        });
//        System.out.println("�����");
//        for(Map.Entry<Integer,Integer> mapping : list)
//            System.out.println(mapping);

        while(k>0){
            k -= list.get(0).getValue();
            if(k>=0)
                list.remove(0);
        }
        System.out.println(list.size());



        return list.size();

    }

    public static int findLeastNumOfUniqueInts1(int[] arr, int k) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int num = arr[0];
        int cnt = 1;
        for(int i = 1; i < arr.length; i++){
            if(num == arr[i]){
                cnt++;
            }else {
                list.add(cnt);
                num = arr[i];
                cnt = 1;
            }
        }
        list.add(cnt);
        System.out.println(list);
        Collections.sort(list);
        int res = list.size();
        for(int i:list){
            k -= i;
            if(k>=0)res-=1;
        }
        return res;
    }

}
