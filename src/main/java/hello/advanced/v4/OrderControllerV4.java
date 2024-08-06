package hello.advanced.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTraceV2.LogTraceV2;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {
    private final OrderServiceV4 orderService;
    private final LogTraceV2 helloTraceV2;

    @GetMapping("/v4/request")
    public String request(String itemId) {

        AbstractTemplate<String> template = new AbstractTemplate<>(helloTraceV2) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "success";
            }
        };
        return template.execute("OrderControllerV2.request()");
    }
}
