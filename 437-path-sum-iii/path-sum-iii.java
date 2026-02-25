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
    
    // HashMap to store the frequency of prefix sums
    // Key: prefix sum, Value: count of paths with this sum
    private Map<Long, Integer> prefixSumCount = new HashMap<>();
    private int targetSum;
  
    /**
     * Finds the number of paths in a binary tree that sum to targetSum.
     * Paths can start and end at any node (must go downwards).
     * 
     * @param root The root of the binary tree
     * @param targetSum The target sum to find
     * @return The number of paths that sum to targetSum
     */
    public int pathSum(TreeNode root, int targetSum) {
        // Initialize with prefix sum 0 having count 1
        // This handles paths starting from the root
        prefixSumCount.put(0L, 1);
        this.targetSum = targetSum;
      
        // Start DFS traversal from root with initial sum 0
        return dfs(root, 0);
    }
  
    /**
     * Performs depth-first search to count paths with the target sum.
     * Uses prefix sum technique to find paths efficiently.
     * 
     * @param node Current node being processed
     * @param currentPrefixSum Sum of all nodes from root to current node's parent
     * @return Number of valid paths in the subtree rooted at this node
     */
    private int dfs(TreeNode node, long currentPrefixSum) {
        // Base case: null node contributes 0 paths
        if (node == null) {
            return 0;
        }
      
        // Update prefix sum to include current node
        currentPrefixSum += node.val;
      
        // Check if there exists a prefix sum such that
        // currentPrefixSum - prefixSum = targetSum
        // This means the path from that prefix to current node sums to targetSum
        int pathCount = prefixSumCount.getOrDefault(currentPrefixSum - targetSum, 0);
      
        // Add current prefix sum to the map for use by descendant nodes
        prefixSumCount.merge(currentPrefixSum, 1, Integer::sum);
      
        // Recursively explore left and right subtrees
        pathCount += dfs(node.left, currentPrefixSum);
        pathCount += dfs(node.right, currentPrefixSum);
      
        // Backtrack: remove current prefix sum from map
        // This ensures the prefix sum is only available to current node's descendants
        prefixSumCount.merge(currentPrefixSum, -1, Integer::sum);
      
        return pathCount;
    }
}