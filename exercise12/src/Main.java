
class QueueFullException extends Exception {}

class QueueEmptyException extends Exception {}


class Queue<E> {
    private E[] elements;
    private int index = 0;
    private int size;
    private int rear;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
        this.rear = rear;
    }

    void enqueue(E element) throws QueueFullException {
        if (index >= size) {
            throw new QueueFullException();
        }

        elements[rear] = element;
        rear++;
        size++;

    }

    E dequeue () throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }

        E returnElement = elements[index];
        index++;
        size--;



        return returnElement;
    }
}


public class Main {
    public static void main(String[] args) {
        Queue<String> strings = new Queue<>(3);
        try {
            strings.enqueue("Hello");
            strings.enqueue("World");
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
        } catch (QueueFullException | QueueEmptyException e) {
            e.printStackTrace();
        }


    }
}
