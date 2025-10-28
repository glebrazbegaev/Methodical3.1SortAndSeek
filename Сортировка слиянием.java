import java.util.Arrays;

public class MergeSort {
    
    // Основной метод сортировки слиянием
    public static void sortByMerge(int[] array) {
        // Если массив слишком маленький - уже отсортирован
        if (array.length < 2) {
            return;
        }
        
        // Делим массив пополам
        int middle = array.length / 2;
        
        // Создаем левую и правую части
        int[] leftPart = new int[middle];
        int[] rightPart = new int[array.length - middle];
        
        // Заполняем левую часть
        for (int i = 0; i < middle; i++) {
            leftPart[i] = array[i];
        }
        
        // Заполняем правую часть
        for (int i = middle; i < array.length; i++) {
            rightPart[i - middle] = array[i];
        }
        
        // Сортируем обе части рекурсивно
        sortByMerge(leftPart);
        sortByMerge(rightPart);
        
        // Объединяем отсортированные части
        combineArrays(array, leftPart, rightPart);
    }
    
    // Объединение двух отсортированных массивов
    private static void combineArrays(int[] result, int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;
        
        // Сливаем пока есть элементы в обоих массивах
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        
        // Добавляем оставшиеся элементы из левого массива
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        
        // Добавляем оставшиеся элементы из правого массива
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
    }
    
    // Вывод массива на экран
    public static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    // Тестовый метод
    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Массив до сортировки:");
        displayArray(numbers);
        
        // Выполняем сортировку
        sortByMerge(numbers);
        
        System.out.println("Массив после сортировки:");
        displayArray(numbers);
    }
}
