/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package investigation;

/**
 *
 * @author LAB-USR-AREQUIPA
 */


    class INVESTIGATION{
    
    static int binarySearch(int a[], int l, int r, int x){
        
        while (l <= r){
            
            int m = (l + r) / 2;

            // Index of Element Returned
            if (a[m] == x) {
                return m;

                // If element is smaller than mid, then
                // it can only be present in left subarray
                // so we decrease our r pointer to mid - 1
            }
            else if (a[m] > x) {
                r = m - 1;

                // Else the element can only be present
                // in right subarray
                // so we increase our l pointer to mid + 1
            }
            else {
                l = m + 1;
            }
        }

        // No Element Found
        return -1;
    }

    public static void main(String args[])
    {

        int a[] = { 2, 3, 4, 10, 40 };
        int n = a.length;
        int x = 10;

        int res = binarySearch(a, 0, n - 1, x);

        System.out.println("El elemento a buscar es : "
                           + x);

        if (res == -1)
            System.out.println(
                "El elemento no está no está presente en la matriz");
        else
            System.out.println(
                "El elemento está presente en el índice " + res);
    }
}
