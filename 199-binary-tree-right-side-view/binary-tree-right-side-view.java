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
    Map<Integer, Integer> map;

    public void exploreAndPopulateMap(TreeNode root, int index) {
        if (root == null)
            return;

        if (!map.containsKey(index)) {
            map.put(index, root.val);
        }

        exploreAndPopulateMap(root.right, index+1);
        exploreAndPopulateMap(root.left, index+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        map = new TreeMap<Integer, Integer>();
        exploreAndPopulateMap(root, 0);
        return new ArrayList<>(map.values());
    }
}