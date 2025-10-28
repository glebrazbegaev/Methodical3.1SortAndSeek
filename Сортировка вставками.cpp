#include <iostream>
using namespace std;

// Сортировка методом вставок
void sortByInsertion(int data[], int size) {
    // Обрабатываем элементы начиная со второго
    for (int current = 1; current < size; current++) {
        // Запоминаем текущий элемент для вставки
        int valueToInsert = data[current];
        
        // Ищем позицию для вставки в отсортированной части
        int position = current - 1;
        
        // Сдвигаем элементы больше вставляемого
        while (position >= 0 && data[position] > valueToInsert) {
            data[position + 1] = data[position];
            position--;
        }
        
        // Вставляем элемент на найденное место
        data[position + 1] = valueToInsert;
    }
}

// Вывод элементов массива
void displayArray(int data[], int size) {
    for (int i = 0; i < size; i++) {
        cout << data[i] << " ";
    }
    cout << endl;
}

int main() {
    // Исходные данные
    int numbers[] = {12, 11, 13, 5, 6};
    
    // Определяем количество элементов
    int count = sizeof(numbers) / sizeof(numbers[0]);
    
    // Показываем исходный массив
    cout << "До сортировки: ";
    displayArray(numbers, count);
    
    // Выполняем сортировку
    sortByInsertion(numbers, count);
    
    // Показываем результат
    cout << "После сортировки: ";
    displayArray(numbers, count);
    
    return 0;
}
