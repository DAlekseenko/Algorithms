package trees;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        test();
    }


    public static void test() {
        ITree<Integer, Integer> tree = new Avl<>();
        int n = 50000000;
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
           // int key  = random.nextInt(n);
            tree.insert(i, i);
        }
        System.out.println(System.currentTimeMillis() - start + " ms insert");
        //tree.print();

        start = System.currentTimeMillis();
        for (int i = 0; i < n / 10; i++) {
            int key = random.nextInt(n);
            tree.search(key);
            //System.out.println(key + "=>" + value);
        }
        System.out.println(System.currentTimeMillis() - start + " ms search");
        start = System.currentTimeMillis();
        for (int i = 0; i < n / 10; i++) {
            int key = random.nextInt(n);
            tree.remove(key);
            //System.out.println(key + "=>" + value);
        }
        System.out.println(System.currentTimeMillis() - start + " ms remove");
    }
}
