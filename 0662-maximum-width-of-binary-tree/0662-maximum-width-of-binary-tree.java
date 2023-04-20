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
    
    class Pair{
    TreeNode node;
    int num ;
   public Pair(TreeNode node,int num){
        this.node=node;
        this.num=num;
    }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root ==null) return 0;
        int res=0;
        Queue<Pair> queue =new LinkedList<>();
        queue.offer(new Pair(root,0)); //0 is initial index
        
        while(!queue.isEmpty()){
            int size =queue.size();
            int minIndex = queue.peek().num;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                int currIndex=queue.peek().num-minIndex;
                TreeNode node =queue.peek().node;
                queue.poll();
                if(i==0)      first =currIndex;
                if(i==size-1) last=currIndex;
                if(node.left!=null)
                    queue.offer(new Pair(node.left,currIndex*2+1));
                if(node.right!=null)
                    queue.offer(new Pair(node.right,currIndex*2+2));
            }
            res =Math.max(res,last-first+1);
        }
        return res;
        
            }
    
    // solution-2
  /*
  class node{
        
        TreeNode data;
        int index;
        
        public node(TreeNode data, int index)
        {
            this.data = data;
            this.index = index;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null)
            return 0;
        
        Queue<node> q = new LinkedList<>();
        q.add(new node(root, 0));
        int min = 0;
        int max = 0;
        int res = 1;
        
        while(!q.isEmpty())
        {
            int size = q.size();
    
            for(int i = 0; i<size; i++)
            {
                node temp = q.poll();
                
                if(i == 0)
                    min = temp.index;
                
                if(i == size-1)
                    max = temp.index;
                
                if(temp!=null && temp.data.left!=null)
                    q.add(new node(temp.data.left, 2*temp.index + 1));
                
                if(temp!=null && temp.data.right!=null)
                    q.add(new node(temp.data.right, 2*temp.index + 2));
                
            }
			
            res = Math.max(res, max - min + 1);
        }
        
        return res;
        
    }*/    
    
}