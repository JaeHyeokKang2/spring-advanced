package hello.advanced.v2;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.HelloTraceV1;
import hello.advanced.trace.logTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {
    private final OrderServiceV2 orderService;
    private final HelloTraceV2 helloTraceV2;

    @GetMapping("/v2/request")
    public String request(String itemId) {
        TraceStatus begin = null;
        try {
            begin = helloTraceV2.begin("OrderControllerV2.request()");
            orderService.orderItem(begin.getTraceId(),itemId);
        } catch (Exception e) {
            helloTraceV2.exception(begin, e);
            throw e;
        }

        helloTraceV2.end(begin);
        return "ok";
    }
}
