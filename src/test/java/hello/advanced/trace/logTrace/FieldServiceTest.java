package hello.advanced.trace.logTrace;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() throws InterruptedException {
        log.info("Test start");
        Runnable userA = () -> {
            try {
                fieldService.logic("userA");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable userB = () -> {
            try {
                fieldService.logic("userB");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            threadLocal.set("aaa");
        };

        Thread threadA = new Thread(userA);
        Thread threadB = new Thread(userB);
        threadA.setName("thead-A");
        threadB.setName("thead-B");
        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(3000);
    }
}
