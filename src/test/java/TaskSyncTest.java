import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TaskSyncTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TaskSyncTest.class, args);
        TaskExecutor executor = context.getBean(TaskExecutor.class);

        // Simulate periodic progress reporting
        new Thread(() -> {
            while (true) {
                executor.sendProgress();
                try {
                    Thread.sleep(5000); // Sleep for 5 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}