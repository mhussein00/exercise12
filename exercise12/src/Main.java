import java.util.ArrayList;

class QueueFullException extends Exception {}

class QueueEmptyException extends Exception {}


class Queue<E> {
    private ArrayList<E> elements;
    private int index = 0;
    private int size;

    Queue(int size) {
        elements = new ArrayList<>();
        this.size = size;
    }

    void enqueue(E element ) throws QueueFullException {
        if (index >= size) {
            throw new QueueFullException();
        }

        elements.add(index, element);
        index++;
    }

    E dequeue () throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }

        E returnElement = elements.get(index);
        elements.remove(returnElement);

        index++;
        size--;
        return returnElement;
    }
}


public class Main {
    public static void main(String[] args) {
        Queue<String> strings = new Queue<>(2);
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