class Solution {
    public static void main(String[] args) {

        int[] arr={9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        int a=arraySign(arr);
        System.out.println(a);
    }
    public static int arraySign(int[] arr) {
        int mul=1;
        for(int i=0;i<arr.length;i++){
            mul=mul*arr[i];
        }

        if(mul<0){
            return -1;
        }
        else if(mul>0){
            return 1;
        }
        return 0;
    }
}