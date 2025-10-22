def fibonacci_search(arr, target):
    n = len(arr)
    fib2 = 0
    fib1 = 1
    fib = fib2 + fib1
    
    while fib < n:
        fib2 = fib1
        fib1 = fib
        fib = fib2 + fib1
    
    offset = -1
    
    while fib > 1:
        i = min(offset + fib2, n - 1)
        
        if arr[i] < target:
            fib = fib1
            fib1 = fib2
            fib2 = fib - fib1
            offset = i
        elif arr[i] > target:
            fib = fib2
            fib1 = fib1 - fib2
            fib2 = fib - fib1
        else:
            return i
    
    if fib1 == 1 and offset + 1 < n and arr[offset + 1] == target:
        return offset + 1
    
    return -1

arr = [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
target = 85
result = fibonacci_search(arr, target)
if result != -1:
    print(f"Элемент найден на позиции: {result}")
else:
    print("Элемент не найден")