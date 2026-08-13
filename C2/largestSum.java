package C2;

import java.util.Scanner;

public class largestSum {
    public static void main(String[] args) {

        Scanner scn= new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scn.nextInt();

        // screate integer array to store input
        int[] a = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i=0; i < n; i++){
            a[i] =scn.nextInt(); // store each input value in the array

        }

        // calculate and print contiguous sum
        System.out.println("Maximum contiguous sum is: "+ maxSumArray(a));
        
    }

    // method to calculate max sum of contiguous subarray
    static int maxSumArray(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE , max_ending_here = 0;

        // loop through array to calculate max sum
        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];

            // update maximum sum
            if (max_so_far < max_ending_here) 
            max_so_far = max_ending_here;

            if (max_ending_here < 0)
            max_ending_here = 0;
        
            }

            return max_so_far;
        }
    }
    

