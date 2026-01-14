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
    static int idx=0;
    public void reverse(int preorder[]){
        for(int i=0;i<preorder.length/2;i++){
            int temp=preorder[i];
            preorder[i]=preorder[preorder.length-i-1];
            preorder[preorder.length-i-1]=temp;
        }
    }
    public int search(int inorder[],int val,int left,int right){
        for(int i=left;i<=right;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
    public TreeNode helper(int inorder[],int postorder[],int left,int right){
        if(left>right){
            return null;
        }
        TreeNode root=new TreeNode(postorder[idx]);
        int searchIdx=search(inorder,postorder[idx],left,right);
        idx++;
        root.right=helper(inorder,postorder,searchIdx+1,right);
        root.left=helper(inorder,postorder,left,searchIdx-1);
        

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx=0;
        reverse(postorder);
        
        return helper(inorder,postorder,0,inorder.length-1);
    }
}