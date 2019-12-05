package sorts;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Program {

    public static void main(String[] args) throws IOException {

        int blockSize = 1024;
        long start = System.currentTimeMillis();
        prepareMerge(1000000, blockSize);
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms " + "разрезать на кусочки");

        start = System.currentTimeMillis();
        String name = mergeFiles(blockSize);
        duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms " + "отсортировать");

        System.out.println("--------" + name + "------------");

        String fileName = "file" + name + ".dat";

        RandomAccessFile readFile = new RandomAccessFile(fileName, "r");
        int i = 0;
        int j = 0;
        int ch = readFile.read();
        while (ch != -1) {
            int k = (int) getChar(ch, readFile.read());
            System.out.println(k);
            if (k == 0) {
                j++;
            }
            ch = readFile.read();
            i++;
        }
        System.out.println("result count =>" + i + "| 0000 =>" + j);
    }

    static char getChar(int ch1, int ch2) {
        return (char) ((ch1 << 8) + (ch2));
    }

    static void prepareMerge(int length, int N) throws IOException {

        Random random = new Random();
        HeapSort heapSort = new HeapSort();

        RandomAccessFile dataFile = new RandomAccessFile("file.dat", "rw");
        for (int i = 0; i < length + 1; i++) {
            dataFile.writeChar((char) random.nextInt(100));
        }
        dataFile.seek(0);

        RandomAccessFile A = new RandomAccessFile("fileA.dat", "rw");
        RandomAccessFile B = new RandomAccessFile("fileB.dat", "rw");

        char[] array = new char[N];
        String currentFile = "A";
        int i = 0;
        int ch = dataFile.read();
        int end = 0;
        while (ch != -1) {
            array[i] = getChar(ch, dataFile.read());

            if (i == N - 1 || end == length) {
                heapSort.setArray(array);
                heapSort.sort();
                for (char c : array) {
                    if (currentFile.equals("A")) {
                        A.writeChar(c);
                    } else {
                        B.writeChar(c);
                    }
                }
                if (currentFile.equals("A")) {
                    currentFile = "B";
                } else {
                    currentFile = "A";
                }
                array = new char[N];
                i = 0;
                ch = dataFile.read();
                end++;
                continue;
            }
            ch = dataFile.read();
            end++;
            i++;
        }
        A.close();
        B.close();
        dataFile.close();
    }

    static String mergeFiles(int blockSize) throws IOException {
        RandomAccessFile A = new RandomAccessFile("fileA.dat", "rw");

        RandomAccessFile B = new RandomAccessFile("fileB.dat", "rw");

        RandomAccessFile C = new RandomAccessFile("fileC.dat", "rw");

        RandomAccessFile D = new RandomAccessFile("fileD.dat", "rw");

        RandomAccessFile readFile1 = A;
        RandomAccessFile readFile2 = B;
        RandomAccessFile outputFile = C;

        blockSize = blockSize / 2;
        String currentOutput = "C";
        String input1 = "A";

        while (true) {

            while (currentOutput != "swap") {
                currentOutput = merge(blockSize, currentOutput, readFile1, readFile2, outputFile);
                if (currentOutput == "A") {
                    currentOutput = "B";
                    outputFile = B;
                } else if (currentOutput == "B") {
                    currentOutput = "A";
                    outputFile = A;
                } else if (currentOutput == "C") {
                    currentOutput = "D";
                    outputFile = D;
                } else if (currentOutput == "D") {
                    currentOutput = "C";
                    outputFile = C;
                }
            }

            blockSize = blockSize * 2;
            if (input1 == "A") {

                C.seek(0);
                if (C.read() == -1) {
                    currentOutput = "D";
                    break;
                }
                C.seek(0);
                readFile1 = C;

                D.seek(0);
                if (D.read() == -1) {
                    currentOutput = "C";
                    break;
                }
                D.seek(0);
                readFile2 = D;

                A.setLength(0);
                B.setLength(0);
                outputFile = A;
                currentOutput = "A";
                input1 = "C";
            } else {
                A.seek(0);
                if (A.read() == -1) {
                    currentOutput = "B";
                    break;
                }
                A.seek(0);
                readFile1 = A;

                B.seek(0);
                if (B.read() == -1) {
                    currentOutput = "A";
                    break;
                }
                B.seek(0);
                readFile2 = B;

                C.setLength(0);
                D.setLength(0);
                outputFile = C;
                currentOutput = "C";
                input1 = "A";
            }
        }
        return currentOutput;
    }

    static String merge(int blockSize, String currentOutput, RandomAccessFile input1, RandomAccessFile input2, RandomAccessFile output) throws IOException {

        long pointer1 = input1.getFilePointer();
        long pointer2 = input2.getFilePointer();

        int in1 = input1.read();
        int in2 = input2.read();

        int readA = 0;
        int readB = 0;
        while (readA < blockSize && readB < blockSize && in1 != -1 && in2 != -1) {
            pointer1 = input1.getFilePointer();
            pointer2 = input2.getFilePointer();
            char ch1 = getChar(in1, input1.read());
            char ch2 = getChar(in2, input2.read());

            if (ch1 < ch2) {
                input2.seek(pointer2);
                output.writeChar(ch1);
                pointer1 = input1.getFilePointer();
                in1 = input1.read();
                readA++;
            } else {
                input1.seek(pointer1);
                output.writeChar(ch2);
                pointer2 = input2.getFilePointer();
                in2 = input2.read();
                readB++;
            }
        }

        while (readA < blockSize && in1 != -1) {
            char ch1 = getChar(in1, input1.read());
            output.writeChar(ch1);
            readA++;
            pointer1 = input1.getFilePointer();
            in1 = input1.read();
        }
        while (readB < blockSize && in2 != -1) {
            char ch2 = getChar(in2, input2.read());
            output.writeChar(ch2);
            readB++;
            pointer2 = input2.getFilePointer();
            in2 = input2.read();
        }

        if (in1 == -1 && in2 == -1) {
            return "swap";
        } else {
            input1.seek(pointer1);
            input2.seek(pointer2);
            return currentOutput;
        }
    }
}


