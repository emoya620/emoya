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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++){
                TreeNode cur = queue.poll();
                row.add(cur.val);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            
            if (checkLevel(level, row) == false){
                return false;
            }
            level++;
        }
        return true;
    }

    public boolean checkLevel(int level, List<Integer> row){
        if (row.size() == 1){
            if (level % 2 == 0 && row.get(0) % 2 == 0){
                return false;
            }
            else if (level % 2 == 1 && row.get(0) % 2 == 1){
                return false;
            }
            return true;
        }
        
        if (level % 2 == 0){
            for (int i = 0; i < row.size() - 1; i++){
                if (row.get(i) % 2 != 1 || row.get(i+1) % 2 != 1 || row.get(i) >= row.get(i+1)){
                    return false;
                }
            }
        }
        else{
            for (int i = 0; i < row.size() - 1; i++){
                if (row.get(i) % 2 != 0 || row.get(i+1) % 2 != 0 || row.get(i) <= row.get(i+1)){
                    return false;
                }
            }
        }
        return true;
    }
}
