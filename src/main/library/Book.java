package library;

public class Book implements Comparable<Book> 
{

    private String author;
    private String title;
    private int numPages;

    public Book (String author, String title, int numPages) 
    {
        this.author = author;
        this.title = title;
        this.numPages = numPages;
    }

    public String getAuthor () 
    {
        return author;
    }

    public String getTitle ()
    {
        return title;
    }

    public int getNumPages ()
    {
        return numPages;
    }

    public boolean equals (Object b1)
    {
        Book b2 = (Book) b1;
        return this.author.equals(b2.author)
            && this.title.equals(b2.title);
    }

    public int compareTo (Book b2)
    {
        if (this.author.equals(b2.author))
        {
            if (this.title.equals(b2.title))
            {
                return 0;
            }
            else
            {
                return this.title.compareTo(b2.title);
            }
        }
        else
        {
            return this.author.compareTo(b2.author);
        }
    }

    public String toString ()
    {
        return author + ", " + title + ", " + numPages;
    }
}
