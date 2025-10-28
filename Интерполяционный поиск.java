public class InterpolationSearch {
    
    // Поиск с интерполяцией (рекурсивный вариант)
    public static int searchInterpolation(int[] array, int start, int end, int target) {
        // Проверяем допустимость границ и наличие target в диапазоне
        if (start <= end && target >= array[start] && target <= array[end]) {
            
            // Вычисляем предполагаемую позицию
            int estimatedPos = start + ((target - array[start]) * (end - start)) 
                             / (array[end] - array[start]);
            
            // Проверяем найденный элемент
            if (array[estimatedPos] == target) {
                return estimatedPos;
            }
            
            // Ищем в правой части если target больше
            if (array[estimatedPos] < target) {
                return searchInterpolation(array, estimatedPos + 1, end, target);
            }
            
            // Ищем в левой части если target меньше
            if (array[estimatedPos] > target) {
                return searchInterpolation(array, start, estimatedPos - 1, target);
            }
        }
        
        // Элемент не обнаружен
        return -1;
    }
    
    // Поиск с интерполяцией (циклический вариант)
    public static int searchInterpolationCyclic(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        // Продолжаем пока границы valid и target в диапазоне
        while (left <= right && target >= array[left] && target <= array[right]) {
            // Рассчитываем ожидаемую позицию
            int guessIndex = left + ((target - array[left]) * (right - left)) 
                           / (array[right] - array[left]);
            
            // Проверяем угаданную позицию
            if (array[guessIndex] == target) {
                return guessIndex;
            }
            
            // Сдвигаем левую границу если target справа
            if (array[guessIndex] < target) {
                left = guessIndex + 1;
            } 
            // Сдвигаем правую границу если target слева
            else {
                right = guessIndex - 1;
            }
        }
        
        // Элемент не найден
        return -1;
    }
}
