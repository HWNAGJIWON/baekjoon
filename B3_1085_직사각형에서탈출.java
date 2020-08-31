

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int  x,y,w,h;
		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		
		int min=x;
		if(h-y < min)
			min = h-y;
		if(w-x < min)
			min = w-x;
		if(y < min)
			min = y;
		System.out.println(min);
	}
}

