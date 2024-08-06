package hello.advanced.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.HelloTraceV1;
import hello.advanced.trace.logTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 helloTraceV2;
    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus begin = null;
        try {
            begin = helloTraceV2.beginSync(traceId,"OrderServiceV2.orderItem()");
            orderRepository.save(begin.getTraceId(),itemId);
            helloTraceV2.end(begin);
        } catch (Exception e) {
            helloTraceV2.exception(begin, e);
            throw e;
        }
    }
}
