/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean helper(TreeNode root,TreeNode p,ArrayList<TreeNode>path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root==p){
            return true;
        }
        boolean left=helper(root.left,p,path);
        boolean right=helper(root.right,p,path);

        if(left || right){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=new ArrayList<>();
        ArrayList<TreeNode> path2=new ArrayList<>();

        helper(root,p,path1);
        helper(root,q,path2);

        int i=0;
        for(i=0;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        TreeNode lca=path1.get(i-1);
        return lca;
    }
}