import java.util.Arrays;

    public class QuickSort {

        public static void main(String[] args) {
            
            int lenArr = lib.getValue();
            int[] arrayForSorted = lib.fillArray(lenArr);
            System.out.println("Первоначальный массив: ");
            System.out.println(Arrays.toString(arrayForSorted));

            int start = 0;
            int finish = arrayForSorted.length - 1;

            lib.quickSort(arrayForSorted, start, finish);
            System.out.println("Отсортированный массив: ");
            System.out.println(Arrays.toString(arrayForSorted));
        }
    }