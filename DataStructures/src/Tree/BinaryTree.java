package Tree;

public class BinaryTree <T> implements BinaryTreeInterface<T> {
    private BinaryNode<T> root;
    public BinaryTree () {
        root = null;
    }

    public BinaryTree (T rootData) {
        root = new BinaryNode <> (rootData);
    }

    public BinaryTree (T rootData, BinaryTree <T> leftTree,
                       BinaryTree <T> rightTree) {
        initializeTree (rootdata, leftTree, rightTree);
    }

    public void setTree (T rootData) {
        root = new BinaryNode <> (rootData);
    }

    public void setTree (T rootData,
                         BinaryTreeInterface <T> leftTree,
                         BinaryTreeInterface <T> rightTree) {
        initializeTree (rootData, (BinaryTree <T>) leftTree,
                (BinaryTree <T>) rightTree);
    }





    private void initializeTree (T rootData,
                                 BinaryTree <T> leftTree, BinaryTree <T> rightTree) {
        root = new BinaryNode <> (rootData);
        if (leftTree != null)
            root.setLeftChild (leftTree.getRootNode());
        if (rightTree != null)
            root.setRightChild (rightTree.getRootNode());
    }
}
