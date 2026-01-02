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
    static int i=0;
    public TreeNode helper(int preorder[],int bound){
        if(i>=preorder.length || bound<preorder[i]){
            return null;
        }
        TreeNode root=new TreeNode(preorder[i]);
        i++;
        root.left=helper(preorder,root.val);
        root.right=helper(preorder,bound);
        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        i=0;
        return helper(preorder,Integer.MAX_VALUE);
    }
}