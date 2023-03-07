package trees;

import java.util.*;

public class ZigzagLevelOrderTraversal {


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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            if(root == null){
                return result;
            }

            queue.add(root);
            boolean levelMark = true;

            while(!queue.isEmpty()){
                List<Integer> level = new ArrayList<>();
                int size = queue.size();

                for(int i = 0 ; i < size ; i++){

                    TreeNode curr = queue.poll();
                    level.add(curr.val);

                    if(curr.left != null){
                        queue.add(curr.left);
                    }
                    if(curr.right != null){
                        queue.add(curr.right);
                    }
                }
                if(!levelMark){
                    Collections.reverse(level);
                }
                result.add(level);
                levelMark = !levelMark;
            }
            return result;
        }
    }
}
