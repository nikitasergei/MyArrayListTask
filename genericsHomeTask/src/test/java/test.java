

import contanier.MyArrayList;
import contanier.MyArrayListException.MyArrayListException;
import org.junit.Assert;
import org.junit.Test;


public class test {


    @Test
    public void pushTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>(3);
        mList.pushBack("One");
        mList.pushBack("Two");
        mList.pushFront("Two");
        mList.pushFront("Ten");
        Assert.assertNotNull(mList.getElementAt(0));
        Assert.assertNotNull(mList.getElementAt(2));
        Assert.assertNotNull(mList.getElementAt(1));
        Assert.assertNotNull(mList.getElementAt(3));
    }

    @Test
    public void popBackTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>(1);
        mList.pushBack("One");
        mList.pushBack("Two");
        Assert.assertNotNull(mList.getElementAt(0));
        Assert.assertNotNull(mList.getElementAt(1));
        mList.popBack();
        Assert.assertNull(mList.getElementAt(1));
    }

    @Test
    public void popFrontTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>(1);
        mList.pushBack("One");
        mList.pushFront("Two");
        Assert.assertNotNull(mList.getElementAt(1));
        mList.popFront();
        Assert.assertNotEquals("Two", mList.getElementAt(0));
    }

    @Test
    public void insertTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>(2);
        mList.pushBack("One");
        mList.pushFront("Two");
        mList.insert("Insert", 1);
        Assert.assertEquals(mList.getElementAt(1), "Insert");

    }

    @Test
    public void removeAtTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>(2);
        mList.pushBack("One");
        mList.pushFront("Two");
        mList.insert("Insert", 1);
        Assert.assertEquals(mList.getElementAt(1), "Insert");
        mList.removeAt(1);
        Assert.assertNotEquals(mList.getElementAt(1), "Insert");

    }

    @Test
    public void removeTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>(2);
        mList.pushBack("One");
        mList.pushFront("Two");
        mList.pushFront("One");
        mList.insert("Insert", 1);
        mList.remove("One");
        Assert.assertNotEquals(mList.getElementAt(0), "One");
        Assert.assertEquals(mList.getElementAt(2), "One");

    }

    @Test
    public void removeAllTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>(2);
        mList.pushBack("One");
        mList.pushFront("Two");
        mList.pushFront("One");
        mList.insert("Insert", 1);
        mList.removeAll("One");
        Assert.assertNotEquals(mList.getElementAt(0), "One");
        Assert.assertNotEquals(mList.getElementAt(2), "One");

    }

    @Test
    public void clearTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>(2);
        mList.pushBack("One");
        mList.pushFront("Two");
        mList.pushFront("One");
        mList.insert("Insert", 1);
        mList.clear();
        Assert.assertNull(mList.getElementAt(0));
        Assert.assertNull(mList.getElementAt(1));
        Assert.assertNull(mList.getElementAt(2));
        Assert.assertNull(mList.getElementAt(3));

    }

    @Test
    public void isEmptyTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>(3);
        Assert.assertTrue(mList.isEmpty());
    }

    @Test
    public void trimToSizeTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>(2);
        mList.pushBack("One");
        mList.pushFront("Two");
        mList.pushFront("One");
        mList.pushFront(null);
        mList.pushFront(null);
        mList.trimToSize();

    }

    @Test
    public void indexOfTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>();
        mList.pushBack("One");
        mList.pushFront("Two");
        mList.pushFront("One");
        mList.pushFront("Two");
        mList.pushFront("Four");
        mList.pushFront("Five");
        Assert.assertEquals(mList.indexOf("Two"), 2);
        Assert.assertNotEquals(mList.indexOf("Two"), 4);

    }

    @Test
    public void lastIndexOfTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>();
        mList.pushBack("One");
        mList.pushFront("Two");
        mList.pushFront("One");
        mList.pushFront("Two");
        mList.pushFront("Four");
        mList.pushFront("Five");
        Assert.assertEquals(mList.lastIndexOf("Two"), 4);
        Assert.assertNotEquals(mList.lastIndexOf("Two"), 2);

    }

    @Test
    public void reversTest() throws MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>();
        mList.pushBack("One");
        mList.pushFront("Two");
        mList.pushFront("Three");
        mList.pushFront("Four");
        mList.pushFront("Five");
        Assert.assertEquals(("One"), mList.getElementAt(4));
        Assert.assertEquals(("Two"), mList.getElementAt(3));
        Assert.assertEquals(("Three"), mList.getElementAt(2));
        Assert.assertEquals(("Four"), mList.getElementAt(1));
        Assert.assertEquals(("Five"), mList.getElementAt(0));
        mList.reverse();
        Assert.assertEquals(("One"), mList.getElementAt(0));
        Assert.assertEquals(("Two"), mList.getElementAt(1));
        Assert.assertEquals(("Three"), mList.getElementAt(2));
        Assert.assertEquals(("Four"), mList.getElementAt(3));
        Assert.assertEquals(("Five"), mList.getElementAt(4));
    }

    @Test
    public void cloneTest() throws CloneNotSupportedException, MyArrayListException {
        MyArrayList<String> mList = new MyArrayList<>();
        mList.pushBack("One");
        mList.pushFront("Two");
        MyArrayList<String> mListClone = null;
        try {
            mListClone = (MyArrayList<String>) mList.clone();
            Assert.assertTrue(mList.equals(mListClone));
            System.out.println(mList.hashCode());
            System.out.println(mList.toString());
            System.out.println(mListClone.hashCode());
            System.out.println(mListClone.toString());
        } catch (CloneNotSupportedException exception) {
            exception.printStackTrace();
        }

    }
}