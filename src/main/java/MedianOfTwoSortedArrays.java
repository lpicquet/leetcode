/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/?source=submission-ac
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double lengthToMerge = Math.ceil((nums1.length + nums2.length +1 ) /2f);
        boolean isEven = (nums1.length + nums2.length) % 2 == 0;

        System.out.println(String.format("selecting up to index %f (excluded) items", lengthToMerge));
        int nums1_index = 0;
        int nums2_index = 0;
        int[] merged = new int[(int)lengthToMerge];

        for (int i=0; i<lengthToMerge; i++){
            System.out.println(String.format("selecting sorted item %d.", i));
            System.out.println(String.format("index %d out of %d (nums1)", nums1_index, nums1.length -1));
            System.out.println(String.format("index %d out of %d (nums2)", nums2_index, nums2.length -1));
            if (hasRunOutOfItems(nums2, nums2_index) || (!hasRunOutOfItems(nums1, nums1_index) && nums1[nums1_index] < nums2[nums2_index])){
                int selectedNumber = nums1[nums1_index];
//                System.out.println(String.format("%d selected (nums1)", selectedNumber));
                merged[i] = selectedNumber;
                nums1_index++;
            } else {
//                if (hasRunOutOfItems(nums1, nums1_index)){
//                    System.out.println("nums1 has run out of items");
//                }
                int selectedNumber = nums2[nums2_index];
//                System.out.println(String.format("%d selected (nums2)", selectedNumber));
                merged[i] = selectedNumber;
                nums2_index++;
            }
        }
        // we either take the last of the average of the last 2
        double median;
        if (isEven){
            median = (merged[merged.length -1] + merged[merged.length -2] ) / 2d;
        } else {
            median = merged[merged.length -1];
        }

        return median;

    }

    private static boolean hasRunOutOfItems(int[] nums2, int nums2_index) {
        return nums2_index >= nums2.length;
    }
}
