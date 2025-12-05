public class MinHeapBuilder {

    public void buildMinHeap(int[] heap, int size) {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            heapifyDown(heap, size, i);
        }
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

            if (smallest == i) break;

            // swap
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            i = smallest;
        }
    }
}
