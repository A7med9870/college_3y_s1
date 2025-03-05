import java.io.*;

class SharedFile {
    private File file;
    private boolean available = false; // Indicates whether the file is available for writing

    public SharedFile(String fileName) {
        this.file = new File(fileName);
    }

    // Method for producers to write to the file
    public synchronized void write(String data) {
        while (available) {
            try {
                wait(); // Wait until the file is available for writing
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
        }
        available = true;
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(data + "\n");
            System.out.println("Produced: " + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        notifyAll(); // Notify consumers that data is available
    }

    // Method for consumers to read from the file
    public synchronized String read() {
        while (!available) {
            try {
                wait(); // Wait until data is available for reading
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
        }
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            System.out.println("Consumed: " + content.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        available = false;
        notifyAll(); // Notify producers that the file is available for writing
        return content.toString();
    }
}

class Producer extends Thread {
    private SharedFile sharedFile;

    public Producer(SharedFile sharedFile) {
        this.sharedFile = sharedFile;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            sharedFile.write("Data " + i);
            try {
                Thread.sleep(100); // Simulate time taken to produce data
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedFile sharedFile;

    public Consumer(SharedFile sharedFile) {
        this.sharedFile = sharedFile;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            sharedFile.read();
            try {
                Thread.sleep(100); // Simulate time taken to consume data
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedFile sharedFile = new SharedFile("sharedfile.txt");

        Producer producer = new Producer(sharedFile);
        Consumer consumer = new Consumer(sharedFile);

        producer.start();
        consumer.start();
    }
}
