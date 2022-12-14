import java.util.Scanner;
import java.lang.Math;

public class lib {
    
    static int getValue() {
        /**
        * Ввод пользователем числа - длины массива
         */ 
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число - размер массива"); 
        int size = sc.nextInt(); 
        sc.close();
        return size;
    }

    static int[] fillArray(int size){ 
        /**
        *Создание массива заданной длины и заполнение его случ.числами [0,10)
        */ 
        int[] newarr = new int[size];
        for (int i = 0; i < size; i++){
            newarr[i] = (int) (1 + Math.random() * 9);
        }
        return newarr;
    }
    
    static void quickSort(int[] array, int start, int finish) {
        /**
        * Быстрая сортировка
         */
            if ((array.length == 0) || (start >= finish))
                return;   //завершить, если длина массива = 0 или все элементы переставлены по соотв.частям отн-но среднего 

            // выбираем "опорный" элемент - средний по порядку
            int mid = (finish + start) / 2;
            int elmid = array[mid];

            // делим на подмассивы, в которых элементы соотв. больше и меньше, чем опорный
            int i = start, j = finish;
            while (i <= j) {
                while (array[i] < elmid) {
                    i++;
                }

                while (array[j] > elmid) {
                    j--;
                }

                if (i <= j) {//меняем местами элементы из разных подмассивов, если они не в "своём" подмассиве
                    int currant = array[i];
                    array[i] = array[j];
                    array[j] = currant;
                    i++;
                    j--;
                }
            }
        // вызов рекурсии для сортировки левого и правого подмассивов
            if (start < j)
                quickSort(array, start, j);

            if (finish > i)
                    quickSort(array, i, finish);
        }

    static void printArr(int[] array) {
        /**
        * Вывод на экран массива
        */
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]); 
        }
        System.out.println();
    }
}
