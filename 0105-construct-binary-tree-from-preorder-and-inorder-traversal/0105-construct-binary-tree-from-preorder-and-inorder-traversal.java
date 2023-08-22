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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //create Hashmap of inorder list
        Map<Integer,Integer> inorderMap = new HashMap<Integer,Integer>();
        int n=inorder.length;
        for(int i=0;i<n;i++){
            inorderMap.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,n,inorderMap);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,
                             int inStart,int inEnd,Map<Integer,Integer> inorderMap)
    {
        //return null if array becomes empty
        if(preStart>preEnd || inStart>inEnd) return null;
        
        //first create root from pre order where 1st index would be root
        TreeNode root = new TreeNode(preorder[preStart]);
        //find the root's index from inorder map
       int inRootIndex = inorderMap.get(root.val);
       int leftSubtreeSizeOfInorder =inRootIndex-inStart;
        //this leftSubtreeSize will be the new inorder 
        
        root.left =buildTree(preorder,preStart+1,preStart+leftSubtreeSizeOfInorder
                            ,inorder,inStart,inRootIndex-1,inorderMap);
        
        root.right= buildTree(preorder,preStart+leftSubtreeSizeOfInorder+1,preEnd,inorder,
                             inRootIndex+1,inEnd,inorderMap);
        return root;
    }
    
    
}