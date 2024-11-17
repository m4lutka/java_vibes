// Kibitkin Ilya IT3-2307
// Leetcode Solutions


import java.util.List;
import java.util.Set;
import java.util.HashSet;

// 572. Subtree of Another Tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){
      this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isTheSame(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isTheSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isTheSame(s.left, t.left) && isTheSame(s.right, t.right);
    }
}


// 705. Design HashSet
class MyHashSet {
    private int[] keys;
    private int size;

    public MyHashSet() {
        this.keys = new int[100000];
        this.size = 0;
    }

    public void add(int key) {
        if (key < 0) {
            return;
        }
        if (!contains(key)) {
            keys[size] = key;
            size++;
        }
    }

    public void remove(int key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                keys[i] = keys[size - 1];
                size--;
                return;
            }
        }
    }

    public boolean contains(int key) {
        if (key < 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return true;
            }
        }
        return false;
    }
}


// 139. Word Break
class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Check out the solution on LeetCode =)");
    }
}
