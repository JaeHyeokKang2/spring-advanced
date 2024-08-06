package hello.advanced.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 helloTraceV1;

    public void save(String itemId) {
        //저장 로직

        TraceStatus begin = null;
        try {
            begin = helloTraceV1.begin("OrderRepositoryV1.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
        } catch (Exception e) {
            helloTraceV1.exception(begin, e);
            throw e;
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
