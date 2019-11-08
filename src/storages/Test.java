package storages;

import storages.arrays.*;
import storages.others.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test {

    public static void main(String[] args) {

       List<String> arrayList = new ArrayList<String>();

        System.out.println(arrayList.toString());

        for (int i = 0; i < 10; i++) {
            arrayList.add(i + "test case");
        }

        System.out.println(arrayList.size());

        arrayList.remove(0);

        System.out.println(arrayList.get(8));

        arrayList.add(0, "test case");

        System.out.println(arrayList.toString());

        testSingleArray();

       // testSingleArray();

        //addValues(singleArray, 1000000);


//        addValues(singleArray, 100000, 0, "Вствка в начало");
//
//        //IArray<String> singleArray = new SingleArray<>();
//        addValues(singleArray, 100000, 0, "Вствка в начало");
//        IArray<String> singleArray2 = new SingleArray<>();
//
//
//        addValues(singleArray2, 100000);
//
//        addReverseValues(singleArray2, 100000);
//
//        removeValueRoot(singleArray, 99999);
//
//        removeValueStart(singleArray2, 100000);
//        //--------------------------------------------
//
//        IArray<String> factorArray = new FactorArray<>();
//        //Вствка начало
//        addValues(factorArray, 100000, 0, "Вствка в начало");
//
//        IArray<String> factorArray2 = new FactorArray<>();
//
//        addValues(factorArray2, 100000);
//
//        addReverseValues(factorArray, 100000);
//
//        removeValueRoot(factorArray, 99999);
//
//        removeValueStart(factorArray2, 99999);
//        //--------------------------------------------
//
//        IArray<String> vectorArray = new VectorArray<>();
//
//        addValues(vectorArray, 100000, 0, "Вствка в начало");
//
//        IArray<String> vectorArray2 = new VectorArray<>();
//
//        addValues(vectorArray2, 100000);
//
//        addReverseValues(vectorArray, 100000);
//
//        removeValueRoot(vectorArray, 99999);
//
//        removeValueStart(vectorArray2, 100000);
//        //------------------------------------------------
//
//        IArray<String> matrixArray = new MatrixArray<>(100);
//
//        addValues(matrixArray, 100000);
//
//        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
//
//        priorityQueue.enqueue(5, "Я последний");
//        priorityQueue.enqueue(1, "Я выхожу первый");
//        priorityQueue.enqueue(1, "Я выхожу второй");
//        priorityQueue.enqueue(2, "Я у меня второй приоритет");
//
//        System.out.println(priorityQueue.dequeue());
//        System.out.println(priorityQueue.dequeue());
//        System.out.println(priorityQueue.dequeue());
//        System.out.println(priorityQueue.dequeue());

    }

    static private void testSingleArray(){
        IArray<String> singleArray = new SingleArray<String>();

        addValues(singleArray, 10);

        System.out.println(singleArray.size());

        singleArray.remove(9);

       // System.out.println(singleArray.get(9));

        System.out.println(singleArray.size());

        singleArray.add(9, "5: my element");

        System.out.println(singleArray.toString());

//        IArray<String> singleArray2 = new SingleArray<String>();
//        addValues(singleArray2, 100000);

    }

    static private void addValues(IArray<String> array, int count) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            array.add(i + ": Test Case");
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms " + "Вставка в конец");
    }

    static private void addValues(IArray<String> array, int count, int index, String comment) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            array.add(index, i + "");
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms " + comment);
    }

    static private void addReverseValues(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        int reverse = count;
        for (int i = 0; i < count; i++) {
            reverse--;
            array.add(reverse, i + "");
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms " + "Вставка реверс");
    }

    static private void removeValueRoot(IArray<String> array, int index) {
        long start = System.currentTimeMillis();
        while (index >= 0) {
            array.remove(index);
            index--;
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + duration + " ms Удаление с хвоста");
    }

    static private void removeValueStart(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            array.remove(0);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + duration + " ms Удаление с начала");
    }

}
