package datastructures;


import java.util.NoSuchElementException;

/**
 * Created by ananthmajumdar on 4/1/15.
 */
public class BinarySearchTree {
    //insert
    //delete
    //search
    //findMinimum

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    private TreeNode root;

    public void insert(int x){
          if(root == null){
                root = new TreeNode();
                root.setData(x);

          }else{
                TreeNode temp = root;

              while(temp!=null){
                  if(x<=temp.getData()){

                      if(temp.getLeft()==null){
                          TreeNode node = new TreeNode();
                          node.setData(x);
                          node.setParent(temp);
                          temp.setLeft(node);
                          break;
                      }else{

                          temp = temp.getLeft();
                      }

                  }else{

                      if(temp.getRight()==null){
                          TreeNode node = new TreeNode();
                          node.setData(x);
                          node.setParent(temp);
                          temp.setRight(node);
                          break;
                      }else{

                          temp = temp.getRight();
                      }

                  }
              }

          }
    }

    public TreeNode delete(int i){
        TreeNode nodeToDelete = search(root,i);
        if(nodeToDelete==null){
            throw new NoSuchElementException();
        }else{
            TreeNode parentNode = nodeToDelete.getParent();

            if(parentNode==null){
               root = nodeToDelete.getRight();
                nodeToDelete.getLeft().setParent(root);
                nodeToDelete.getRight().setParent(null);
                root.setLeft(nodeToDelete.getLeft());
            } else{
                boolean leftChild=false;
                if(parentNode.getLeft()!=null && nodeToDelete.getData()==parentNode.getLeft().getData()) {
                    leftChild=true;
                }
                if(nodeToDelete.getLeft()==null && nodeToDelete.getRight()==null) {

                    if(leftChild){
                        parentNode.setLeft(null);
                    }else{
                        parentNode.setRight(null);
                    }


                }else if(nodeToDelete.getLeft()==null && nodeToDelete.getRight()!=null){

                    if(leftChild){
                        parentNode.setLeft(nodeToDelete.getRight());

                    }else{
                        parentNode.setRight(nodeToDelete.getRight());

                    }
                    nodeToDelete.getRight().setParent(parentNode);
                } else if(nodeToDelete.getLeft()!=null && nodeToDelete.getRight()==null){
                    if(leftChild){
                        parentNode.setLeft(nodeToDelete.getLeft());

                    }else{
                        parentNode.setRight(nodeToDelete.getLeft());

                    }
                    nodeToDelete.getLeft().setParent(parentNode);
                } else if(nodeToDelete.getLeft()!=null && nodeToDelete.getRight()!=null){
                    TreeNode successor =  findMinimum(nodeToDelete.getRight());
                    if(leftChild){
                        parentNode.setLeft(successor);

                    }else{
                        parentNode.setRight(successor);
                    }
                    nodeToDelete.getLeft().setParent(successor);
                    nodeToDelete.getRight().setParent(successor);

                    delete(successor.getData());
                }
            }


        }
           return nodeToDelete;
    }

    private TreeNode search(TreeNode root, int i){
        TreeNode returnVal = null;
        if(root == null){
            returnVal= null;
        }
       else if(i==root.getData()){
            returnVal= root;
       } else if(i< root.getData()) {
            returnVal= search(root.getLeft(),i);
       }else if(i > root.getData()){
            returnVal= search(root.getRight(),i);
       }

         return returnVal;
    }

    public TreeNode search(int i){
        return search(getRoot(),i);
    }
    private void traverse(TreeNode node){

        if(node!=null){
            if(node.getLeft()!=null){
                System.out.println("/");
                traverse(node.getLeft());
            }
                System.out.println(node.getData());


            if(node.getRight()!=null){
                System.out.println("\\");
                traverse(node.getRight());
            }
        }


    }

   private TreeNode findMinimum(TreeNode root){

       if(root!=null){
           TreeNode tree = root;
           while(tree.getLeft()!=null){
               tree = tree.getLeft();
           }
          return tree;
       }else {
           throw new NoSuchElementException();
       }



   }

    public TreeNode findMinimum(){
        return findMinimum(getRoot());
    }

    public void traverse(){
         traverse(getRoot());
    }


    class TreeNode {
        private int data;
        private TreeNode parent;
        private TreeNode left;
        private TreeNode right;

        public int getData() {
            return data;
        }

        public void setData(int d){
            this.data =d;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);
        bst.insert(5);
        bst.insert(8);
        bst.insert(2);
        bst.insert(9);
      bst.delete(6);
        bst.delete(5);
        bst.delete(8);

       // bst.traverse(bst.root);
    //  TreeNode result =   bst.search(bst.root, 8);
      //  System.out.println(result);
       // System.out.println(bst.findMinimum(bst.getRoot()).getData());
      //  bst.delete(1);
       // bst.delete(-2)  ;
       // System.out.println(bst.findMinimum(bst.getRoot()).getData());
        bst.traverse();

    }
}
