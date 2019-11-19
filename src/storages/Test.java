package storages;

import storages.arrays.*;
import storages.others.*;

public class Test {

    public static void main(String[] args) {

        testSingleArray();
        testFactorArray();
        testVectorArray();
        testMatrixArray();

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(5);

        priorityQueue.enqueue(5, "Я последний");
        priorityQueue.enqueue(1, "Я выхожу первый");
        priorityQueue.enqueue(1, "Я выхожу второй");
        priorityQueue.enqueue(2, "Я у меня второй приоритет");

        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());

    }

    static private void testSingleArray() {

        IArray<String> testArray = new SingleArray<String>();

        if (!TestCase.checkAddGetRemove(testArray)
                || !TestCase.addBackElements(testArray)
                || !TestCase.addFrontElements(testArray)
        ) {
            return;
        }

        int count = 100000;
        IArray<String> singleArrayFront = new SingleArray<String>();
        IArray<String> singleArrayBack = new SingleArray<String>();

        TestCase.addValuesFrontPerformance(singleArrayFront, count);
        TestCase.addValuesBackPerformance(singleArrayBack, count);

        TestCase.getValuesFrontPerformance(singleArrayFront, count);
        TestCase.getValuesBackPerformance(singleArrayBack, count);

        TestCase.removeFrontPerformance(singleArrayFront, count);
        TestCase.removeBackPerformance(singleArrayBack, count);
    }

    static private void testFactorArray() {

        IArray<String> testArray = new FactorArray<>();

        if (!TestCase.checkAddGetRemove(testArray)
                || !TestCase.addBackElements(testArray)
                || !TestCase.addFrontElements(testArray)
        ) {
            return;
        }

        int count = 100000;
        IArray<String> singleArrayFront = new FactorArray<>();
        IArray<String> singleArrayBack = new FactorArray<String>();

        TestCase.addValuesFrontPerformance(singleArrayFront, count);
        TestCase.addValuesBackPerformance(singleArrayBack, count);

        TestCase.getValuesFrontPerformance(singleArrayFront, count);
        TestCase.getValuesBackPerformance(singleArrayBack, count);

        TestCase.removeFrontPerformance(singleArrayFront, count);
        TestCase.removeBackPerformance(singleArrayBack, count);
    }

    static private void testVectorArray() {

        IArray<String> testArray = new VectorArray<>();

        if (!TestCase.checkAddGetRemove(testArray)
                || !TestCase.addBackElements(testArray)
                || !TestCase.addFrontElements(testArray)
        ) {
            return;
        }

        int count = 100000;
        IArray<String> singleArrayFront = new VectorArray<>();
        IArray<String> singleArrayBack = new VectorArray<>();

        TestCase.addValuesFrontPerformance(singleArrayFront, count);
        TestCase.addValuesBackPerformance(singleArrayBack, count);

        TestCase.getValuesFrontPerformance(singleArrayFront, count);
        TestCase.getValuesBackPerformance(singleArrayBack, count);

        TestCase.removeFrontPerformance(singleArrayFront, count);
        TestCase.removeBackPerformance(singleArrayBack, count);
    }

    static private void testMatrixArray() {

        IArray<String> testArray = new MatrixArray<>(100);

        if (!TestCase.checkAddGetRemove(testArray)
                || !TestCase.addBackElements(testArray)
                || !TestCase.addFrontElements(testArray)
        ) {
            return;
        }

        int count = 100000;
        IArray<String> singleArrayFront = new MatrixArray<>(100);
        IArray<String> singleArrayBack = new MatrixArray<>(100);

        TestCase.addValuesFrontPerformance(singleArrayFront, count);
        TestCase.addValuesBackPerformance(singleArrayBack, count);

        TestCase.getValuesFrontPerformance(singleArrayFront, count);
        TestCase.getValuesBackPerformance(singleArrayBack, count);

        TestCase.removeFrontPerformance(singleArrayFront, count);
        TestCase.removeBackPerformance(singleArrayBack, count);
    }
}
