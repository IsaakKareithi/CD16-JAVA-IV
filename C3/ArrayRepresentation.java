package C3;

import java.util.Scanner;   

public class ArrayRepresentation {
    // main method
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        
        // prompt user to enter no. of rows
        System.out.print("Enter the number of rows: ");
        int n = scn.nextInt();

        System.out.print("Enter the number of columns: ");
        int m = scn.nextInt();

        // create a 2D array with n rows and m columns
        int[][] arr = new int[n][m];

        // prompt user to enter the elemnts of the 2D array
        System.out.println("Enter the elements of the 2D array: ");
        for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            arr[i][j] =scn.nextInt(); // store each element in the array
        }
        }

        // print the 2D array in matrix format
        System.out.println("The entered 2D array is: ");
        for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            System.out.println(arr[i][j]+ " ");
        }
        System.out.println(); // print a new line after each row
    }
    }
}
