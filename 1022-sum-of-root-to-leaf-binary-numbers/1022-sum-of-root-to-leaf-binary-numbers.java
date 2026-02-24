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
    static int sum=0;
    public void extractnum(List<Integer> arr){
        int dec=0;
        for(int i=0;i<arr.size();i++){
            dec=dec*2+arr.get(i);
        }
        sum+=dec;
    }
    public void tractPath(TreeNode root,List<Integer> arr){
        if(root==null){
            return;
        }
        arr.add(root.val);
        if(root.left==null && root.right==null){
            extractnum(arr);
            arr.remove(arr.size()-1);
            return;
        }
        tractPath(root.left,arr);
        tractPath(root.right,arr);
        arr.remove(arr.size()-1);
    }
    public int sumRootToLeaf(TreeNode root) {
        if(root==null){
            return 0;
        }
        sum=0;
        List<Integer> arr=new ArrayList<>();
        tractPath(root,arr);
        return sum;
    }
}