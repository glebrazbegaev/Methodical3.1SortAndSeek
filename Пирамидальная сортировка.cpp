public class HeapSort {
    
    // Главный метод сортировки кучей
    public static void sortWithHeap(int[] array) {
        int size = array.length;
        
        // Строим максимальную кучу из массива
        // Начинаем с середины и идем к началу
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjustHeap(array, size, i);
        }
        
        // По одному извлекаем элементы из кучи
        for (int i = size - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            // Восстанавливаем свойства кучи для уменьшенного массива
            adjustHeap(array, i, 0);
        }
    }
    
    // Настройка поддерева с корнем в заданной позиции
    private static void adjustHeap(int[] array, int heapSize, int rootIndex) {
        int maxIndex = rootIndex;     // Считаем корень наибольшим
        int leftChild = 2 * rootIndex + 1;   // Левый потомок
        int rightChild = 2 * rootIndex + 2;  // Правый потомок
        
        // Если левый потомок существует и больше текущего максимума
        if (leftChild < heapSize && array[leftChild] > array[maxIndex]) {
            maxIndex = leftChild;
        }
        
        // Если правый потомок существует и больше текущего максимума
        if (rightChild < heapSize && array[rightChild] > array[maxIndex]) {
            maxIndex = rightChild;
        }
        
        // Если максимум не в корне
        if (maxIndex != rootIndex) {
            // Меняем местами корень с наибольшим потомком
            int temp = array[rootIndex];
            array[rootIndex] = array[maxIndex];
            array[maxIndex] = temp;
            
            // Рекурсивно настраиваем затронутое поддерево
            adjustHeap(array, heapSize, maxIndex);
        }
    }
    
    // Тестовый метод
    public static void main(String[] args) {
        int[] numbers = {12, 11, 13, 5, 6, 7};
        
        System.out.print("Массив до сортировки: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        
        sortWithHeap(numbers);
        
        System.out.print("\nМассив после сортировки: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
