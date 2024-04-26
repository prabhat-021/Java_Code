package basic;

public class Binary_tree_basic {

//    10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false
//    sample input
    public static void main(String[] args) {
        BinaryTree1 bt=new BinaryTree1();
        bt.dispaly();
        System.out.println(bt.max());
        System.out.println(bt.hight());
//        bt.levelOrder();
    }
}
