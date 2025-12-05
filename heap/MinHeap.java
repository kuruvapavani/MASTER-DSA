
public class MinHeap {

    public void insert(int[] heap, int size, int val) {
        if (size == heap.length) {
        throw new RuntimeException("Heap is full.");
    }
        int i = size;
        heap[i] = val;
        while (i > 0 && heap[i] < heap[(i - 1) / 2]) {
            int parent = (i - 1) / 2;
            int temp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = temp;
            i = parent;
        }
    }

    public int deleteMin(int[] heap, int size) {
        if (size == 0) {
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(heap, size, 0);

        return min;
    }

    private void heapifyDown(int[] heap, int size, int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest == i) {
                break;
            }

            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            i = smallest;
        }
    }
}
