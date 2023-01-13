package Practicum_06_12_22;

// list.remove(индекс);  - удаление
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;


public class program1 {
     public static void main (String[] args){
        // int[] a = createArray(8);
        // lenArray();
        System.out.println();
        // System.out.println(Arrays.toString(a));
        
       }
    static int lenArray (){ 
        Scanner input = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = input.nextInt();
        input.close();
        try {
            //  String преобразуется в int
            int lenArr = Integer.parseInt();
            // выведем на экран значение после конвертации
            System.out.println("lenArray = " + lenArr);
        } catch (NumberFormatException nfe){
            System.err.println("Неправильный формат строки!");
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return len;
    }


    // static int[] createArray (int count){
    //     int[] newarr = new int[count];
    //     for (int i = 0; i < count; i++){
    //         newarr[i] = (int) (Math.random() * 10);
    //     }
    //     return newarr;
    // }

    // static void printArray (int [] array) {
    //     // System.out.println(Arrays.toString(array));
    //     for (int i = 0; i < array.length; i++){
    //         System.out.printf("%d ", array[i]);
    //     }
    // }

    // static void fill (int [] array) {

    // }

    // static int[] getValue (String text) {
    //     return -1;
    // }
    
   
}

// String str = "abc";
// char data[] = {'a', 'b', 'c'};
//      String str = new String(data);

//     public static void main(String[] args) { // точка входа

//        int[] arr1 = { 1, 9, 9, 0, 2, 8, 0, 9 };
        
//         System.out.println(arr1.length); // 5
    
static boolean elemInArr(int elem, int[] arr){     // Метод, определяющий наличие элемента в массиве
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

static void seachElem(int elem, int[] arr){     // Метод считает кол-во повторений элемента в массиве
    int countDifEl = 0;
    for (int i = 1; i < arr.length; i++){
        if (elem == arr[i])
        countDifEl++;
    }
    if (countDifEl != 0){
    System.out.printf("Элемент %d втречается ровно %d раз\n", elem, countDifEl);
    }
}


//Ex57: Составить частотный словарь элементов двумерного массива. Частотный словарь содержит информацию о том, сколько раз встречается элемент входных данных.

// 1 СПОСОБ - найти самый> и самый< элементы и циклом от них подсчитать сколько кто встретился раз

// int m = new Random().Next(1, 10);
// int n = new Random().Next(1, 10);
// int[,] array = new int[m, n];
// int max = array[0,0];
// int min = array[0,0];
// for (int i = 0; i < array.GetLength(0); i++)
// {
//     for (int j = 0; j < array.GetLength(1); j++)
//     {
//         array[i, j] = new Random().Next(1, 10);
//         Console.Write($"{array[i, j]}\t");
//         if (array[i, j] > max) max = array[i, j];
//         if (array[i, j] < min) min = array[i, j];
//     }
//     Console.WriteLine();
// }
// for (int z = min; z <= max; z++)
// {
//     int count = 0;
//     for (int i = 0; i < array.GetLength(0); i++)
//     {
//         for (int j = 0; j < array.GetLength(1); j++)
//         {
//            if (array[i, j] == z) count++;
//         }
//     }
//     if (count != 0) Console.WriteLine($"'{z}' - {count} раз");

static boolean elemInArr(int elem, int[] arr){     // Метод, определяющий наличие элемента в массиве
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

    static void seachElem(int elem, int[] arr){     // Метод считает кол-во повторений элемента в массиве
        int countDifEl = 0;
        for (int i = 1; i < arr.length; i++){
            if (elem == arr[i])
            countDifEl++;
        }
        if (countDifEl != 0){
        System.out.printf("Элемент %d втречается  %d раз\n", elem, countDifEl);
        }
    }




// ВТОРОЙ СПОСОБ - ОБЩИЙ ПОДХОД


// void ShowCountOfRepetitons(int number, int[,] matrix)       // Метод, определяющий количество повторений определенного элемента в массиве
// {
//     int count = 0;
//     for (int i = 0; i < matrix.GetLength(0); i++)
//     {
//         for (int j = 0; j < matrix.GetLength(1); j++)
//         {
//             if (number == matrix[i, j]) count++;
//         }
//     }
//     Console.WriteLine($"Элемент {number} встречается {count} раз");
// }

// var rand = new Random();
// int rows = rand.Next(2, 10);
// int cols = rand.Next(2, 10);
// int[,] numbers = new int[rows, cols];
// // FillMatrix(numbers);
// // PrintMatrix(numbers);
// // Console.WriteLine();

// int[,] usedValues = new int[rows, cols];       // Массив для значений элементов, количество повторений которых мы уже посчитали
// bool valueUsed;
// for (int i = 0; i < numbers.GetLength(0); i++)
// {
//     for (int j = 0; j < numbers.GetLength(1); j++)
//     {
//         valueUsed = ValueWasUsed(numbers[i, j], usedValues);
//         if (!valueUsed)
//         {
//             ShowCountOfRepetitons(numbers[i, j], numbers);
//             usedValues[i, j] = numbers[i, j];
//         }
//     }
// }



// СОЗДАНИЕ МАССИВА (ЗАПОЛНЕНИЕ РАНДОМНЫМИ ЧИСЛАМИ), ВЫВОД НА ЭКРАН
// int m = new Random().Next(1, 10);
// int n = new Random().Next(1, 10);
// int[,] array = new int[m, n];
// for (int i = 0; i < array.GetLength(0); i++)
// {
//     for (int j = 0; j < array.GetLength(1); j++)
//     {
//         array[i, j] = new Random().Next(1, 10);
//         Console.Write($"{array[i, j]}\t");
//     }
//     Console.WriteLine();
// }

    

// СОРТИРОВКА  МАССИВА и подсчет разности макс. и мин. эл.-тов массива
// double DiffMinMax(double[] arr)   // СОРТИРОВКА  МАССИВА и подсчет разности макс. и мин. эл.-тов массива
// {
//     int N = arr.Length - 1;
//     for (int i = 0; i < N; i++)
//     {
//         int position_min = i;
//         for (int j = i + 1; j <= N; j++)
//         {
//             if (arr[j] < arr[position_min])
//                 {
//                     position_min = j;
//                 }
//         }
//         double min = arr[i];
//         arr[i] = arr[position_min];
//         arr[position_min] = min;
//     }
//     PrintArray(arr);
//     return (arr[N] - arr[0]);
// }
// 


