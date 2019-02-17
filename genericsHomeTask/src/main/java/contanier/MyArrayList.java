package contanier;

import contanier.Interfaces.*;
import contanier.MyArrayListException.MyArrayListException;
import contanier.MyArrayListException.MyArrayListNullPointException;

import java.util.Arrays;

public class MyArrayList<E> implements Task2Methods, Task3Methods<E>, Task4Methods<E>, Task5Methods, Task6Methods<E>, Cloneable {
    private E[] data;
    private int size = 0;
    private int capacity;


    public MyArrayList(int capacity) throws MyArrayListException {
        if (capacity > 0) {
            this.capacity = capacity;
            this.data = (E[]) new Object[this.capacity];
            this.size = 0;
        } else throw new MyArrayListNullPointException();
    }


    public MyArrayList() throws MyArrayListException {
        this(10);
    }

    //Task2

    /**
     * @return number of array's elements
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @return name of array's elements like a String value
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < this.data.length; i++) {
            str = str + this.data[i] + " ";
        }
        return str;
    }

    /**
     * @param checkCapacity - checked value
     * @return true if checkCapacity is bigger than array's capacity, else create array with capacity
     * which bigger than last one, and return true
     */
    public boolean ensureCapacity(int checkCapacity) {
        if (checkCapacity > this.data.length) {
            try {
                E[] tempData = this.data;
                this.capacity = (int) (this.capacity * 1.5 + 1);
                this.data = (E[]) new Object[this.capacity];
                System.arraycopy(tempData, 0, this.data, 0, tempData.length);
                System.out.println(this.capacity);
                return true;
            } catch (ClassCastException exception) {
                exception.printStackTrace();
            }
        }
        return true;
    }

    //Task 3

    /**
     * @param obj - object, which need to push on.
     *            This method push obj in the end of array
     */
    public void pushBack(E obj) {
        if (this.size < this.capacity) {
            this.data[this.size] = obj;
            this.size++;
        } else {
            try {
                E[] tempData = this.data;
                this.capacity = this.capacity + 1;
                this.data = (E[]) new Object[this.capacity];
                System.arraycopy(tempData, 0, this.data, 0, tempData.length);
                this.data[this.size] = obj;
                this.size++;
            } catch (ClassCastException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * This method delete the first element of array
     */
    public void popFront() {
        if (this.size > 0) {
            System.arraycopy(this.data, 1, this.data, 0, this.data.length - 1);
            this.data[this.size - 1] = null;
            this.size--;
        } else throw new NullPointerException();
    }

    /**
     * @param obj - object, which need to push on.
     *            This method push obj like a first element of array
     */
    public void pushFront(E obj) {
        if (this.size < this.capacity) {
            System.arraycopy(this.data, 0, this.data, 1, this.size);
            this.data[0] = obj;
            this.size++;
        } else {
            try {
                E[] tempData = this.data;
                this.capacity = this.capacity + 1;
                this.data = (E[]) new Object[this.capacity];
                System.arraycopy(tempData, 0, this.data, 1, tempData.length);
                this.data[0] = obj;
                this.size++;
            } catch (ClassCastException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * @param obj      - object to insert
     * @param position - position to insert object
     *                 This method insert obj in array to the specified position
     */
    public void insert(E obj, int position) {
        if (position < 0 || position > this.capacity)
            throw new NullPointerException();
        if (this.size == this.capacity) {
            this.capacity++;
            this.size++;
        }
        try {
            E[] tempData = this.data;
            this.data = (E[]) new Object[this.capacity];
            System.arraycopy(tempData, 0, this.data, 0, position);
            this.data[position] = obj;
            System.arraycopy(tempData, position, this.data, position + 1, (tempData.length - position));
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @param position - position to remove object
     *                 This method remove object from the specified position
     */
    public void removeAt(int position) {
        if (position < 0 || position > this.capacity - 1) {
            throw new NullPointerException();
        } else {
            if (position == 0) {
                popFront();
            } else {
                if (position == this.data.length - 1) {
                    this.data[data.length - 1] = null;
                } else try {
                    E[] tempData = this.data;
                    this.data = (E[]) new Object[this.capacity];
                    System.arraycopy(tempData, 0, this.data, 0, position);
                    System.arraycopy(tempData, position + 1, this.data, position, tempData.length - (position + 1));
                } catch (ClassCastException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    /**
     * This method remove the first find the specified object
     */
    public boolean remove(E obj) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i].equals(obj)) {
                System.arraycopy(this.data, i + 1, this.data, i, this.data.length - i - 1);
                this.size--;
                return true;
            }
        }
        return false;
    }

    /**
     * @param obj - objects to remove
     *            This method removes all specified objects from array
     */
    public void removeAll(E obj) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == (obj)) {
                System.arraycopy(this.data, i + 1, this.data, i, this.data.length - i - 1);
                i = 0;
                this.size--;
                this.data[this.data.length - 1] = null;
            }
        }
    }

    /**
     * This method delete the last element of array
     */
    public void popBack() {
        this.data[this.size - 1] = null;
        this.size--;
    }

    /**
     * This method make array's values equals null
     */
    public void clear() {
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = null;
        }
        this.size = 0;
    }

    // Task4

    /**
     * @return true if array is Empty and otherwise return false
     */
    public boolean isEmpty() {
        if (this.size == 0)
            return true;
        else return false;
    }

    /**
     * This method deletes all array's last  elements with null values
     */
    public void trimToSize() {
        if (this.capacity > this.size) {
            this.capacity = this.size;
            try {
                E[] tempData = this.data;
                this.data = (E[]) new Object[this.capacity];
                System.arraycopy(tempData, 0, this.data, 0, this.size);
            } catch (ClassCastException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * @param obj - object to search
     * @return the first index of found object in array, and -1 if object wasn't found
     */
    public int indexOf(E obj) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == obj)
                return i;
        }
        return -1;
    }

    /**
     * @param obj - object to search
     * @return the last index of found object in array, and -1 if object wasn't found
     */
    public int lastIndexOf(E obj) {
        for (int i = this.data.length - 1; i >= 0; i--) {
            if (this.data[i] == obj)
                return i;
        }
        return -1;
    }

    //Task 5

    /**
     * Reordering of elements in an array on the opposite
     */
    public void reverse() {
        trimToSize();
        try {
            E[] tempData = this.data;
            this.data = (E[]) new Object[this.capacity];
            this.size = 0;
            for (int i = 0; i < this.capacity; i++) {
                pushFront(tempData[i]);

            }
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * random mixing of array elements
     */
    public void shuffle() {
        trimToSize();
        try {
            E[] tempData = this.data;
            this.data = (E[]) new Object[this.capacity];
            for (int i = 0; i < this.capacity; i++) {
                while (true) {
                    int random = (int) (Math.random() * size);
                    if (this.data[random] == null) {
                        this.data[random] = tempData[i];
                        break;
                    } else continue;
                }
            }
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
    }

    //Task 6

    /**
     * @param index - index to return value
     * @return value of array's element with the specified index
     */
    public E getElementAt(int index) {
        if (index < 0 || index > this.capacity)
            throw new NullPointerException();
        else return this.data[index];
    }

    /**
     * @param object - object to compare
     * @return true if object equals the specified object and false if it's not
     */
    public boolean equals(MyArrayList object) {
        if (this.size == object.size) {
            if (Arrays.deepEquals(this.data, object.data))
                return true;
            else return false;
        } else return false;
    }

    /**
     * @return link on copy of MyArrayList, else return null
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
