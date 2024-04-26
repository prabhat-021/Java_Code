
public class moveZeros {
    public static void main(String[] args) {
          int[] arr={0,5,0,3,4,2,0,9};
          bubble(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    static void bubble(int[] arr){
        int  n= arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j]<arr[j+1] && arr[j]==0){
                    swapElement(arr,j,j+1);
                }
            }
        }
    }

    static void swapElement(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}