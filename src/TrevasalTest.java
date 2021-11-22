import java.util.*;

public class TrevasalTest {

    private static TreeNode root1 = new TreeNode(4);
    private static TreeNode root2 = new TreeNode(5);
    private static int i =0;
    private static TreeNode ans = null;
    public static TreeNode recur(TreeNode root, int k) {
        if(root == null) return null;
        if(root.left != null) recur(root.left,k);
        i++;
        if(k == i) {
            ans = root;
            //return root;
        };
        System.out.println("root - " + root.val + " i- "+i);

        if(root.right != null) recur(root.right,k);
HashMap<String,Boolean> g = new HashMap<>();

        return null;
    }


    public static void main (String[] args){

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(8);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(10);

        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(2);
        root2.right = new TreeNode(8);
        root2.right.right = new TreeNode(10);



        int k = 2;

        recur(root2,k);
        System.out.println(ans);
    }
}
