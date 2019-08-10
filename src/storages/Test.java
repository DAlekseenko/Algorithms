package storages;

import storages.arrays.IArray;
import storages.arrays.SingleArray;

public class Test {

    public static void main(String[] args) {

        IArray<String> singleArray = new SingleArray<>();
        //Вствка начало
        addValues(singleArray, 100000, 0);

        IArray<String> singleArray2 = new SingleArray<>();
        // Вставка вконец
        addValues(singleArray2, 100000);

//        // Вставка ренверс
//        addRandomValues(singleArray2, 100000, 100000);

        // Удаление конец
        removeValueRoot(singleArray ,99999);
        // Удаление начало
        removeValueStart(singleArray2 ,99999);

//        singleArray.add("Tania");
//        singleArray.add("Lida");
//        singleArray.add("Sergey");
//
//        singleArray.add("Kolia" , 3);
//        singleArray.add("Ubludok" , 4);
//
//
//
//        System.out.println(singleArray.get(0));
//        System.out.println(singleArray.get(1));
//        System.out.println(singleArray.get(2));
//        System.out.println(singleArray.get(3));
//        System.out.println(singleArray.get(4));
//
//        System.out.println("------------------");
//        System.out.println(singleArray.remove(0));
//        System.out.println("------------------");
//
//        System.out.println(singleArray.get(0));
//        System.out.println(singleArray.get(1));
//        System.out.println(singleArray.get(2));
//        System.out.println(singleArray.get(3));
    }

    static private void addValues(IArray<String> array, int count) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            array.add(i + "", 0);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms");
    }

    static private void addValues(IArray<String> array, int count, int index) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            array.add(i + "", index);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms");
    }

    static private void addRandomValues(IArray<String> array, int count, int random) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            random--;
            array.add(i + "", random);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms");
    }

    static private void removeValueRoot(IArray<String> array, int index){
        long start = System.currentTimeMillis();
        while (index >= 0){
            array.remove(index);
            index--;
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + duration + " ms");
    }

    static private void removeValueStart(IArray<String> array, int count){
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            array.remove(0);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + duration + " ms");
    }

}
