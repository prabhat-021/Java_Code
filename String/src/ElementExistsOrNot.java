public class ElementExistsOrNot {
    public static void main(String[] args) {

    }

    static void allIndeces(int[] arr,int target,int inx){
        if(inx >= arr.length){
            return;
        }
        if(arr[inx]==target){
            System.out.println(inx);
        }
        allIndeces(arr,target,inx+1);
    }
}
