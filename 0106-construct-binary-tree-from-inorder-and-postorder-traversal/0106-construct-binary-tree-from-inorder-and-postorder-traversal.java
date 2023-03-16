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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder== null ||postorder==null || inorder.length!=postorder.length)
            return null;
        
        HashMap<Integer,Integer> inMap = new HashMap<Integer,Integer>();
        
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
     TreeNode root = buildBT(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inMap);
        return root;
        
    }
    
    public TreeNode buildBT(int[] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> inMap){
        
        //base case
        if(postStart> postEnd || inStart> inEnd)
            return null;
     
        TreeNode root = new TreeNode(postorder[postEnd]);
           int rootIndex= inMap.get(postorder[postEnd]);
        
        int numsLeft=rootIndex-inStart;
        root.left= buildBT(postorder,postStart,postStart+numsLeft-1,inorder,inStart,rootIndex-1,inMap);
        root.right= buildBT(postorder,postStart+numsLeft,postEnd-1,inorder,rootIndex+1,inEnd,inMap);
        
        return root;
    
    }
}