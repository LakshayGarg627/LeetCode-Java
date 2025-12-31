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
    public boolean mirror(TreeNode a,TreeNode b){
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null){
            return false;
        }
        boolean left=mirror(a.left,b.right);
        boolean right=mirror(a.right,b.left);

        if(a.val==b.val && left && right){
            return true;
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return mirror(root.left,root.right);
    }
}