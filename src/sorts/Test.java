package sorts;

public class Test {
    public static void main(String[] args) {

        int[] array = {1,5,6,8,9,5,1,56,45,4,11,89,67,3};

        new HeapSort(array);

        for (int i : array) {
            System.out.println(i);
        }
    }
}
