public class FibonacciSearch {
    
    public static int findWithFibonacci(int[] numbers, int target) {
        int length = numbers.length;
        
        // Подготовка чисел Фибоначчи
        int fibPrev = 0;      // F(k-2)
        int fibCurrent = 1;   // F(k-1)
        int fibNext = fibPrev + fibCurrent;  // F(k)
        
        // Находим подходящее число Фибоначчи
        while (fibNext < length) {
            fibPrev = fibCurrent;
            fibCurrent = fibNext;
            fibNext = fibPrev + fibCurrent;
        }
        
        int position = -1;
        
        // Поиск в массиве
        while (fibNext > 1) {
            // Вычисляем проверяемый индекс
            int checkIndex = Math.min(position + fibPrev, length - 1);
            
            if (numbers[checkIndex] < target) {
                // Искомый элемент справа
                fibNext = fibCurrent;
                fibCurrent = fibPrev;
                fibPrev = fibNext - fibCurrent;
                position = checkIndex;
            } else if (numbers[checkIndex] > target) {
                // Искомый элемент слева
                fibNext = fibPrev;
                fibCurrent = fibCurrent - fibPrev;
                fibPrev = fibNext - fibCurrent;
            } else {
                // Элемент найден
                return checkIndex;
            }
        }
        
        // Проверка последнего возможного элемента
        if (fibCurrent == 1 && position + 1 < length && 
            numbers[position + 1] == target) {
            return position + 1;
        }
        
        // Элемент не обнаружен
        return -1;
    }
}
