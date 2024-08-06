package hello.advanced.v3;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.HelloTraceV2;
import hello.advanced.trace.logTraceV2.LogTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTraceV2 helloTraceV2;

    public void save( String itemId) {
        //저장 로직

        TraceStatus begin = null;
        try {
            begin = helloTraceV2.begin("OrderRepositoryV2.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
            helloTraceV2.end(begin);
        } catch (Exception e) {
            helloTraceV2.exception(begin, e);
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
