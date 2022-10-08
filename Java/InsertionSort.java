public class InsertionSort {

	public static void main(String[] args) {
		int arr[]= {5,3,2,4,1};
		System.out.println("Intially array is");
		for(int i = 0;i < arr.length;i++)
		{
			System.out.print(" "+arr[i]);
		}
		System.out.println();
		insertion_sort(arr);
		System.out.println("Finally array sorted is");
		for(int i = 0;i < arr.length;i++)
		{
			System.out.print(" "+arr[i]);
		}
		System.out.println();

	}
	public static void insertion_sort(int arr[])
	{
		for(int i = 0;i < arr.length-1;i++)
		{
			for(int j = i+1;j > 0;j--)
			{
				if(arr[j] < arr[j-1])
				{
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
}

