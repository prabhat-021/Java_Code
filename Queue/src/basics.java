public class basics {
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        queue.insert(3);
        queue.insert(6);
        queue.insert(7);
        queue.insert(9);
        queue.insert(10);
        queue.insert(19);

        queue.display();
    }

    public static class CustomQueue {
        protected int[] data;

        private static final int DEFAULT_SIZE = 10;

        int end = -1;

        public CustomQueue() {
            this(DEFAULT_SIZE);
        }

        public CustomQueue(int size) {
            this.data = new int[size];
        }

        public boolean isFull() {
            return end == data.length - 1;
        }

        public boolean isEmpty() {
            return end == -1;
        }

        public boolean insert(int item) {
            if (isFull()) return false;
            data[++end] = item;
            return true;
        }

        public int remove() throws Exception {
            if (isEmpty()) throw new Exception("Queue is Empty");
            int removed = data[0];

//          shift the element to left
            for (int i = 1; i < end; i++) {
                data[i - 1] = data[i];
            }
            end--;
            return removed;
        }

        public int front() throws Exception {
            if (isEmpty()) throw new Exception("Queue is empty");
            return data[0];
        }

        public void display() {
            for (int i = 0; i < end; i++) {
                System.out.println(data[i] + " ");
            }
        }

    }

    public static class CircularQueue {
        protected int[] data;

        private static final int DEFAULT_SIZE = 10;

        protected int end = 0;
        protected int front = 0;
        private int size = 0;

        public CircularQueue() {
            this(DEFAULT_SIZE);
        }

        public CircularQueue(int size) {
            this.data = new int[size];
        }

        public boolean isFull() {
            return size == data.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean insert(int item) {
            if (isFull()) return false;
            data[++end] = item;
            end = end % data.length;
            size++;
            return true;
        }

        public int remove() throws Exception {
            if (isEmpty()) throw new Exception("Queue is Empty");
            int removed = data[front++];
            size--;
            return removed;
        }

        public int getFront() throws Exception {
            if (isEmpty()) throw new Exception("Queue is Empty");
            return data[front];
        }

        public void display() {
//            for (int i = front; i < end; i++) {
//                System.out.println(data[i] + " ");
//            }
            if (isEmpty()) {
                System.out.println("Empty");
                return;
            }
            int i = front;
            do {
                System.out.println(data[i] + " ");
                i++;
                i %= data.length;
            } while (i != end);
            System.out.println("END");
        }
    }

    public static class DynamicQueue extends CircularQueue {
        public DynamicQueue() {
            super();
        }

        public DynamicQueue(int size) {
            super(size);
        }

        @Override
        public boolean insert(int item) {
            if (isFull()) {
//                 Double the size
                int[] temp = new int[data.length * 2];
//                 Copy the Elements
                for (int i = 0; i < data.length; i++) {
                    temp[i] = data[(front + i) % data.length];
                }
                data = temp;
            }
//             at this point we know array is not full
//             insert item
            return super.insert(item);
        }

    }
}
