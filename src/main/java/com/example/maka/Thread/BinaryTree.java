package com.example.maka.Thread;


public class BinaryTree {

    public class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.value = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }

    //根节点
    private TreeNode root = null;

    public BinaryTree(){
        root = new TreeNode(4);
    }

    //创建二叉树
    public void createBinaryTree(TreeNode root){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node5;
        node2.right = node3;
        node2.left = node1;
    }

    //先序
    public void pre(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.value);
        pre(root.left);
        pre(root.right);
    }

    //中序
    public static void cur(TreeNode root) {
        if (root == null)
            return;
        cur(root.left);
        System.out.print(root.value);
        cur(root.right);
    }

    //后序
    public static void nxt(TreeNode root) {
        if (root == null)
            return;
        nxt(root.left);
        nxt(root.right);
        System.out.print(root.value);
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.root;
        tree.createBinaryTree(root);
        tree.pre(root);
    }
}