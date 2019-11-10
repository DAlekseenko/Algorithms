package storages;

import storages.arrays.IArray;

class TestCase {

    static boolean checkAddGetRemove(IArray<String> array) {

        if (testAdd(array)) {
            System.out.println("array size ok");
        } else {
            System.out.println("array size fail");
            return false;
        }

        if (testGet(array, 5)) {
            System.out.println("get by index ok");
        } else {
            System.out.println("get by index failed");
            return false;
        }
        if (testRemove(array)) {
            System.out.println("remove by index ok");
        } else {
            return false;
        }

        return true;
    }

    static private boolean testAdd(IArray<String> array) {
        int size1 = array.size();

        for (int i = 0; i < 4; i++) {
            array.add(i + "Test Case");
        }
        int size2 = array.size();
        array.add(3, "add by index");
        int size3 = array.size();

        return size1 == 0 && size2 == 4 && size3 == 5;
    }

    static private boolean testGet(IArray<String> array, int n) {
        for (int i = 0; i < n; i++) {
            String text = i + "Test Case";
            if (i == 3) {
                text = "add by index";
            }
            if(i == 4){
                text = i - 1 + "Test Case";
            }
            if (!array.get(i).equals(text)) {
                return false;
            }
        }
        return true;
    }

    static private boolean testRemove(IArray<String> array) {
        for (int i = 4; i >= 0; i--) {
            String text = i + "Test Case";
            if (i == 3) {
                text = "add by index";
            }
            if(i == 4){
                text = i - 1 + "Test Case";
            }
            if (!array.remove(i).equals(text)) {
                System.out.println("remove by index failed wrong element");
                return false;
            }
            if (!testGet(array, i)) {
                System.out.println("remove by index failed wrong get");
                return false;
            }
            if (array.size() != i) {
                System.out.println("remove by index failed wrong size");
                return false;
            }
        }
        return true;
    }

    static private void addBack(IArray<String> array, int n){
        for (int i = 0; i < n; ++i) {
            array.add(i + "Test Case");
        }
    }
    static boolean addBackElements(IArray<String> array){
        addBack(array,100);
        for (int j = 0; j < 100; ++j) {
            if (!array.get(j).equals(j + "Test Case")) {
                System.out.println("back insert failed");
                return false;
            }
        }
        System.out.println("back insert ok");
        return true;
    }

    static private void addFront(IArray<String> array, int n){
        for (int i = 0; i < n; ++i) {
            array.add(i,i + "Test Case");
        }
    }

    static boolean addFrontElements(IArray<String> array){
        addFront(array,100);
        for (int j = 0; j < 100; ++j) {
            if (!array.get(j).equals(j + "Test Case")) {
                System.out.println("back insert failed");
                return false;
            }
        }
        System.out.println("front insert ok");
        return true;
    }

    static void addValuesFrontPerformance(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        addFront(array,count);
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms " + "Вставка в начало");
    }

    static void addValuesBackPerformance(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        addBack(array,count);
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms "  + "Вставка в конец");
    }

    static void getValuesFrontPerformance(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; ++i) {
            array.get(0);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms " + "Чтение из начала");
    }

    static void getValuesBackPerformance(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; ++i) {
            array.get(count - 1);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms " + "Чтение c конца");
    }

    static void removeFrontPerformance(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; ++i) {
            array.remove(0);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms " + "Удаление из начала");
    }

    static void removeBackPerformance(IArray<String> array, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; ++i) {
            array.remove(array.size() - 1);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(array + " " + count + " " + duration + " ms " + "Удаление из конца");
    }

}
