package CrackingTheCodeInterview;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.Tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class TreeNode{
    public int value = 0;
    public TreeNode right = null;
    public TreeNode left = null;

    public TreeNode(int value){
        this.value = value;
    }

}


public class BinaryTreePaths {

    public static List<ArrayList<String>> solve(TreeNode node){
        if(node == null) return null;


        List<ArrayList<String>> t = new ArrayList<>();
        t.add(new ArrayList<String>());

        List<ArrayList<String>> ans =t;


        if(node.right == null && node.left == null){

            // visit
            ans = ans.stream().map((var a) -> {
                a.add(node.value + "");
                return a;
            }).collect(Collectors.toList());
            return ans;
        }


        ans.remove(ans.size()-1);










            var res = solve(node.left);

        if(res != null){
            res = res.stream().map((var a) -> {
                a.add(node.value+"");

                return a;
            }).collect(Collectors.toList());
            ans.addAll(res);
        }










             res = solve(node.right);
        if(res != null){
            res = res.stream().map((var a) -> {
                a.add(node.value+"");

                return a;
            }).collect(Collectors.toList());
            ans.addAll(res);
        }



        return ans;
    }


    public static void solve(TreeNode node, List<String> ans, String path){
        if(node == null) return ;





        if(node.right == null && node.left == null){

            path+=node.value;
            // visit
            ans.add(path);

        }


        //ans.remove(ans.size()-1);










          solve(node.left,ans, path+node.value+"->");




          solve(node.right,ans, path+node.value+"->");





    }



    public static void main(String[] args){

        var n = new TreeNode(4);
        n.left=new TreeNode(7);
        n.left.left=new TreeNode(3);
        n.left.right=new TreeNode(6);
        n.left.right.right=new TreeNode(8);
        n.right=new TreeNode(9);
        n.right.right=new TreeNode(10);
        n.right.right.right=new TreeNode(15);



       // System.out.println(solve(n));
       ArrayList<String> ans =   new ArrayList<>();

        solve(n, ans, "");
        System.out.println(ans);

    }
}
