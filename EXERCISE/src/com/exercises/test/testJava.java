package com.exercises.test;

import java.security.Permission;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class testJava {

	// # Practice 3
	private static final Scanner scanner = new Scanner(System.in);

	// # Practice 9
	/*
	static int B;
	 
	static int H;
	static boolean flag;

	static {
		Scanner sc = new Scanner(System.in);
		B = sc.nextInt();
		H = sc.next;
		if (B > 0 && H > 0) {
			flag = true;
		} else {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
		}
	}*/
	// 9

	public static void main(String[] args) {
		// # Practice 1
		/*
		 * System.out.println("Hello, World."); System.out.println("Hello, Java.");
		 */
		// # Practice 2
		/*
		 * Scanner scan = new Scanner(System.in);
		 * System.out.println("Ingresa parametros...."); int a = scan.nextInt(); int b =
		 * scan.nextInt(); int c = scan.nextInt(); scan.close();
		 * 
		 * System.out.println("Salida 1: " + a); System.out.println("Salida 2: " + b);
		 * System.out.println("Salida 3: " + c);
		 */

		// # Practice 3
		// (numero%2==0) = es par si no cumple es impar
		/*
		 * int n = scanner.nextInt(); scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * scanner.close(); if (n%2==0) { if(n >= 2 && n <= 5) {
		 * System.out.println("Not Weird"); } else if(n >= 6 && n <= 20) {
		 * System.out.println("Weird"); } else if(n > 20) {
		 * System.out.println("Not Weird"); } } else { System.out.println("Weird"); }
		 */

		// # Practice 4
		/**
		 * int number = scanner.nextInt(); double num2 = scanner.nextDouble(); // debido
		 * a que el nextLine leee el salto de linea ese salto lo alojamos en una
		 * variable aparte para leerla siguiente cadena text String salto =
		 * scanner.nextLine(); String cadena = scanner.nextLine(); scanner.close();
		 * 
		 * System.out.println("String: " + cadena); System.out.println("Double: " +
		 * number); System.out.println("Int: " + num2);
		 * 
		 *****/

		// # Practice 5

		/*
		 * java 100 cpp 65 python 50
		 * 
		 */
		/*
		 * System.out.println("========================================" ); for(int i =
		 * 0; i < 4; i++) { String s1 = scanner.next(); int x = scanner.nextInt();
		 * System.out.printf("%-14s %03d%n", s1, x); }
		 * 
		 * System.out.println("========================================" );
		 * 
		 */

		// # Practice 6
		/*
		 * 
		 * int n = scanner.nextInt(); scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * scanner.close();
		 * 
		 * for(int i = 1; i <= 10; i++) { int oper = n*i;
		 * System.out.printf("%-1s %-1s %-1s %-1s %-1d%n", n,"x", i,"=", oper);
		 * //System.out.println(n + " x " + i + " = " + oper); }
		 */

		// # Practice 7
		/*
		 * int t = scanner.nextInt();
		 * 
		 * for(int i = 0; i < t; i++) { int a = scanner.nextInt(); int b =
		 * scanner.nextInt(); int n = scanner.nextInt(); int res = a; for(int j = 0; j <
		 * n; j++) { res += (int) (Math.pow(2, j)* b);
		 * System.out.print(Integer.toString(res) + ' '); } System.out.print('\n');
		 * 
		 * } scanner.close();
		 */

		// # Practice 7
		/* Java Solution - Java Datatypes */
		/*
		 * int t = scanner.nextInt();
		 * 
		 * for(int i = 0; i<t; i++) { try { long x = scanner.nextLong();
		 * System.out.println(x + " can be fitted in:"); if(x >= -128 && x <=
		 * 127)System.out.println("* byte"); if (x >= Short.MIN_VALUE && x <=
		 * Short.MAX_VALUE) {System.out.println("* short"); } if (x >= Integer.MIN_VALUE
		 * && x <= Integer.MAX_VALUE) {System.out.println("* int"); } if (x >=
		 * Long.MIN_VALUE && x <= Long.MAX_VALUE) {System.out.println("* long"); }
		 * }catch(Exception e) { System.out.println(scanner.next()+
		 * " can´t be fitted anywhere."); } }
		 * 
		 */

		// # Practice 8
		/* Java End-of-file */
		/*
		 * int i=1; while(scanner.hasNextLine()) { System.out.println(i + " " +
		 * scanner.nextLine()); i++; } scanner.close();
		 */

		// # Practice 9
		/* Java Static Initializer Block */
		/*
		 * if(flag) { int area = B*H; System.out.print(area); }
		 */

		// # Practice 10
		/* Java Int to String */
		
		/*
		DoNotTerminate.forbidExit();

		try {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			in.close();
			// String s=???; Complete this line below
			
			// Write your code here
			String s = String.valueOf(n);

			if (n == Integer.parseInt(s)) {
				System.out.println("Good job");
			} else {
				System.out.println("Wrong answer.");
			}
		} catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
		*/
		
		// # Practice 11
		Scanner in = new Scanner(System.in);
		double pago = in.nextDouble();
		in.close();
		      
		String us = NumberFormat.getCurrencyInstance(Locale.US).format(pago);
		String indian = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(pago);
		String china = NumberFormat.getCurrencyInstance(new Locale("zh", "CN")).format(pago);
		String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(pago);
		
		System.out.println("US: " + us);
		System.out.println("India: " + indian);
		System.out.println("China: " + china);
		System.out.println("France: " + france);
		
		// # Practice 12
		

		// # Practice 13
		
		
		// # Practice 14
		
		
		
		
		
		
		
	}

}

//# Practice 10
/* Java Int to String */
class DoNotTerminate {

	public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1;
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}
