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
    
    public int returnGoodNodesInSubtree(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        
        if (max <= node.val) {
            return 1 + 
                returnGoodNodesInSubtree(node.left, node.val) +
                returnGoodNodesInSubtree(node.right, node.val);
        }
        else {
            return returnGoodNodesInSubtree(node.left, max) +
                returnGoodNodesInSubtree(node.right, max);
        }
    }
    
    public int goodNodes(TreeNode root) {
        return returnGoodNodesInSubtree(root, -10001);
    }

}