package Assignments;

public class Implementation{
    public static void swap(int[] heap,int parent,int child){
        int temp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = temp;
    }
    public static void heapify(int[] heap,int index,int n){
        int parent = index, child = 2*parent;
        while(child<=n){
            if(child+1 <= n && heap[child]<heap[child+1]){
                ++child;
            }
            if(heap[parent] < heap[child]){
                swap(heap, parent, child);
                parent = child;
                child = 2*parent;
            }else{
                break;
            }
        }
    }
    public static void heap_pop(int[] heap,int size){
        swap(heap,1,size);
        heapify(heap, 1, size-1);
    }
    public static void increamentKey(int[] heap,int index){
        int temp = heap[index];
        while(index>1 && temp>heap[index/2]){
            heap[index] = heap[index/2];
            index/=2;
        }
        heap[index] = temp;
    }
    public static void decreamentKey(int[] heap,int index){
        heapify(heap,index,heap.length);
    }
    public static void EditingHeap(int[] heap,int index,int val){
        if(heap[index] < val){
            heap[index] = val;
            increamentKey(heap, index);
        }else if(heap[index] > val){
            heap[index] = val;
            decreamentKey(heap, index);
        }
    }
    public static void heapSort(int[] heap,int n){
        int size = n;
        for(int i=1;i<n;i++){
            heap_pop(heap,size);
            size--;
        }
    }
    public static void BuildMaxHeap(int[] heap,int n){
        for(int i=n/2;i>=1;i--){
            heapify(heap,i,n);
        }
    }
    public static void main(String[] args) {
        int[] heap = {0,10,20,30,25,5,40,35};
        int n = 7;
        BuildMaxHeap(heap,n);
        heapSort(heap,n);
        for(int j=1;j<=n;j++){
            System.out.print(heap[j]+" ");
        }System.out.println();
    }
}