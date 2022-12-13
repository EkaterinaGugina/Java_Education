package HomeWork_6_12_22;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class program {
     public static void main(String[] args) { 
        int lenArr = getValue();
        int[] arr1 = fillArray(lenArr);
        System.out.print("Составим частотный словарь для массива:");
        printArr(arr1);
        System.out.println();
        int[] uniqueValue = uniqueValue(arr1);
        int[] arrCount = arrCount(arr1, uniqueValue);
        System.out.println("Количество повторений");
        printArrResult(uniqueValue, arrCount);
        System.out.println();
    }

    static int getValue() { // Ввод пользователем числа - длины массива
        Scanner sc = new Scanner(System.in); 
        int size = sc.nextInt(); 
        sc.close();
        return size;
    }

    static int[] fillArray(int size){ // Создание массива заданной длины и заполнение его случ.числами [0,10)
        int[] newarr = new int[size];
        for (int i = 0; i < size; i++){
            newarr[i] = (int) (Math.random() * 10);
        }
        return newarr;
    }
    
    static void printArr(int[] array) { // Вывод на экран массива
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]); 
        }
        System.out.println();
    }

    static void printArrResult(int[] arr1, int[] arr2) { // Вывод частотного словаря
        for (int i = 0; i < arr1.length; i++) {         
            if (arr1[i] != -1)
                System.out.printf("Элемент %d встречается %d раз\n", arr1[i], arr2[i]);
        }
        System.out.println();
    }

    static int[] uniqueValue(int[] arr1) { // Отвечает за перебор элементов в массиве и создание массива без повторов
        int uniqueArray[] = Arrays.copyOf(arr1, arr1.length);
        for (int i = 0; i < arr1.length; i++) { // Пробегает по первому массиву
            for (int j = i + 1; j < arr1.length; j++) { // Пробегает по первому массиву со сдвигом на + 1
                if (arr1[i] == arr1[j]) {
                    uniqueArray[j] = -1; // Массив в котором повторные значения равны -1
                }
            }
        }
        return uniqueArray;
    }

    static int[] arrCount(int[] arr1, int[] uniqueArray) {
        int arrCount[] = new int[arr1.length];
        for (int i = 0; i < uniqueArray.length; i++) { 
            for (int j = 0; j < arr1.length; j++) { 
                if (arr1[i] == arr1[j]) {
                    arrCount[i]++;
                }
            }
        }
        return arrCount;
    }
}

