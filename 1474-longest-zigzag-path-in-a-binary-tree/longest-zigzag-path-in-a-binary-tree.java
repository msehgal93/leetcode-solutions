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
    // Global variable to track the maximum zigzag path length
    private int maxZigZagLength;

    /**
     * Finds the longest zigzag path in a binary tree.
     * A zigzag path alternates between left and right child nodes.
     * 
     * @param root The root node of the binary tree
     * @return The length of the longest zigzag path
     */
    public int longestZigZag(TreeNode root) {
        maxZigZagLength = 0;
        // Start DFS traversal with initial left and right counts as 0
        dfs(root, 0, 0);
        return maxZigZagLength;
    }

    /**
     * Performs depth-first search to calculate zigzag paths.
     * 
     * @param node The current node being processed
     * @param leftCount The length of zigzag path if we came from right (going left next)
     * @param rightCount The length of zigzag path if we came from left (going right next)
     */
    private void dfs(TreeNode node, int leftCount, int rightCount) {
        // Base case: if node is null, return
        if (node == null) {
            return;
        }
      
        // Update the maximum zigzag length found so far
        maxZigZagLength = Math.max(maxZigZagLength, Math.max(leftCount, rightCount));
      
        // Traverse left child:
        // - If we go left, the previous zigzag came from right, so pass rightCount + 1
        // - Reset the other direction to 0 since we're starting a new path
        dfs(node.left, rightCount + 1, 0);
      
        // Traverse right child:
        // - If we go right, the previous zigzag came from left, so pass leftCount + 1
        // - Reset the other direction to 0 since we're starting a new path
        dfs(node.right, 0, leftCount + 1);
    }
}