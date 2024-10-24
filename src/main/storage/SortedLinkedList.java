package storage;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedLinkedList<T extends Comparable<? super T>> implements Iterable<T>
{
    
    private int length;
    private Node<T> head;

    public SortedLinkedList ()
    {
        length = 0;
        head = null;
    }

    private Node<T> getPrevious (T entry)
    {
        Node<T> temp = head;
        while (temp != null)
        {
            if (temp.getLink().getData().compareTo(entry) == 0)
            {
                return temp;
            }
            temp = temp.getLink();
        }
        return null;
    }

    public int getPosition (T entry) throws IllegalArgumentException
    {
        int position = 0;
        Node<T> temp = head;
        while (temp != null)
        {
            if (temp.getData() == entry)
            {
                return position;
            }
            position++;
            temp = temp.getLink();
        }
        throw new IllegalArgumentException();
    }

    public void display ()
    {
        Node<T> temp = head;
        while (temp != null)
        {
            System.out.print(temp.getData().toString() + " ");
            temp = temp.getLink();
        }
        System.out.println();
    }

    public void add (T entry) 
    {
        if (length == 0)
        {
            head = new Node<T>(entry);
        }
        else if (entry.compareTo(head.getData()) < 0)
        {
            head = new Node<T>(entry, head);
        }
        else
        {
            Node<T> temp = head;
            while (temp.getLink() != null)
            {
                if (entry.compareTo(temp.getLink().getData()) < 0)
                {
                    break;
                }
                temp = temp.getLink();
            }
            temp.setLink(new Node<T>(entry, temp.getLink()));
        }
        length++;
    }

    public T remove (int position)
    {
        Node<T> data;
        if (position == 0)
        {
            data = head;
            head = head.getLink();
        }
        else
        {
            Node<T> temp = head;
            for(int i = 0; i < position - 1; i++)
            {
                temp = temp.getLink();
                if (temp == null)
                {
                    return null;
                }
            }
            data = temp.getLink();
            if (temp.getLink() != null && temp.getLink().getLink() != null)
            {
                temp.setLink(temp.getLink().getLink());
            }
            else if (temp.getLink() != null)
            {
                temp.setLink(null);
            }
            else
            {
                return null;
            }
        }
        length--;
        return data.getData();
    }

    public int getLength ()
    {
        return length;
    }

    public void clear ()
    {
        head = null;
        length = 0;
    }

    public boolean isEmpty ()
    {
        return length == 0;
    }

    public boolean contains (T entry)
    {
        Node<T> temp = head;
        while (temp != null)
        {
            if( temp.getData() == entry)
            {
                return true;
            }
            temp = temp.getLink();
        }
        return false;
    }

    public Iterator<T> iterator ()
    {
        return new SLLIterator(head);
    }

    public T getEntry (int entry)
    {
        Node<T> temp = head;
        for(int i = 0; i < entry; i++)
        {
            temp = temp.getLink();
        }
        return temp.getData();
    }


    private class SLLIterator implements Iterator<T>
    {
        private boolean calledNext;
        private Node<T> prevNode;
        private Node<T> currNode;
        private Node<T> nextNode;

        public SLLIterator(Node<T> firstNode)
        {
            prevNode = null;
            currNode = null;
            nextNode = firstNode;
        }

        public boolean hasNext () 
        {
            return nextNode != null;
        }

        public T next () throws NoSuchElementException
        {
            if (hasNext())
            {
                calledNext = true;
                prevNode = currNode;
                currNode = nextNode;
                nextNode = nextNode.getLink();

                return currNode.getData();
            }
            throw new NoSuchElementException();
        }

        public void remove () throws IllegalStateException
        {
            if (!calledNext) 
            {
                throw new IllegalStateException();
            }
            if (currNode == head)
            {
                head = head.getLink();
            }
            if (prevNode != null)
            {
                prevNode.setLink(nextNode);
                currNode = prevNode;
            }
            calledNext = false;
            length--;
        }
    }

}

