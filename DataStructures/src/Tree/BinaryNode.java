package Tree;

class BinaryNode <T> implements BinaryNodeInterface <T>
{
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    public BinaryNode () {
        this (null);
    }

    public BinaryNode (T rootData) {
        this (rootData, null, null);
    }

    public BinaryNode (T rootData, BinaryNode <T> newLeftChild,
                       BinaryNode <T> newRightChild) {
        data = rootData;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    }

    public T getData() {
        return data;
    }
    public void setData (T newData) {
        data = newData;
    }

    public BinaryNode<T> getLeftChild () {
        return leftChild;
    }

    public void setLeftChild ( (BinaryNodeInterface <T>) newLeftChild)
    {
        leftChild = (BinaryNode <T>) newLeftChild;
    }

    public boolean hasLeftChild () {
        return (leftChild != null);
    }

    public boolean isLeaf () {
        return (leftChild == null && rightChild == null);
    }
