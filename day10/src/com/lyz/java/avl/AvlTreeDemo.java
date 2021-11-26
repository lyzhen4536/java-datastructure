package com.lyz.java.avl;

/**
 * @author yuan
 * @date 2021/11/4 下午11:18
 */


public class AvlTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        AvlTree tree = new AvlTree();
        for (int i : arr) {
            tree.add(new Node(i));
        }
        System.out.println("infixOrder");
        tree.infixOrder();
        System.out.println("没有左旋转前");
        System.out.println("树的高度： " + tree.getRoot().height());
        System.out.println("树左子树的高度： " + tree.getRoot().leftHeight());
        System.out.println("树右子树的高度： " + tree.getRoot().rightHeight());
    }
}

class AvlTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

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

        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }

        if (leftHeight() - rightHeight() > 1){
            if (left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
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

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    private void leftRotate() {
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }

    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

}

