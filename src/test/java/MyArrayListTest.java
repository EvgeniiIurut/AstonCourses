import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    @Test
    void should_return_size_of_array() {
        MyList<Object> myList = new MyArrayList<>();
        Object expected = new Object();
        myList.add(expected);
        myList.add(expected);
        int expectedSize = 2;

        assertEquals(expectedSize, myList.size());
    }

    @Test
    void should_check_object_is_in_array() {
        MyList<Object> myList = new MyArrayList<>();
        Object expected = new Object();
        myList.add(expected);

        assertTrue(myList.contains(expected));
    }

    @Test
    void should_add_object_to_array() {
        MyList<Object> myList = new MyArrayList<>();
        Object expected = new Object();
        myList.add(expected);
        assertEquals(expected, myList.get(0));
        assertEquals(1, myList.size());
    }

    @Test
    void should_add_object_to_array_by_index() {
        MyList<Object> myList = new MyArrayList<>();
        Object first = new Object();
        Object expected = new Object();
        myList.add(first);
        myList.add(0, expected);
        assertEquals(expected, myList.get(0));
        var exception = assertThrows(IndexOutOfBoundsException.class,
                () -> myList.add(3, expected));
        assertEquals(exception.getMessage(), "Out of Bounds Exception");
    }

    @Test
    void should_add_all_to_array_from_collection() {
        MyList<Object> myList = new MyArrayList<>();
        myList.add(new Object());

        List<Object> collectionToAdd = new ArrayList();
        collectionToAdd.add(new Object());
        collectionToAdd.add(new Object());

        assertTrue(myList.addAll(collectionToAdd));
        assertEquals(myList.get(1), collectionToAdd.get(0));
        assertEquals(myList.get(2), collectionToAdd.get(1));
    }

    @Test
    void should_clear_array() {
        MyList<Object> myList = new MyArrayList<>();
        myList.add(new Object());
        int expectedSize = 0;

        myList.clear();

        assertEquals(expectedSize, myList.size());
        assertNull(myList.get(0));
    }

    @Test
    void should_return_element_by_index() {
        MyList<Object> myList = new MyArrayList<>();
        Object expected = new Object();
        myList.add(expected);

        assertEquals(expected, myList.get(0));
        var exception = assertThrows(IndexOutOfBoundsException.class,
                () -> myList.get(3));
        assertEquals(exception.getMessage(), "Out of Bounds Exception");
    }

    @Test
    void should_return_index_of_element() {
        MyList<Object> myList = new MyArrayList<>();
        Object currentObject = new Object();
        myList.add(currentObject);

        int expected = 0;

        assertEquals(expected, myList.indexOf(currentObject));
    }

    @Test
    void should_check_is_array_empty() {
        MyList<Object> myList = new MyArrayList<>();

        assertTrue(myList.isEmpty());
    }


    @Test
    void should_remove_object_from_array() {
        MyList<Object> myList = new MyArrayList<>();
        Object initObject = new Object();
        Object expected = new Object();
        myList.add(initObject);
        myList.add(expected);
        int expectedSize = 1;

        assertTrue(myList.remove(initObject));

        assertEquals(expectedSize, myList.size());
        assertEquals(expected, myList.get(0));
    }

    @Test
    void should_remove_object_from_array_by_index() {
        MyList<Object> myList = new MyArrayList<>();
        Object expected1 = new Object();
        Object expected2 = new Object();
        myList.add(expected1);
        myList.add(expected2);
        int expectedSize = 1;

        assertEquals(expected1, myList.remove(0));
        assertEquals(expectedSize, myList.size());
        assertEquals(expected2, myList.get(0));
        var exception = assertThrows(IndexOutOfBoundsException.class,
                () -> myList.remove(3));
        assertEquals(exception.getMessage(), "Out of Bounds Exception");
    }

    @Test
    void should_set_element_by_index() {
        MyList<Object> myList = new MyArrayList<>();
        Object initObject = new Object();
        myList.add(initObject);
        Object expected = new Object();

        myList.set(0, expected);
        assertEquals(expected, myList.get(0));

        var exception = assertThrows(IndexOutOfBoundsException.class,
                () -> myList.set(3, expected));
        assertEquals(exception.getMessage(), "Out of Bounds Exception");
    }
}
