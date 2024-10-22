package storage;

import java.util.Iterator;

public class SortedLinkedList<T> implements Iterable
{
    
    private int length;
    private Node head;

    public SortedLinkedList ()
    {
        length = 0;
        head = null;
    }

    private Node getPrevious (Comparable<T> object)
    {
        return head;
    }

    public int getPosition (Comparable<T> object)
    {
        return length;
    }

    public  void display ()
    {

    }

    public void add (Comparable<T> object) 
    {

    }

    public  Comparable<T> remove (int num)
    {
        return null;
    }

    public int getLength ()
    {
        return length;
    }

    public void clear ()
    {

    }

    public boolean isEmpty ()
    {
        return true;
    }

    public boolean contains (Comparable<T> object)
    {
        return true;
    }

    public Iterator<T> iterator ()
    {
        return null;
    }

    public Comparable<T> getEntry (int entry)
    {
        return null;
    }

    private class SLLIterator implements Iterator
    {
        private boolean calledNext;
        private Node<T> prevNode;
        private Node<T> currNode;
        private Node<T> nextNode;

        public SLLIterator(Node<T> firstNode)
        {

        }

        public boolean hasNext ()
        {
            return true;
        }

        public Comparable<T> next ()
        {
            return null;
        }

        public void remove ()
        {

        }
    }

}

