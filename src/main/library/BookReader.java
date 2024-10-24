package library;

import java.util.Scanner;
import java.io.File;
import java.util.Iterator;
import storage.SortedLinkedList;

public class BookReader 
{

    private Scanner fileIn;
    private SortedLinkedList<Book> books;
    
    public BookReader (String filepath)
    {
        books = new SortedLinkedList<Book>();
        try 
        {
            setFileIn(new Scanner(new File(filepath)));
        } 
        catch (Exception e) 
        {

        }
        readLines();
        fileIn.close();
    }

    public void setFileIn (Scanner fileIn) 
    {
        this.fileIn = fileIn;
    }

    public void readLines ()
    {
        String[] line;
        Book temp;
        while(fileIn.hasNext())
        {
            line = fileIn.nextLine().split(",");
            temp = new Book(line[0], line[1], Integer.parseInt(line[2]));
            books.add(temp);
        }
    }

    public SortedLinkedList<Book> getBooks ()
    {
        return books;
    }

    public void printMoreThan300 () 
    {
        for (Book temp : books)
        {
            if (temp.getNumPages() > 300)
            {
                System.out.println(temp.toString());
            }
        }
    }

    public double averagePages ()
    {
        double pages = 0;
        for (Book temp : books)
        {
            pages += temp.getNumPages();
        }
        return (pages / books.getLength());
    }

    public void removeLessThan200 ()
    {
        Iterator<Book> temp = books.iterator();
        Book book;
        while (temp.hasNext())
        {
            book = temp.next();
            if (book.getNumPages() < 200)
            {
                temp.remove();
            }
        }
    }
}
