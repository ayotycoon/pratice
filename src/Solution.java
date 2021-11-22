import java.util.HashMap;
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
    public static int last = Integer.MIN_VALUE;
    public static boolean ans = true;

    public static void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(root.val <= last) {

            ans = false;
        }

        last = root.val;


        inOrder(root.right);



    }
    public static boolean isValidBST(TreeNode root) {
        inOrder(root);

        return ans;

}


    public static void main (String[] args){

        TreeNode root= new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        isValidBST(root);
        System.out.println(ans);
    }
}
