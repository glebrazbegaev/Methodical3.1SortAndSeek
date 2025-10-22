def linear_search(arr, target):
    for i in range(len(arr)):
        if arr[i] == target:
            return i
    return -1

arr = [3, 5, 2, 7, 9, 1, 4]
target = 7
result = linear_search(arr, target)
if result != -1:
    print(f"Элемент найден на позиции: {result}")
else:
    print("Элемент не найден")