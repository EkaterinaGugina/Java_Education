import java.util.Arrays;

    public class QuickSort {

        public static void main(String[] args) {
            int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
            System.out.println("Первоначальный массив: ");
            System.out.println(Arrays.toString(x));

            int start = 0;
            int finish = x.length - 1;

            quickSort(x, start, finish);
            System.out.println("Отсортированный массив: ");
            System.out.println(Arrays.toString(x));
        }

        public static void quickSort(int[] array, int start, int finish) {
            if (array.length == 0)
                return;//завершить выполнение, если длина массива равна 0

            if (start >= finish)
                return;//завершить выполнение если уже нечего делить

            // выбираем опорный элемент
            int mid = start + (finish - start) / 2;
            int elmid = array[mid];

            // делим на подмассивы, в которых большие и меньшие элементы, чем опорный
            int i = start, j = finish;
            while (i <= j) {
                while (array[i] < elmid) {
                    i++;
                }

                while (array[j] > elmid) {
                    j--;
                }

                if (i <= j) {//меняем местами элементы из разных подмассивов
                    int currant = array[i];
                    array[i] = array[j];
                    array[j] = currant;
                    i++;
                    j--;
                }
            }

        // вызов рекурсии для сортировки левой и правой части
            if (start < j)
                quickSort(array, start, j);

            if (finish > i)
                    quickSort(array, i, finish);
        }
    }