
public class ArthamaticExceptions_demo {
	public static void main(String args[]) {
		int a=10;
		int b=0;
		try
		{
			
			int c=a/b;
			System.out.println("hello");
		}
			catch(ArithmeticException e) {
				System.out.println("A number cant divide by zero");
				
			}
		System.out.println(a/(b+2));
		}
		
	}


