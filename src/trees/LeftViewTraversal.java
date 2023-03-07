package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewTraversal {

    // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            if(root == null){
                return result;
            }

            queue.add(root);

            while(!queue.isEmpty()){
                int len = queue.size();
                for(int i = 0 ; i < len ; i++){
                    TreeNode curr = queue.poll();
                    if(i == len - 1){
                        result.add(curr.val);
                    }
                    if(curr.left != null){
                        queue.add(curr.left);
                    }
                    if(curr.right != null){
                        queue.add(curr.right);
                    }
                }
            }
            return result;

        }
    }
}
