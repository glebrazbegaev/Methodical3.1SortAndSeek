def shell_sort(sequence):
    """
    Реализация сортировки методом Шелла
    """
    # Определяем размер последовательности
    size = len(sequence)
    
    # Начальный шаг сравнения
    step = size // 2
    
    # Продолжаем пока шаг больше нуля
    while step > 0:
        
        # Обрабатываем элементы с текущим шагом
        for current in range(step, size):
            # Запоминаем текущее значение
            current_value = sequence[current]
            position = current
            
            # Сдвигаем элементы, превышающие текущее значение
            while position >= step and sequence[position - step] > current_value:
                sequence[position] = sequence[position - step]
                position -= step
            
            # Вставляем значение на найденное место
            sequence[position] = current_value
        
        # Уменьшаем шаг в два раза
        step //= 2


def knuth_shell_sort(sequence):
    """
    Улучшенная сортировка Шелла с последовательностью Кнута
    """
    size = len(sequence)
    
    # Вычисляем максимальный шаг по Кнуту
    step = 1
    while step < size // 3:
        step = 3 * step + 1
    
    # Выполняем сортировку с уменьшением шага
    while step > 0:
        for current in range(step, size):
            current_value = sequence[current]
            position = current
            
            while position >= step and sequence[position - step] > current_value:
                sequence[position] = sequence[position - step]
                position -= step
            
            sequence[position] = current_value
        
        # Уменьшаем шаг по формуле Кнута
        step //= 3


# Функция для отображения массива
def show_sequence(sequence):
    """Выводит элементы последовательности"""
    print(" ".join(str(x) for x in sequence))


# Тестирование алгоритмов
if __name__ == "__main__":
    # Исходные данные
    original = [12, 34, 54, 2, 3, 1, 89, 45, 23]
    
    print("Исходная последовательность:")
    show_sequence(original)
    
    # Тестируем базовую версию
    test1 = original.copy()
    shell_sort(test1)
    print("\nБазовая сортировка Шелла:")
    show_sequence(test1)
    
    # Тестируем версию Кнута
    test2 = original.copy()
    knuth_shell_sort(test2)
    print("Сортировка Шелла-Кнута:")
    show_sequence(test2)
