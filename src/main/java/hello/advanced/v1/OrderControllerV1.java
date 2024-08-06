package hello.advanced.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV1 orderService;
    private final HelloTraceV1 helloTraceV1;

    @GetMapping("/v1/request")
    public String request(String itemId) {
        TraceStatus begin = null;
        try {
            begin = helloTraceV1.begin("OrderControllerV1.request()");
            orderService.orderItem(itemId);
        } catch (Exception e) {
            helloTraceV1.exception(begin, e);
            throw e;
        }

        helloTraceV1.end(begin);
        return "ok";
    }
}
