#include<iostream>

using namespace std;

class Stack {

    int top;
    int len;
    int *arr;

  public:

    Stack(int l) {

        len = l;
        arr = new int[len];
        top = -1;
    } // end of constructor

    bool isEmpty() { return (top == -1); } // end of isEmpty()

    bool isFull() { return (top == (len - 1)); } // end of isFull

  void push(int val) {

    if (isFull()) {
      cout << "stack overflow" << endl;
    } 
    else {
      arr[++top] = val;
    }
  } // end of push()

  int pop() {

    if (isEmpty()) {

      cout << "stack underflow" << endl;
      return 0;
    } 
    else {
      return arr[top--];
    }
  } // end of pop()

  int peek() { return arr[top]; } // end of peek()

  void display() {

    cout << "Elements in Stack are :- " << endl;

    for (int i = top; i >= 0; i--) {
      cout << arr[i] << endl;
    }
  } // end of display()

}; // end of Stack class

int main() {

    cout << "Enter size of stack: ";
    int size;
    cin >> size;

  Stack *s1 = new Stack(size);

  int option;

  do {

    cout << "1. Push()" << endl;
    cout << "2. Pop()" << endl;
    cout << "3. Peek()" << endl;
    cout << "4. isEmpty()" << endl;
    cout << "5. isFull()" << endl;
    cout << "6. display()" << endl;
    cout << "Any other integer to exit" << endl;
    cout << "Enter choice: " << endl;

    cin >> option;

    switch (option) {

        case 1: {

            if (!s1->isFull()) {
                cout << "Enter item: " << endl;
                int value;
                cin >> value;
                s1->push(value);
            }
            else
                cout << "Stack Overflow" << endl;
        }
        break;

        case 2:
            cout << "Popped Value: " << s1->pop() << endl;
        break;

        case 3: {

            if (s1->isEmpty())
                cout << "Stack is empty";
            else
                cout << s1->peek() << endl;
        }
        break;

        case 4: {

            if (s1->isEmpty())
                cout << "Stack is Empty" << endl;
            else
                cout << "Stack is not Empty" << endl;
        }
        break;

        case 5: {
            if (s1->isFull())
                cout << "Stack is Full" << endl;
            else
                cout << "Stack is not Full" << endl;
        }
        break;

        case 6:
            s1->display();
            break;

        default:
            cout << "Bye" << endl;
    }

  } while (option >= 1 && option <= 6);

  return 0;
} // end of main()