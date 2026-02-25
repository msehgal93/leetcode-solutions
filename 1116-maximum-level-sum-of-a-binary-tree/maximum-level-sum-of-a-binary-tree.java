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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> list = new ArrayDeque<>();
        long temp, max = Long.MIN_VALUE;
        int minLevel = 1, currLevel = 0;
        
        list.offer(root);

        while (!list.isEmpty()) {
            temp = 0;
            currLevel++;
            int len = list.size();

            for(int i=0; i<len; i++) {
                TreeNode node = list.poll();
                temp += node.val;
                if (node.left != null)
                    list.offer(node.left);
                if (node.right != null)
                    list.offer(node.right);
            }

            if (max < temp) {
                max = temp;
                minLevel = currLevel;
            }
        }

        return minLevel;
    }
}