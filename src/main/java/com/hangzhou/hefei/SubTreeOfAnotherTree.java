package com.hangzhou.hefei;

/**
 * leetcode practice
 *
 * @author hefei.hfei@alibaba-inc.com
 * @create 2017-05-20 23:07
 */
public class SubTreeOfAnotherTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isSubtree(TreeNode s, TreeNode t, boolean head) {
        if(s == null) {
            return false;
        }
        if(s.val == t.val ) {
            boolean leftResult = (t.left == null && s.left == null) ||( t.left != null && isSubtree(s.left, t.left, false));
            boolean rightResult = (t.right == null && s.right == null) ||( t.right != null && isSubtree(s.right, t.right, false));
            if(leftResult && rightResult) {
                return true;
            }
        }
        if(head && (isSubtree(s.left, t, head) || isSubtree(s.right, t,  head))) {
            return true;
        }
        return false;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSubtree(s, t, true);
    }
}
