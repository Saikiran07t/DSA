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
    public TreeNode invertTree(TreeNode root) {
        // Recursive Approach
        if(root == null) return null ;
       TreeNode left = invertTree(root.left);
       TreeNode right = invertTree(root.right);
        //assigning the right side children nodes to root.left
        root.left = right;
       //assigning the left side children nodes to root.right
        root.right= left;
        return root;
        
        // Iterative Stack
        // if(root== null) return null;
        // Stack<TreeNode> stack = new Stack<TreeNode>();
        // stack.push(root);
        // while(!stack.isEmpty()){
        //     TreeNode temp = stack.pop();
        //     if(temp.right!=null) stack.add(temp.right); // since LIFO Concept
        //     if(temp.left!=null) stack.add(temp.left);
        //     //swapping nodes
        //     TreeNode node =temp.left;
        //     temp.left=temp.right;
        //     temp.right=node;
        // }
        // return root;
        
        //Iterative Queue
        //  if(root== null) return null;
        // Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // queue.add(root);
        // while(!queue.isEmpty()){
        //     TreeNode node = queue.poll();
        //         if(node.left!=null) queue.add(node.left);
        //         if(node.right!=null) queue.add(node.right);
        //         TreeNode temp =node.left;
        //         node.left=node.right;
        //         node.right=temp;
        // }
        // return root;
    }

}