package hello.advanced.v3;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.HelloTraceV2;
import hello.advanced.trace.logTraceV2.LogTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTraceV2 helloTraceV2;
    public void orderItem( String itemId) {

        TraceStatus begin = null;
        try {
            begin = helloTraceV2.begin("OrderServiceV2.orderItem()");
            orderRepository.save(itemId);
            helloTraceV2.end(begin);
        } catch (Exception e) {
            helloTraceV2.exception(begin, e);
            throw e;
        }
    }
}
