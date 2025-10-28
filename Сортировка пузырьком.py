def bubble_sort(sequence):
    """
    Реализация сортировки пузырьковым методом
    """
    # Определяем количество элементов
    count = len(sequence)
    
    # Основные проходы по массиву
    for pass_num in range(count - 1):
        
        # Сравнение соседних элементов
        for index in range(0, count - pass_num - 1):
            
            # Если элементы в неправильном порядке
            if sequence[index] > sequence[index + 1]:
                # Меняем их местами
                sequence[index], sequence[index + 1] = sequence[index + 1], sequence[index]


def improved_bubble_sort(sequence):
    """
    Улучшенная версия с проверкой упорядоченности
    """
    count = len(sequence)
    
    for pass_num in range(count - 1):
        # Флаг для отслеживания перестановок
        has_swapped = False
        
        for index in range(0, count - pass_num - 1):
            if sequence[index] > sequence[index + 1]:
                sequence[index], sequence[index + 1] = sequence[index + 1], sequence[index]
                has_swapped = True
        
        # Если перестановок не было - массив отсортирован
        if not has_swapped:
            break


# Демонстрация работы
if __name__ == "__main__":
    # Исходные данные
    original_data = [64, 34, 25, 12, 22, 11, 90]
    
    print("Начальный массив:", original_data)
    
    # Тестируем обычную версию
    data1 = original_data.copy()
    bubble_sort(data1)
    print("После обычной сортировки:", data1)
    
    # Тестируем улучшенную версию
    data2 = original_data.copy()
    improved_bubble_sort(data2)
    print("После улучшенной сортировки:", data2)
