def sequential_search(items, value_to_find):
    """
    Функция последовательного поиска элемента в списке
    """
    # Перебираем все элементы по порядку
    for index in range(len(items)):
        # Проверяем совпадение с искомым значением
        if items[index] == value_to_find:
            return index
    # Возвращаем -1 если значение не обнаружено
    return -1

# Демонстрация работы
data = [3, 5, 2, 7, 9, 1, 4]
search_value = 7

found_index = sequential_search(data, search_value)

if found_index != -1:
    print(f"Найден на позиции {found_index}")
else:
    print("Не найден")
