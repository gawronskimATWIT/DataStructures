package Tree;

public class Test {


    public static void main(String[] args) {
        BinaryTreeInterface<String> dTree = new BinaryTree<>();
        dTree.setTree("D");
        BinaryTreeInterface<String> eTree = new BinaryTree<>();
        eTree.setTree("E");
        BinaryTreeInterface<String> bTree = new BinaryTree<>();
        bTree.setTree("B",dTree,eTree);
        BinaryTreeInterface<String> hTree = new BinaryTree<>();
        hTree.setTree("H");
        BinaryTreeInterface<String> emptyTree = new BinaryTree<>();
        BinaryTreeInterface<String> gTree = new BinaryTree<>();
        gTree.setTree("G",hTree,emptyTree);
        BinaryTreeInterface<String> fTree = new BinaryTree<>();
        fTree.setTree("F");
        BinaryTreeInterface<String> cTree = new BinaryTree<>();
        cTree.setTree("C",fTree,gTree);
        BinaryTreeInterface<String> aTree = new BinaryTree<>();
        aTree.setTree("A",bTree,cTree);


    }



}
