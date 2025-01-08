import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class testDemo {
//    String compression program
//    Input: aaabbcc | Compressed: a3b2c2
//    Input: abc | Compressed: abc
//    Input: aaaaaa | Compressed: a6
//    Input:  | Compressed:
//    aabcccccaaa
//            a2bc5a3

    public static void main(String[] args) {
        String demo = "aabcccccaaa";

//        validateString(demo);

        validateStringSecond(demo);

    }

    private static StringBuilder validateStringSecond(String demo) {
        if(demo == null || demo.isBlank()){
            return new StringBuilder("");
        }
        char[] demoArr = demo.toCharArray();
        int count=0;
        int start=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<demoArr.length;i++){
            if(demoArr[start] == demoArr[i]){
                count++;
            }else {
                sb = count>1 ? sb.append(String.valueOf(demoArr[start]) + count) : sb.append(demoArr[start]);
                count = 0; start=i;i--;
            }
        }
        sb.append(String.valueOf(demoArr[start]) + count);
        System.out.println(sb);
        return sb;
    }


//    private static String validateString(String demo) {
//        Map<Character,Integer> count = new LinkedHashMap<>();
//        StringBuilder sb = new StringBuilder();
//        if(demo == null){
//            return;
//        }
//        char[] demoArr = demo.toCharArray();
//
//        for(int i=0;i<demoArr.length;i++){
//            if(count.containsKey(demoArr[i])){
//                count.put(demoArr[i], count.get(demoArr[i])+1);
//            }else {
//                count.put(demoArr[i],1);
//            }
//        }
//        for(Map.Entry<Character,Integer> res:count.entrySet()){
//            if(res.getValue()>1){
//                sb.append(res.getKey());
//                sb.append(res.getValue());
//            }else sb.append(res.getKey());
//        }
//        System.out.println(sb.toString());
//
//    }


}
