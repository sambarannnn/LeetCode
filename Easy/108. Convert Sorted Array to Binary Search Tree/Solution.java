/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recursivesortedArrayToBST(int arr[], int start, int end) {
  
        /* Base Case */
        if (start > end) {
            return null;
        }
  
        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
  
        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = recursivesortedArrayToBST(arr, start, mid - 1);
  
        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = recursivesortedArrayToBST(arr, mid + 1, end);
          
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        //creates balanced BST using binary search algorithm
        return recursivesortedArrayToBST(nums, 0, nums.length-1);
    }
}
