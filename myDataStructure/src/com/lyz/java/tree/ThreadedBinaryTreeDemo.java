package com.lyz.java.tree;

/**
 * @author yuan
 * @date 2021/11/22 下午8:16
 */


public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNodeT node1 = new HeroNodeT(1, "lyz");
        HeroNodeT node2 = new HeroNodeT(2, "lyx");
        HeroNodeT node3 = new HeroNodeT(3, "lyc");
        HeroNodeT node4 = new HeroNodeT(4, "lyv");
        HeroNodeT node5 = new HeroNodeT(5, "lyb");
        HeroNodeT node6 = new HeroNodeT(6, "lyn");
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.setRoot(node1);
        tree.threadedNodes();

        HeroNodeT left = node5.getLeft();
        System.out.println(left);
        HeroNodeT right = node5.getRight();
        System.out.println(right);
        tree.threadedList();
    }
}

class ThreadedBinaryTree {
    private HeroNodeT root;
    private HeroNodeT pre;

    public void setRoot(HeroNodeT root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    public HeroNodeT preOrderSearch(int no) {
        if (root != null) {
            HeroNodeT search = root.preOrderSearch(no);
            if (search != null) {
                return search;
            } else {
                System.out.println("未找到！");
                return null;
            }
        } else {
            System.out.println("二叉树为空！");
            return null;
        }
    }

    public HeroNodeT infixOrderSearch(int no) {
        if (root != null) {
            HeroNodeT search = root.infixOrderSearch(no);
            if (search != null) {
                return search;
            } else {
                System.out.println("未找到！");
                return null;
            }
        } else {
            System.out.println("二叉树为空！");
            return null;
        }
    }

    public HeroNodeT postOrderSearch(int no) {
        if (root != null) {
            HeroNodeT search = root.postOrderSearch(no);
            if (search != null) {
                return search;
            } else {
                System.out.println("未找到！");
                return null;
            }
        } else {
            System.out.println("二叉树为空！");
            return null;
        }
    }

    public void delNode(int no) {
        if (root != null) {
            if (root.getId() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("二叉树为空！");
        }
    }

    public void threadedNodes(HeroNodeT node) {
        if (node == null) {
            return;
        }
        threadedNodes(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

        threadedNodes(node.getRight());
    }

    public void threadedNodes() {
        threadedNodes(root);
    }

    public void threadedList() {
        HeroNodeT node = root;
        while (node != null){
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }

            System.out.println(node);

            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
}

class HeroNodeT {
    private int id;
    private String name;
    private HeroNodeT left;
    private HeroNodeT right;
    private int leftType;
    private int rightType;

    public HeroNodeT(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNodeT getLeft() {
        return left;
    }

    public void setLeft(HeroNodeT left) {
        this.left = left;
    }

    public HeroNodeT getRight() {
        return right;
    }

    public void setRight(HeroNodeT right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNodeT{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no) {
        if (this.left != null && this.left.id == no) {
            left = null;
            return;
        }
        if (this.right != null && this.right.id == no) {
            right = null;
            return;
        }
        if (left != null) {
            left.delNode(no);
        }
        if (right != null) {
            right.delNode(no);
        }
    }

    public void preOrder() {
        System.out.println(this);
        if (left != null) {
            left.preOrder();
        }
        if (right != null) {
            right.preOrder();
        }
    }

    public void infixOrder() {
        if (left != null) {
            left.infixOrder();
        }
        System.out.println(this);
        if (right != null) {
            right.infixOrder();
        }
    }

    public void postOrder() {
        if (left != null) {
            left.postOrder();
        }
        if (right != null) {
            right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNodeT preOrderSearch(int no) {
        if (id == no) {
            return this;
        }
        HeroNodeT res = null;
        if (left != null) {
            res = left.preOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (right != null) {
            res = right.preOrderSearch(no);
        }
        return res;
    }

    public HeroNodeT infixOrderSearch(int no) {
        HeroNodeT res = null;
        if (left != null) {
            res = left.infixOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (id == no) {
            return this;
        }
        if (right != null) {
            res = right.infixOrderSearch(no);
        }
        return res;
    }

    public HeroNodeT postOrderSearch(int no) {
        HeroNodeT res = null;
        if (left != null) {
            res = left.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (right != null) {
            res = right.postOrderSearch(no);
        }
        if (id == no) {
            return this;
        }
        return res;
    }

}