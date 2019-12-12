package com.CK;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Recursive
class Solution {
    List<Integer> arr;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        arr = new ArrayList<>();
        helper(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            min = Math.min(min, Math.abs(arr.get(i) - arr.get(i - 1)));
        }
        return min;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        arr.add(root.val);
        helper(root.right);
    }

}

// Iterative
class Solution {
    public int minDiffInBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
                continue;
            }
            curr = stack.pop();
            arr.add(curr.val);
            curr = curr.right;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            min = Math.min(min, Math.abs(arr.get(i) - arr.get(i - 1)));
        }
        return min;
    }
}