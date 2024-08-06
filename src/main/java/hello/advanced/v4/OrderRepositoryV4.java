package hello.advanced.v4;

import hello.advanced.trace.logTraceV2.LogTraceV2;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTraceV2 helloTraceV2;

    public void save( String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(helloTraceV2) {
            @Override
            protected Void call() {
                //저장 로직
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생");
                }
                sleep();
                return null;
            }
        };
        template.execute("OrderRepository.save()");
    }
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
