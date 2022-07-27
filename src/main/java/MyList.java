import java.util.Collection;

public interface MyList<E> {

    int size();

    boolean contains(Object o);

    boolean add(Object o);

    void add(int index, Object element);

    boolean addAll(Collection<E> c);

    void clear();

    E get(int index);

    int indexOf(Object o);

    boolean isEmpty();

    boolean remove(Object o);

    E remove(int index);

    Object set(int index, Object element);
}

