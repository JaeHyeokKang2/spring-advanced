package hello.advanced.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 helloTraceV1;
    public void orderItem(String itemId) {

        TraceStatus begin = null;
        try {
            begin = helloTraceV1.begin("OrderServiceV1.orderItem()");
            orderRepository.save(itemId);
        } catch (Exception e) {
            helloTraceV1.exception(begin, e);
            throw e;
        }orderRepository.save(itemId);
    }
}
