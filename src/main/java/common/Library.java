
package common;

import java.util.Scanner;


public class Library {
    protected Scanner sc;
    public Library(){
        sc  = new Scanner(System.in);
    }
    
    public String getString(String mes){
        System.out.println(mes);
        return sc.nextLine();
    }
    
    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
                System.out.print("Enter again: ");
            }
        }
        return a;
    }       
    //check user input double limit
    public double checkInputDouble(String promt) {
        //loop until user input correct
        while (true) {
            System.out.print(promt + ": ");
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number double");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String checkInputOperator() {
        //loop until user input correct
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else if (result.equalsIgnoreCase("+") || result.equalsIgnoreCase("-")
                    || result.equalsIgnoreCase("*") || result.equalsIgnoreCase("/")
                    || result.equalsIgnoreCase("^") || result.equalsIgnoreCase("=")) {
                return result;
            } else {
                System.err.println("Please input (+, -, *, /, ^)");
            }
            System.out.print("Enter again: ");
        }
    }
}