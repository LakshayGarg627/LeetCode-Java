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
        if(root==null){
            return -1;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                result.add(temp);
                temp=new ArrayList<>();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }else{
                temp.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        List<Integer> arr=result.get(result.size()-1);
        return arr.get(0);
    }
}