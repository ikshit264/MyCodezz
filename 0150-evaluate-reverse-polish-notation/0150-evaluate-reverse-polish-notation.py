class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        def add(a, b):
            return a + b

        def subtract(a, b):
            return a - b

        def multiply(a, b):
            return a * b

        def divide(a, b):
            # Handle division by zero
            if b == 0:
                return 0
            return int(a / b)
        def Check(i):
            a = ['+', '-', '*', '/']
            return i in a

        operations = {'+': add, '-': subtract, '*': multiply, '/': divide}
        for i in tokens:
            if not Check(i):
                stack.append(int(i))
            else:
                Operand1 = stack.pop()
                Operand2 = stack.pop()
                if i in operations:
                    result = operations[i](Operand2, Operand1)
                    stack.append(result)

        return stack[0]