package java4.fun.patterns.decorator;

public class ConsolePrinter {
	
	public static void print(Decorator resource){		
		System.out.println(resource.provideResource());
	}
	
}
