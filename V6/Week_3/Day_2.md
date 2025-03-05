
lecture 3, lecture, lab 2

---

c lab 2 → project
lab 2 → package

---

all my homies don’t like java
```
// First Example: Extending Thread class
class Worker1 extends Thread {
    public void run() {
        System.out.println("I am a Worker Thread");
    }
}

class First {
    public static void main(String args[]) {
        Worker1 runner = new Worker1();
        runner.start();
        System.out.println("I am the main thread");
    }
}

// Second Example: Implementing Runnable interface
public interface Runnable {
    public abstract void run();
}

class Worker2 implements Runnable {
    public void run() {
        System.out.println("I am a Worker Thread");
    }
}

public class Second {
    public static void main(String args[]) {
        Runnable runner = new Worker2();
        Thread thrd = new Thread(runner);
        thrd.start();
        System.out.println("I am the main thread");
    }
}

// Third Example: Applet implementing Runnable
import java.applet.Applet;

public class OurApplet extends Applet implements Runnable {
    public void init() {
        Thread th = new Thread(this);
        th.start();
    }

    public void run() {
        System.out.println("I am a Worker Thread");
    }
}
////

import java.util.Date;

public class Server {
    public Server() {
        MessageQueue mailBox = new MessageQueue();
        Producer producerThread = new Producer(mailBox);
        Consumer consumerThread = new Consumer(mailBox);

        producerThread.start();
        consumerThread.start();
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}

class Producer extends Thread {
    private MessageQueue mbox;

    public Producer(MessageQueue m) {
        this.mbox = m;
    }

    public void run() {
        while (true) {
            // Produce an item and enter it into the buffer
            Date message = new Date();
            mbox.send(message);
        }
    }
}

class Consumer extends Thread {
    private MessageQueue mbox;

    public Consumer(MessageQueue m) {
        this.mbox = m;
    }

    public void run() {
        while (true) {
            Date message = (Date) mbox.receive();
            if (message != null) {
                // Consume the message
            }
        }
    }
}

// Assuming MessageQueue class is defined elsewhere
class MessageQueue {
    public void send(Date message) {
        // Implementation for sending a message
    }

    public Date receive() {
        // Implementation for receiving a message
        return null; // Placeholder
    }
}
```

---
