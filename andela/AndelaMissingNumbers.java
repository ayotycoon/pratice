public class AndelaMissingNumbers {
    static int[] missingNumbers(int[] arr, int[] brr) {
        // Complete this function
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> mapB = new HashMap<>();
        for(int i=0; i<brr.length; i++){
            if(map.containsKey(brr[i])){
                map.put(brr[i],map.get(brr[i])+1);
            }else{
                map.put(brr[i],1);
            }
        }
        for(int j=0; j<arr.length; j++){
            if(mapB.containsKey(arr[j])){
                mapB.put(arr[j],mapB.get(arr[j])+1);
            }else{
                mapB.put(arr[j],1);
            }
        }
        Map<Integer,Integer> missingMap = new HashMap<>();
        for (Map.Entry<Integer,Integer> integerMap:mapB.entrySet()) {
            if (map.get(integerMap.getKey()) != null){
                if (map.get(integerMap.getKey()).intValue()!=integerMap.getValue()){
                    missingMap.put(integerMap.getKey(),integerMap.getValue());
                }
            }else {
                missingMap.put(integerMap.getKey(),integerMap.getValue());
            }
        }
        int [] miss = new int[missingMap.size()];
        int i=0;
        for (Map.Entry<Integer,Integer> missing: missingMap.entrySet()) {
            miss[i] = missing.getKey();
            i++;
        }
        return miss;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int [] {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
       /* for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int m = in.nextInt();*/
        int[] brr = new int[]{203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
        /*for(int brr_i = 0; brr_i < n; brr_i++){
            brr[brr_i] = in.nextInt();
        }*/
        int[] result = missingNumbers(arr, brr);
        System.out.println(result);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }

}