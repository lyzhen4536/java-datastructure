package com.lyz.java;

/**
 * @author yuan
 * @date 2021/11/2 下午6:34
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
                int minVal = delRightTreeMin(target.right);
                target.value = minVal;
            } else {
                if (target.left != null) {
                    if (parent != null){
                        if (parent.left.value == val) {
                            parent.left = target.left;
                        } else {
                            parent.right = target.left;
                        }
                    } else {
                        root = target.left;
                    }
                } else {
                    if (parent != null){
                        if (parent.left.value == val) {
                            parent.left = target.right;
                        } else {
                            parent.right = target.right;
                        }
                    }else {
                        root = target.right;
                    }
                }
            }
        }

    }


}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public Node search(int val) {
        if (this.value == val) {
            return this;
        } else if (this.value < val) {
            if (this.right == null) {
                return null;
            }
            return this.right.search(val);
        } else {
            if (this.left == null) {
                return null;
            }
            return this.left.search(val);
        }
    }

    public Node searchParent(int val) {
        if ((this.left != null && this.left.value == val) || (this.right != null && this.right.value == val)) {
            return this;
        } else {
            if (this.left != null && this.value > val) {
                return this.left.searchParent(val);
            } else if (this.right != null && this.value <= val) {
                return this.right.searchParent(val);
            } else {
                return null;
            }
        }
    }

}
