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
    public boolean isSymmetric(TreeNode root) {
//         if(root==null) return true;
//         return isSymmetricHelper(root.left,root.right);
        
//     }
//     public boolean isSymmetricHelper(TreeNode left,TreeNode right){
//         if(left==null || right ==null)
//             return (left==right);
//         if(left.val!=right.val)
//             return false;
//     return isSymmetricHelper(left.left,right.right)&&          isSymmetricHelper(left.right,right.left);
//     }
        
//         //Iterative approach
//         if(root == null)
//             return true;
//         Queue<TreeNode> q = new LinkedList();
       
//         q.add(root.left);
//         q.add(root.right);
//         while(!q.isEmpty()){
//             TreeNode left = q.poll();
//             TreeNode right = q.poll();
//             if(left == null && right == null)
//                 continue;
//             if(left == null || right == null ||left.val != right.val )
//                 return false;
//             q.add(left.left);
//             q.add(right.right);
//             q.add(left.right);
//             q.add(right.left);
            
//         }
//         return true;
//     }
        
        //Iterative Stack 
        if(root == null)
            return true;
        Stack<TreeNode> st = new Stack();
        st.push(root.left);
        st.push(root.right);
    
        while(!st.isEmpty()){
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            if(left == null && right == null)
                continue;
            if(left == null || right == null ||left.val != right.val )
                return false;
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);
            
        }
        return true;
    }
        
}