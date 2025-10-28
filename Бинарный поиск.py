def binary_search(collection, search_value):
    """
    Осуществляет двоичный поиск в упорядоченной коллекции.
    
    Параметры:
        collection: упорядоченный список элементов
        search_value: значение для поиска
    
    Возвращает:
        int: позицию элемента или -1 при отсутствии
    """
    start = 0                      # Начало диапазона поиска
    end = len(collection) - 1      # Конец диапазона поиска
    
    while start <= end:            # Пока диапазон не пуст
        center = (start + end) // 2  # Определяем центральный индекс
        
        if collection[center] == search_value:  # Значение найдено
            return center
        elif collection[center] < search_value: # Искомое значение справа
            start = center + 1
        else:                       # Искомое значение слева
            end = center - 1
    
    return -1                      # Значение не обнаружено
