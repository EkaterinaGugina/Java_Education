package HomeWork_6_12_22;

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

    static boolean elemInArr(int elem, int[] arr){ 
        /**
        * Выяснение наличия элемента в массиве
         */ 
        boolean numExists = false;
        for (int i = 0; i < arr.length; i++) {
            if (elem == arr[i]){
                numExists = true;
                break;
            }
        }
        if (!numExists) return false;
        else return true;
    }

    static void seachCountElem(int elem, int[] arr){ 
        /**
        * Подсчет повторений элемента в массиве
        */
        int countDifEl = 0;
        for (int i = 0; i < arr.length; i++){
            if (elem == arr[i])
            countDifEl++;
        }
        if (countDifEl != 0){
        System.out.printf("Элемент %d втречается %d раз(а)\n", elem, countDifEl);
        }
    }

    static void dictCount(int[] array){
        /**
        * Создание массива всех различных элементов и вывод частотного словаря
         */

        int[] resArray = new int[array.length]; // Массив для эл-тов, кол-во повторений которых будем считать
        for(int i = 0; i < array.length; i++){
            boolean flag = elemInArr(array[i], resArray);
            if (!flag){
                seachCountElem(array[i], array);
                resArray[i] = array[i];
            }
        } 
    }

}
