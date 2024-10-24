package client;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import library.Book;
import library.BookReader;
import storage.SortedLinkedList;

/**
 * Demo used to manually test the program.
 * 
 * @author 
 * @version 
 */
public class Demo
{
	/**
     * Runs the demo.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) 
    {
        SortedLinkedList<String> seq = new SortedLinkedList<String>();
        seq.add("January");
        seq.add("February");
        seq.add("March");
        seq.add("April");
        seq.add("May");
        seq.add("July");
        seq.add("June");
        seq.add("August");
        seq.add("September");
        String correct = "April August February January July June March May "
                + "September \n";
        PrintStream stdout = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        seq.display();
        System.setOut(stdout);

        String output = outContent.toString();
        System.out.println(output.compareTo(correct));
    }
}
