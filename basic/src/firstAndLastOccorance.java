public class firstAndLastOccorance {

    static int searchElement(int[] arr, int key,boolean firstOcc){

        int s=0;
        int e= arr.length-1;
        int ans=-1;

        while(s<=e){
           int mid=s+(e-s)/2;
            if(arr[mid]>key){
                e=mid-1;
            }
            else if(arr[mid]<key){
                s=mid+1;
            }
            else {
                if (firstOcc) {
                    ans = mid;
                    e = mid - 1;
                } else {
                    ans = mid;
                    s = mid + 1;
                }
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] ans={-1,-1};
        int[] arr={3,5,7,9,10,90,100,130,140,160,170};
        int target=10;
        int first=searchElement(arr,target,true);
        int last=searchElement(arr,target,false);

    }
}
