import java.util.Scanner;

public class MaximumGapSuccessiveElements {
    public static void main(String args[]){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size=scanner.nextInt();
        int arr[]= new int[size];
        System.out.println("Enter the elements into the array : ");
        for(int i=0;i<size;++i){
            arr[i]= scanner.nextInt();
        }
        System.out.println("The maximum gap between successive elements  :  "+findMax(arr,size));
    }
    public static int findMax(int[] arr, int size){
        int max=0;
        for(int i=0;i<size-1;++i){
            int sub=arr[i+1]-arr[i];
            if(sub >max){
                max=sub;
            }
        }
        return max;
    }
}
