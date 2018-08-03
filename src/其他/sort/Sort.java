package 其他.sort;


public class Sort {
	public static void main(String[] args) throws Exception {
		int[] arr = new int[10];
		for (int a = 0; a < arr.length; a++) {
			arr[a] = (int) (Math.random() * 10);
		}
		for (int a = 0; a < arr.length; a++) {
			System.out.print(arr[a]+" ");
		}
		System.out.println();
		shellsort(arr, 0, arr.length-1);
		for (int a = 0; a < arr.length; a++) {
			System.out.print(arr[a]+" ");
		}
	}
	//选择排序
	static void selectSort(int[] arr,int start,int end) {
		int biaoji=0;
		for (int a=start;a<=end;a++) {
			for (int b=a+1;b<=end;b++) {
				if (arr[a]>arr[b]) {
					biaoji=arr[a];
					arr[a]=arr[b];
					arr[b]=biaoji;
				}
			}
		}
	}
	//冒泡排序
	static void bubbleSort(int arr[],int start,int end) {
		int biaoji=0;
		for (int a=0;a<=end;a++) {
			for (int b=0;b<end-a;b++) {
				if (arr[b]>arr[b+1]) {
					biaoji=arr[b];
					arr[b]=arr[b+1];
					arr[b+1]=biaoji;
				}
			}
		}
	}
	//插入排序
	static void addsort(int[] arr,int start,int end) {
		int biaoji=0;
		int c=0;
		for (int a=0;a<=end;a++) {
			biaoji=arr[a];//做数值交换的时候无用变量的使用
			c=a;
			for (int b=a-1;b>=0&&biaoji<arr[b];b--) {
				if (arr[b]>biaoji) {
					arr[b+1]=arr[b];
					c=b;
				}
			}
			arr[c]=biaoji;
		}
	}
	//希尔排序  --   插入排序先选则然后在进行排序
	static void shellsort(int[] arr,int start,int end) {
		int speed=(end+1)/2;
		int biaoji=0;
		int c=0;
		while (speed!=0) {
			for (int a=0;a<=end;a++) {
				biaoji=arr[a];//做数值交换的时候无用变量的使用
				c=a;
				for (int b=a-speed;b>=0&&biaoji<arr[b];b=b-speed) {
					if (arr[b]>biaoji) {
						arr[b+speed]=arr[b];
						c=b;
					}
				}
				arr[c]=biaoji;
			}
			System.out.println(speed);
			speed/=2;
		}
	}
	//简单快速排序
	static void qsort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int zhong = arr[start];
		int starts = start;
		int ends = end;
		while (starts < ends) {
			while (starts < ends) {
				if (arr[ends] < zhong) {
					arr[starts] = arr[ends];
					starts++;
					break;
				}
				ends--;
			}
			while (starts < ends) {
				if (arr[starts] > zhong) {
					arr[ends] = arr[starts];
					ends--;
					break;
				}
				starts++;
			}
		}
		arr[starts] = zhong;
		qsort(arr, start, starts - 1);
		qsort(arr, starts + 1, end);
	}
	//归并排序
	static void  mergeSort(int[] arr ,int start,int end,int[] need) {
		if (start>=end) {
			return;
		}
		int x=(start+end)/2;
		int b=x+1;
		int c=0;
		mergeSort(arr, start, x, need);
		mergeSort(arr, x+1, end, need);
		for (int a=start;a<=x;c++) {
			if (b>end||arr[a]<arr[b]) {
				need[c]=arr[a];
				a++;
			}else {
				need[c]=arr[b];
				b++;
			}
		}
		while (b<=end) {
			need[c]=arr[b];
			b++;
			c++;
		}
		for (int a=start;a<start+c;a++) {
			arr[a]=need[a-start];
		}
		return ;
	}
	//堆排序
	static public void Heapsort(int[] arr,int start,int end) {
		class Heap{
			public void createHeapMin(int[] arr,int start,int end) {
				int ends= end+1;
				int x=0;
				while (ends>1) {
					if (arr[ends-1]>arr[ends/2-1]) {
						x=arr[ends/2-1];
						arr[ends/2-1]=arr[ends-1];
						arr[ends-1]=x;
					}
					ends--;
				}
			}
		}
		Heap heap= new Heap();
		heap.createHeapMin(arr, 0,end);
		int a;
		while (end>=0) {
			a=arr[0];
			arr[0]=arr[end];
			arr[end]=a;
			end--;
			heap.createHeapMin(arr, 0,end);
		}
	}
	// 计数排序（按位加桶） 桶排序（分组在排序） 基数排序（确定映射）---
}
