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
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q=new LinkedList<>();
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        q.add(root);
        q.add(null);
        int level=1;
        int maxLevel=1;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                
                if(sum>maxSum){
                    maxSum=sum;
                    maxLevel=level;
                }

                level++;
                sum=0;
                if(!q.isEmpty()){
                    q.add(null);
                }
                
            }else{
                sum+=curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return maxLevel;
    }
}