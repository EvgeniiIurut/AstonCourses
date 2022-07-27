import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {
    private Object[] array;
    private int size = 0;
    private int capacity;
    private final static int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        array = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    private void increaseCapacity() {
        capacity = (capacity * 3) / 2 + 1;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void isSizeOfArrayValueCorrect() {
        if (size + 1 >= capacity) {
            increaseCapacity();
        }
        if (size + 1 == Integer.MAX_VALUE) {
            throw new ArrayStoreException("OUT OF ARRAY SIZE EXCEPTION");
        }
    }

    private boolean isIndexCorrect(int index) {
        return (index <= size) && (index >= 0);
    }

    private void shiftToLeft(int start) {
        if (size <= 0 || start >= size) {
            return;
        }
        for (var i = start; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size] = null;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public boolean add(Object o) {
        isSizeOfArrayValueCorrect();
        array[size++] = o;
        return true;
    }

    public void add(int index, Object element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Out of Bounds Exception");
        isSizeOfArrayValueCorrect();
        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public boolean addAll(Collection<E> c) {
        if (c == null || c.isEmpty()) {
            return false;
        }
        while (c.size() + size > capacity) {
            increaseCapacity();
        }
        for (Object item : c) {
            if (size + 1 == Integer.MAX_VALUE) {
                throw new ArrayStoreException("OUT OF ARRAY SIZE EXCEPTION");
            }
            add(item);
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        if (isIndexCorrect(index)) {
            return (E) array[index];
        } else {
            throw new IndexOutOfBoundsException("Out of Bounds Exception");
        }
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean remove(Object o) {
        if ((size == 0)) {
            return false;
        }
        int i;
        for (i = 0; i < size; i++) {
            if (array[i] == null && o == null) {
                break;
            }
            if ((array[i] != null) && (array[i].equals(o))) {
                break;
            }
        }
        if (i < size) {
            shiftToLeft(i);
            size--;
            return true;
        }
        return false;
    }

    public E remove(int index) {
        if (isIndexCorrect(index)) {
            Object currentObject = get(index);
            shiftToLeft(index);
            size--;
            return (E) currentObject;
        } else {
            throw new IndexOutOfBoundsException("Out of Bounds Exception");
        }
    }

    private boolean isIndexCorrect(boolean b, boolean b2) {
        return (b) && (b2);
    }

    public Object set(int index, Object element) {
        if (isIndexCorrect(index)) {
            Object o = array[index];
            array[index] = element;
            return o;
        } else {
            throw new IndexOutOfBoundsException("Out of Bounds Exception");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return size == that.size && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
