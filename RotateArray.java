import java.util.*;

public class RotateArray {
    static void reverse(int[] arr,int l,int r){
        while(l<r){
            int t=arr[l];
            arr[l]=arr[r];
            arr[r]=t;
            l++; r--;
        }
    }

    public static void rotate(int[] arr,int k){
        k%=arr.length;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
    }

    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7};
        rotate(arr,3);
        System.out.println(Arrays.toString(arr));
    }
}
