import java.util.Scanner;

public class Largest {
    public static void main(String args[]){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size=scanner.nextInt();
        int arr[]= new int[size];
        System.out.println("Enter the elements into the array : ");
        for(int i=0;i<size;++i){
            arr[i]= scanner.nextInt();
        }
        sort(arr,size);
        System.out.println("Enter the K value to know the Kth largest value : ");
        int k= scanner.nextInt();
        System.out.println("The "+k+" largest element in the array is : "+arr[k-1]);
    }

    private static void sort(int[] arr, int size) {
        for(int i=0;i<size;++i){
            int max= arr[i];
            for(int j=i+1;j<size;++j){
                if(arr[j]>max){
                    max=arr[j];
                    arr[j]=arr[i];
                    arr[i]=max;
                }
            }
        }
    }
}
