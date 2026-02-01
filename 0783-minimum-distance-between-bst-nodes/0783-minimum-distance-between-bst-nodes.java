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
    TreeNode prev=null;
    int min=Integer.MAX_VALUE;
    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(prev!=null){
            min=Math.min(min,root.val-prev.val);
        }
        prev=root;
        helper(root.right);
    } 
    public int minDiffInBST(TreeNode root) {
        if(root==null){
            return 0;
        }
        min=Integer.MAX_VALUE;
        helper(root);
        return min;
    }
}

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
// class Solution {
//     Integer prev=null;
//     int min=Integer.MAX_VALUE;
//     public void inorder(TreeNode root){
//         if(root==null){
//             return;
//         }
//         inorder(root.left);
//         if(prev!=null){
//             min=Math.min(min,root.val-prev);
//         }
//         prev=root.val;
//         inorder(root.right);
//     }
//     public int minDiffInBST(TreeNode root) {
//         min=Integer.MAX_VALUE;
//         prev=null;
//         inorder(root);
//         return min;
//     }
// }