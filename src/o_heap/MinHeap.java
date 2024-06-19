package o_heap;

//1 4 1 2 3 1 6 2 0 3 3
class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insertKey(4);
        minHeap.insertKey(2);
        minHeap.extractMin();
        minHeap.insertKey(6);
        minHeap.deleteKey(0);
        minHeap.extractMin();
        minHeap.extractMin();
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    //Function to extract minimum value in heap and then to store
    //next minimum value at first index.
    int extractMin()
    {
        if(heap_size == 0)
            return -1;

        if(heap_size == 1){
            heap_size--;
            return harr[0];
        }

        swap(0, heap_size-1);
        heap_size--;
        this.MinHeapify(0);
        return harr[heap_size];


    }

    //Function to insert a value in Heap.
    void insertKey(int k)
    {
        if(heap_size == capacity)
            return;

        heap_size = heap_size+1;
        harr[heap_size-1] = k;

        int i = heap_size-1;
        while(i != 0 && harr[parent(i)] > harr[i]){
            swap(parent(i), i);
            i=parent(i);
        }
    }

    public void swap( int i1, int i2){
        int temp1 = harr[i1];
        harr[i1] = harr[i2];
        harr[i2] = temp1;
    }

    //Function to delete a key at ith index.
    void deleteKey(int i)
    {
        if(i >= heap_size)
            return;



        //Setting index value as Infinity
        harr[i] = Integer.MIN_VALUE;

        //Setting to be deleted node as root
        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(parent(i), i);
            i = parent(i);
        }

        //Swapping root and last leaf node of the tree
        harr[0] = harr[heap_size-1];
        heap_size = heap_size-1;

        MinHeapify(0);



    }

    //Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val)
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}

