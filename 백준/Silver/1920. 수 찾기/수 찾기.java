import java.util.*;

public class Main {
	
	public static void main(String args[]){
	   	
		int i,j,n,m, temp;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int arr[]=new int [n];
		for(i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		m=sc.nextInt();
		Arrays.sort(arr);
		int arr2[]=new int [m];
		for(i=0;i<m;i++) {
			arr2[i]=sc.nextInt();
		}
		for(i=0;i<m;i++)
		{
			System.out.println(binarySearch(arr, arr2[i]));
		}
	}
	public static int binarySearch(int arr[],int num)
	{
		int low=0;
		int hi=arr.length-1;
		int mid=0;
		
		while(low<=hi) {
			mid=(low+hi)/2;
			if(arr[mid]==num)
				return 1;
			else if(arr[mid]>num)
				hi=mid-1;
			else if(arr[mid]<num)
				low=mid+1;
		}
		return 0;
	}
}