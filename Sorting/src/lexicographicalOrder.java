public class lexicographicalOrder {
    public static void main(String[] args) {
        String[] fruits={"kiwi","apple","papaya","mango"};
        sortFruits(fruits);
        for (String val:fruits) {
            System.out.print(val);
        }
    }
    static void sortFruits(String[] arr){
        int n= arr.length;
        for (int i = 0; i < n; i++) {
            int minIdx=i;
            for (int j = i+1 ;j <n ; j++) {
                if(arr[j].compareTo(arr[minIdx])<0){
                    minIdx=j;
                }
            }
            String temp=arr[i];
            arr[i]=arr[minIdx];
            arr[minIdx]=temp;
        }
    }
}
