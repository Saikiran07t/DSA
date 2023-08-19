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
    public int minDepth(TreeNode root) {
        //using BFS
        // if(root == null) return 0;
        // Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // queue.add(root);
        // int depth=1;
        // while(!queue.isEmpty()){
        //     int size=queue.size();
        //     for(int i=0;i<size;i++){
        //         TreeNode cur=queue.poll();
        //         if(cur.left== null && cur.right==null) return depth;
        //         if(cur.left!=null) queue.add(cur.left);
        //         if(cur.right!=null) queue.add(cur.right);
        //     }
        //     depth++;
        // }
        // return depth;
        
        //using DFS
        // if(root == null) return 0;
        // if(root.left==null && root.right == null) return 1;
        // int leftHeight = root.left!=null ?minDepth(root.left) : Integer.MAX_VALUE;
        // int rightHeight = root.right!=null? minDepth(root.right): Integer.MAX_VALUE;
        // return 1+Math.min(leftHeight,rightHeight);
        
        //using DFS Approach -2
              if(root == null){
            return 0;
        }
        if(root.left == null || root.right == null){
            return 1+Math.max(minDepth(root.left), minDepth(root.right));
        }
        return 1+Math.min(minDepth(root.left), minDepth(root.right));

    }
}