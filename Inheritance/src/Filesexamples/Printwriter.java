package Filesexamples;
import java.io.*;
public class Printwriter {
	public static void main(String[] args) {
		PrintWriter obj=new PrintWriter(System.out);
		obj.write("Enter your Name\n");
		System.err.print("Rajesh");
		obj.flush();
	}
}
