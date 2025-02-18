// Approach 2
// - **Initialize two pointers**, i and j, both initially set to 0.
// - **Move the pointer** that corresponds to the **smaller value forward at each step.**
// - Continue moving the pointers **until you have processed half of the total number of elements.**
// - Calculate and **return the median** based on the values pointed to by i and j.

// **Time Complexity**

// - **O(n + m)**, where ‘n’ & ‘m’ are the sizes of the two arrays.

// **Space Complexity**

// - **O(1)**.
class TwoPointerMethod {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            double ans = (double) m1 + (double) m2;
            return ans / 2.0;
        }
    }
}