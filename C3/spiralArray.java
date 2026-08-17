package C3;

import java.util.Scanner;

public class spiralArray {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        // enter number of rows and columns
        System.out.print("Enter number of rows: ");
        int n = scn.nextInt();
        System.out.print("Enter number of columns: ");
        int m = scn.nextInt();

        // handle case where aray dimensions are 0
        if (n==0 || m==0) {
            System.out.println("Array dimensions cannot be zero.");
            return;
        }

        //create a 2d array to store the elements 
        int[][] arr = new int[n][m];

        // ask the user to enteer the elemets of the 2d Array
        System.out.println("Enter the elements of the 2D array: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = scn.nextInt(); //store inputs in array
            }
        }

        // Initialize boundaries for the spiral traversal
        int rmin = 0, cmin=0, rmax= n-1, cmax = m-1;
        int count = 0;

        // strart the spiral travarsal
        System.out.println("Spiral order traversal of the array: ");
        while(count < n*m) {
            // traver the top row
            for (int col = cmin; col <= cmax && count < n*m; col++) {
                System.out.print(arr[rmin][col] + " ");
                count++;
            }
            rmin++;

            // traverse the right colums
            for (int row = rmin; row <= rmax && count < n*m; row++) {
                System.out.print(arr[row][cmax] + " ");
                count++;
            }
            cmax--;
        }
        // traverse te bottom row
        for (int col = cmax; col>= cmin && count < n*m; col--) {
            System.out.print(arr[rmax][col] + " ");
            count++;
        }
        rmax--;

        // traverse the left column
        for (int row = rmax; row >= rmin && count <n*m; row--) {
            System.out.print(arr[row][cmin] + " ");
            count++;
        }
        cmin++;
    }
    
}
