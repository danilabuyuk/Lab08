package storage;

public class Node<T>
{

    private Object data;
    private Node<T> link;

    public Node (Object data, Node<T> link)
    {
        this.data = data;
        this.link = link;
    }

    public Node (Object data)
    {
        this(data, null);
    }

    public Node ()
    {
        this(null, null);
    }

    public Node<T> getLink ()
    {
        return link;
    }

    public void setLink (Node<T> link)
    {
        this.link = link;
    }

    public Object getData ()
    {
        return data;
    }

    public void setData (Object data)
    {
        this.data = data;
    }

}
