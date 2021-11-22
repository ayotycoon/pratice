//import java.util.*;
//
//public class Trevasal {
//    public static void inOrder(TreeNode root, List<Integer> list){
//        if(root == null)return;
//        inOrder(root.left,list);
//        System.out.print(root.val);
//        list.add(root.val);
//        inOrder(root.right,list);
//
//        //list1.equals(list2)
//
//    }
//    public static void breadthFirst(TreeNode root){
//
//        Queue<TreeNode> s = new LinkedList<>();
//        s.add(root);
//
//        while(!s.isEmpty()){
//            TreeNode curr = s.remove();
//            System.out.print(curr.val);
//            if(curr.right != null){
//                s.add(curr.right);
//            }
//            if(curr.left != null){
//                s.add(curr.left);
//            }
//
//        }
//
//
//
//
//    }
//
//    public static void preOrder(TreeNode root){
//
//        Stack<TreeNode> s = new Stack<>();
//        s.add(root);
//
//        while(!s.isEmpty()){
//            TreeNode curr = s.pop();
//            System.out.print(curr.val);
//            if(curr.right != null){
//                s.add(curr.right);
//            }
//            if(curr.left != null){
//                s.add(curr.left);
//            }
//
//        }
//
//
//
//
//    }
//
//    public static void main (String[] args){
//
//        TreeNode tree1 = new TreeNode(5);
//        tree1.left = new TreeNode(3);
//        tree1.left.left = new TreeNode(1);
//        tree1.right = new TreeNode(7);
//        tree1.right.left = new TreeNode(6);
//
//
//        TreeNode tree2 = new TreeNode(1);
//        tree2.left = new TreeNode(2);
//        tree2.left.left = new TreeNode(4);
//      tree2.left.right = new TreeNode(5);
//      tree2.right = new TreeNode(3);
//
//
//
//        List<Integer> list1 = new ArrayList<Integer>();
//        System.out.print("inOrder - ");
//        inOrder(tree1, list1);
//        System.out.print("\npostOrder - ");
//        breadthFirst(tree2);
//        System.out.print("\nPreOrder - ");
//        preOrder(tree2);
//
//    }
//}
