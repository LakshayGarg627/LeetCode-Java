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
    public void preorder(TreeNode root,ArrayList<TreeNode> temp){
        if(root==null){
            return;
        }
        temp.add(root);
        preorder(root.left,temp);
        preorder(root.right,temp);
    }
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> temp=new ArrayList<>();
        preorder(root,temp);
        
        for(int i=1;i<temp.size();i++){
            root.left=null;
            root.right=temp.get(i);
            root=root.right;
        }
    }
}