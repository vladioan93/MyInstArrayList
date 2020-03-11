import java.util.Arrays;

public class MyIntArrayList {

    private int[] elements;
    private int size;

    public MyIntArrayList() {
        this(10);
    }

    public MyIntArrayList(MyIntArrayList c) {
        this.size = c.size;
        this.elements = c.elements;
    }

    public MyIntArrayList(int initialCapacity) {
        this.elements = new int[initialCapacity];
    }

    public void add(int index, int element) {
        if (index > this.size || index < 0) {
            System.out.println("Throwing IndexOutOfBoundsException when trying to add" +
                    " the element " + element + " at position " + index);
        } else {
            this.size++;
            for (int i = index + 1; i < size - 1; i++) {
                elements[i + 1] = elements[i];
            }
            elements[index] = element;
        }
    }

    public boolean add(int e) {
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }

        this.elements[size] = e;
        this.size++;

        return true;
    }

    public int size() {
        return this.size;
    }

    public boolean contains(int e) {
        for (int i = 0; i < this.size; i++) {
            if (elements[i] == e) {
                return true;
            }
        }

        return false;
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            return -1;
        }
        return elements[index];
    }

    public int indexOf(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int e) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                System.out.println("Removed element " + e + " from index " + i);
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                this.size -= 1;
                return true;
            }
        }

        return false;
    }

    public int removeElementAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            // should throw IndexOutOfBoundsException
            System.out.println("Throwing IndexOutOfBoundsException when trying to" +
                    " remove element at position " + index);
            return -1;
        }

        int removedElement = this.elements[index];
        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;

        return removedElement;
    }

    public void clear() {
        this.size = 0;
    }

    public int set(int index, int e) {
        if (index < 0 || index >= this.size) {
            // should throw IndexOutOfBoundsException
            System.out.println("Throwing IndexOutOfBoundsException when trying to set" +
                    " the element " + e + " at position " + index);
            return -1;
        }

        int replacedElement = this.elements[index];
        this.elements[index] = e;
        return replacedElement;
    }

    public boolean addAll(MyIntArrayList c) {
        int initialSize = this.size;
        this.size += c.size;

        for (int i = 0; i < c.size; i++) {
            this.elements[initialSize + i] = c.elements[i];
        }

        return true;
    }


    public boolean addAll(int index, MyIntArrayList c) {
        if (index > this.size - 1 || index < 0) {
            return false;
        }
        int initialSize = this.size;
        this.size += c.size;

        for (int i = 0; i < initialSize - index; i++) {
            this.elements[initialSize + i + 1] = this.elements[index + i];
        }

        for (int i = 0; i < c.size; i++) {
            this.elements[index + i] = c.elements[i];
        }

        return true;
    }

    public int[] toArray() {
        int[] arr = new int[this.size];

        for (int i = 0; i < this.size; i++) {
            arr[i] = this.elements[i];
        }

        return arr;
    }

    public void ensureCapacity(int minCapacity) {
        this.size = minCapacity;
    }

    public void trimToSize() {
        while (lastIndexOf(0) == this.size - 1) {
            this.size--;
        }
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(this.elements[i] + ", ");
        }
    }

}
