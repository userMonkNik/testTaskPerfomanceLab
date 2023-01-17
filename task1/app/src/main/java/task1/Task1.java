package task1;

public class Task1 {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int[] arr = iterateArray(1, m, n);

        while (arr[arr.length - 1] != 1) {

            arr = iterateArray(arr[arr.length - 1], m, n);

        }

    }

    public static int[] iterateArray(int beginElem, int arrayLength, int bound) {
        int[] arr = new int[arrayLength];

        for (int i = 0; i < arrayLength;i ++) {

            if (beginElem > bound) {
                beginElem = 1;
            }

            arr[i] = beginElem++;

            if (i == 0) {
                System.out.print(arr[i]);
            }

        }

        return arr;
    }
}
