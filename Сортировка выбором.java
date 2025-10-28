public class SelectionSort {
    
    // Реализация сортировки выбором
    public static void sortBySelection(int[] numbers) {
        // Проходим по всем позициям массива
        for (int current = 0; current < numbers.length - 1; current++) {
            // Считаем текущий элемент наименьшим
            int minPosition = current;
            
            // Ищем минимальный элемент в оставшейся части
            for (int next = current + 1; next < numbers.length; next++) {
                // Если нашли элемент меньше текущего минимального
                if (numbers[next] < numbers[minPosition]) {
                    minPosition = next;
                }
            }
            
            // Меняем местами минимальный элемент с текущим
            int temporary = numbers[minPosition];
            numbers[minPosition] = numbers[current];
            numbers[current] = temporary;
        }
    }
    
    // Метод для отображения массива
    public static void displayArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
    
    // Основной метод программы
    public static void main(String[] args) {
        // Тестовый набор данных
        int[] data = {64, 25, 12, 22, 11};
        
        // Показываем исходные данные
        System.out.print("Массив до сортировки: ");
        displayArray(data);
        
        // Выполняем сортировку
        sortBySelection(data);
        
        // Показываем результат
        System.out.print("Массив после сортировки: ");
        displayArray(data);
    }
}
