public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +

                " val=" + val +
                '}';
    }
}
