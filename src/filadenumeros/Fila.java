package filadenumeros;

public class Fila {

    private final int maxSize;
    private final int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    public Fila() {
        maxSize = 10;
        queueArray = new int[10];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public void insereNaFila(int item) {
        if(filaCheia()) {
            System.out.println("A fila está cheia.");
            return;
        }

        if(rear == maxSize - 1) {
            rear = -1;
        }

        queueArray[++rear] = item;
        currentSize++;
    }

    public int mostraElemento(int pos) {
        if(pos < 0 || pos >= maxSize) {
            System.out.println("Posição inválida.");
            System.exit(-1);
        }

        int tempFront = front;
        int item = -1;

        for(int i=0; i<=pos; i++) {
           item = queueArray[tempFront++];

            if(tempFront == maxSize) {
                tempFront = 0;
            }
        }

        return item;
    }

    public int retiraDaFila() {
        if(filaVazia()) {
            System.out.println("A fila está vazia.");
            return -1;
        }

        int temp = queueArray[front++];

        if(front == maxSize) {
            front = 0;
        }

        currentSize--;

        return temp;
    }

    public void mostraFila() {
        if (filaVazia()) {
            System.out.println("A fila está vazia.");
        }
        else {
            int tempFront = front;
            int tempCurrentSize = currentSize;

            System.out.print("Fila -> ");
            while (tempCurrentSize > 0) {
                int item = queueArray[tempFront++];

                if(tempFront == maxSize) {
                    tempFront = 0;
                }

                tempCurrentSize--;

                System.out.print(item + "  ");
            }
            System.out.println();
        }
    }

    public boolean filaVazia() {
        return (currentSize == 0);
    }

    private boolean filaCheia() {
        return (maxSize == currentSize);
    }
}
