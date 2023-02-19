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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null) return output;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        //flag to reversethe direction
        boolean lrFlag =true;
        while(!queue.isEmpty()){
            int size = queue.size();
            //to store nodes in each level
            List<Integer> subList=new ArrayList<Integer>(size);
            for(int i=0;i<size;i++){
                TreeNode node =queue.peek();
                queue.poll();
               int index=i;
                if(lrFlag ==true)
                    subList.add(node.val);
                if(lrFlag== false)
                    subList.add(0,node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            lrFlag =! lrFlag;
            output.add(subList);
        }
        return output;
    }
}