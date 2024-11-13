import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of an Array: ");
        int size=sc.nextInt();

        int[] arr=new int[size];
        System.out.println("Enter the elements of an Array: ");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter the element to be searched: ");
        int search=sc.nextInt();        

        int index=elementAt(arr,search);
        if(index==-1){
            System.out.println(search+" not found");
        }
        else{
            System.out.println(search+" found at index "+index);
        }
        
        sc.close();
    }

    public static int elementAt(int[] arr,int search){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==search){
                return i;
            }
        }
        return -1;
    }
}
