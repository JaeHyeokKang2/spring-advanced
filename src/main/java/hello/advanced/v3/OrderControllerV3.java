package hello.advanced.v3;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.HelloTraceV2;
import hello.advanced.trace.logTraceV2.LogTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {
    private final OrderServiceV3 orderService;
    private final LogTraceV2 helloTraceV2;

    @GetMapping("/v3/request")
    public String request(String itemId) {
        TraceStatus begin = null;
        try {
            begin = helloTraceV2.begin("OrderControllerV2.request()");
            orderService.orderItem(itemId);
        } catch (Exception e) {
            helloTraceV2.exception(begin, e);
            throw e;
        }

        helloTraceV2.end(begin);
        return "ok";
    }
}
