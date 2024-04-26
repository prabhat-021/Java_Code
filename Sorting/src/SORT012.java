public class SORT012 {
    public static void main(String[] args) {
        int[] num={2,2,0,0,1,1,2,0,1,0};
        sort012(num);
        CountSort.printArray(num);
    }

    static void sort012(int[] arr){
        int lo=0,mid=0,hi= arr.length-1;
        while(mid<=hi){
            if(arr[mid]==0){
                moveZeros.swapElement(arr,mid,lo);
                mid++;
                lo++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else if(arr[mid]==2){
                moveZeros.swapElement(arr,mid,hi);
                hi--;
            }
        }
    }
}
