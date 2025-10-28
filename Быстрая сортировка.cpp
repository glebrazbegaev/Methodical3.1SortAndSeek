#include <iostream>
#include <vector>
using namespace std;

// Разделение массива относительно опорного элемента
int splitArray(vector<int>& data, int start, int end) {
    // Опорный элемент - последний в segment
    int pivot = data[end];
    
    // Указатель на позицию для вставки меньших элементов
    int smallerPos = start - 1;
    
    // Перебираем элементы segment
    for (int current = start; current < end; current++) {
        // Если элемент меньше или равен опорному
        if (data[current] <= pivot) {
            smallerPos++; // Сдвигаем указатель
            // Обмен элементов
            int temp = data[smallerPos];
            data[smallerPos] = data[current];
            data[current] = temp;
        }
    }
    
    // Ставим опорный элемент на свое место
    int temp = data[smallerPos + 1];
    data[smallerPos + 1] = data[end];
    data[end] = temp;
    
    return smallerPos + 1;
}

// Реализация быстрой сортировки
void quickSort(vector<int>& data, int start, int end) {
    // Проверка на необходимость сортировки
    if (start < end) {
        // Получаем позицию опорного элемента
        int pivotIndex = splitArray(data, start, end);
        
        // Сортируем левую и правую части
        quickSort(data, start, pivotIndex - 1);
        quickSort(data, pivotIndex + 1, end);
    }
}

// Вывод элементов массива
void showArray(const vector<int>& data) {
    for (int value : data) {
        cout << value << " ";
    }
    cout << endl;
}

// Упрощенный вызов сортировки
void sortArray(vector<int>& data) {
    quickSort(data, 0, data.size() - 1);
}

int main() {
    vector<int> numbers = {10, 7, 8, 9, 1, 5, 3, 2, 4, 6};
    
    cout << "Массив до сортировки: ";
    showArray(numbers);
    
    sortArray(numbers);
    
    cout << "Массив после сортировки: ";
    showArray(numbers);
    
    return 0;
}
