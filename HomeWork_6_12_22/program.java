package HomeWork_6_12_22;

public class program {
/**
 * Составление частотного словаря
*/
    public static void main(String[] args) { 
        
        int lenArr = lib.getValue();
        int[] arr1 = lib.fillArray(lenArr);
        System.out.print("Составим частотный словарь для массива:");
        lib.printArr(arr1);
        System.out.println();
        lib.dictCount(arr1);
        System.out.println();
    }
}