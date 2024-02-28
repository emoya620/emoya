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
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> leftMostNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null){
            return -1;
        }

        queue.add(root);
        while (!queue.isEmpty()){
            leftMostNodes.add(queue.peek().val);
            int length = queue.size();
            for (int i = 0; i < length; i++){
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
        }

        return leftMostNodes.get(leftMostNodes.size() - 1);
    }
}
