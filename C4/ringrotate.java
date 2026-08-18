package C4;

import java.util.Scanner;

public class ringrotate {
    // main method 
    public static void main(String[] args) {
        
        // create a scaner object ot read input
        Scanner scn = new Scanner(System.in);

        // prompt user to enter rows and columns
        System.out.print("Enter the number of rows: ");

        int n = scn.nextInt() ;

        System.out.print("Enter the number of columns: ");

        int m = scn.nextInt() ;

        // create a 2D array to store the matrix elements
        int[][] arr = new int[n][m] ;

        // prompt the user to enter the elements of the matrix
        System.out.println("Enter the elements of the "+n+"x"+m+" matrix:");
        for (int i = 0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = scn.nextInt(); //store elements
            }
        }

        // prompt user to ener the ring number and the rotation number 
        System.out.print("Enter the ring number (sno): ");

        int sno = scn.nextInt();

        System.out.print("Enter the number of rotation (rno): ");

        int rno = scn.nextInt();

        // call the ring rotation function
        ringrotate(arr, sno, rno);

        // display updated matrix
        display(arr);
    }

    // function to perform the rotation of a specified ring
    public static void ringrotate(int[][] arr, int sno, int rno){
        // convert the 2D ring into a 1D array
        int[] la = fill1Dfrom2D(arr, sno);

        //rotate 1D rray
        rotate1D(la, rno);

        // fill the 2d array back from the 1D array
        fill2Dfrom1D(arr, la, sno);
    }
    // function to convert the 2D ring to a 1D array

    public static int[] fill1Dfrom2D(int[][] arr, int sno){
        int rmin = sno -1;
        int cmin = sno-1;
        int rmax = arr.length - sno;

        int cmax = arr[0].length - sno;
        // total size of the ring
        int sz = 2*(rmax - rmin + cmax - cmin);

        int[] la = new int[sz];
        int idx = 0;

        // traverse the ring and fill the 1D array
        for (int row = rmin; row <= rmax; row++){
            la[idx] = arr[row][cmin];
            idx++;
        }
        cmin++;

        for (int col = cmin; col <= cmax; col++){
            la[idx] = arr[rmax][col];
            idx++;
        }
        rmax--;

        for (int row = rmax; row >= rmin; row--){
            la[idx] = arr[row][cmax];
            idx++;
        }
        cmax--;
        
        for (int col = cmax; col >= cmin; col--){
            la[idx] = arr[rmin][col];
            idx++;
        }
        rmin++;

        return la;
    }

    // function to rotatte the 1D array bu the givennumber of sreps
    public static void rotate1D(int[] la, int rno){
        rno = rno % la.length;

        if (rno < 0){
            rno += la.length;
        }

        reverse(la, 0, la.length-1);
        reverse(la, 0 , rno -1);
        reverse(la, rno, la.length-1);
    }

    // function to reverse a portion of aray
    public static void reverse(int[] la, int left, int right){
        while (left< right){
            int temp = la[left];
            la[left] = la[right];
            la[right] = temp;
            left++;
            right++;
        }
    }

    // function to fill 2D array back into the 1D array after rotation
    public static void fill2Dfrom1D(int[][] arr, int[] la, int sno){

        int rmin = sno-1;
        int cmin = sno-1;
        int rmax = arr.length - sno;
        int cmax = arr[0].length - sno;
        int idx = 0;

        // traverse the ring and restore rotated elements (must follow same path as fill1Dfrom2D)
        // 1. Left boundary (top to bottom)
        for (int row = rmin; row <= rmax; row++) {
            arr[row][cmin] = la[idx];
            idx++;
        }
        cmin++;

        // 2. Bottom boundary (left to right)
        for (int col = cmin; col <= cmax; col++) {
            arr[rmax][col] = la[idx];
            idx++;
        }
        rmax--;

        // 3. Right boundary (bottom to top)
        for (int row = rmax; row >= rmin; row--) {
            arr[row][cmax] = la[idx];
            idx++;
        }
        cmax--;

        // 4. Top boundary (right to left)
        for (int col = cmax; col >= cmin; col--) {
            arr[rmin][col] = la[idx];
            idx++;
        }
        rmin++;
    }

    // function to display the matrix
    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
