import java.lang.Math;


public class Main {

    private static int findSmallestTrialgleSum(int[][] trinagleArray) {
        int sum = 0;
        int[] currentRow = new int[0];
        int[] previousRow;

        System.out.println("Printing triangle of paths lengths");
        previousRow = copyArray(trinagleArray[0]);
        for (int i = 1; i < trinagleArray.length; i++) {
            currentRow = copyArray(trinagleArray[i]);
            for (int j = 0; j < currentRow.length; j++) {
                if (j == 0) {
                    currentRow[j] += previousRow[j];
                } else if (j == currentRow.length - 1) {
                    currentRow[j] += previousRow[j - 1];
                } else {
                    currentRow[j] += Math.min(previousRow[j], previousRow[j - 1]);
                }
                System.out.print(currentRow[j]+ " ");
            }
            System.out.println();
            previousRow = currentRow;
        }

        return getMin(currentRow);
    }


    private static int[] copyArray(int[] srcArray) {
        int[] dest = new int[srcArray.length];
        System.arraycopy(srcArray, 0, dest, 0, srcArray.length);
        return dest;
    }


    // Method for getting the minimum value
    public static int getMin(int[] inputArray){
        int minValue = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
            }
        }
        return minValue;
    }


    public static void main(String[] args) {

        int[][] trinagleArray = new int[6][];
        trinagleArray[0] = new int[]{3};
        trinagleArray[1] = new int[]{2, 4};
        trinagleArray[2] = new int[]{1, 9, 3};
        trinagleArray[3] = new int[]{9, 9, 2, 4};
        trinagleArray[4] = new int[]{4, 6, 6, 7, 8};
        trinagleArray[5] = new int[]{5, 7, 3, 5, 1, 4};

        System.out.println(findSmallestTrialgleSum(trinagleArray));



    }


}
