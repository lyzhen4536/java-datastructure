package com.lyz.java.tree;

/**
 * @author yuan
 * @date 2021/11/23 下午3:35
 */


public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree tree = new BinarySortTree();
        for (int value : arr) {
            tree.add(new Node(value));
        }
        tree.infixOrder();
        tree.delNode(7);
        System.out.println();
        tree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("root 为空！");
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("root 为空！");
        }
    }

    public Node search(int val) {
        if (root != null) {
            return root.search(val);
        } else {
            System.out.println("root 为空！");
            return null;
        }
    }

    public Node searchParent(int val) {
        if (root == null) {
            System.out.println("root 为空！");
            return null;
        } else {
            return root.searchParent(val);
        }
    }

    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        int temp = target.value;
        delNode(target.value);
        return temp;
    }

    public void delNode(int val) {
        if (root == null) {
            return;
        } else {
            Node target = search(val);
            if (target == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = searchParent(val);
            if (target.left == null && target.right == null) {
                if (parent.left != null && parent.left.value == val) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == val) {
                    parent.right = null;
                }
            } else if (target.left != null && target.right != null) {
                int min = delRightTreeMin(target.right);
                target.value = min;
            } else {
                if (target.left != null) {
                    if (parent != null) {
                        if (parent.left.value == val) {
                            parent.left = target.left;
                        } else {
                            parent.right = target.left;
                        }
                    } else {
                        root = target.left;
                    }
                } else {
                    if (parent != null) {
                        if (parent.left.value == val) {
                            parent.left = target.right;
                        } else {
                            parent.right = target.right;
                        }
                    } else {
                        root = target.right;
                    }
                }
            }
        }
    }
}
