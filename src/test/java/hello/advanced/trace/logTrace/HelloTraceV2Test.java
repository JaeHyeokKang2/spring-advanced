package hello.advanced.trace.logTrace;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTraceV2.FieldLogTrace;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloTraceV2Test {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end() throws Exception {
        HelloTraceV2 helloTrace = new HelloTraceV2();
        TraceStatus hello1 = helloTrace.begin("hello");
        TraceStatus hello2 = helloTrace.beginSync(hello1.getTraceId(), "hello2");
        helloTrace.end(hello2);
        helloTrace.end(hello1);
    }

    @Test
    void begin_exception() throws Exception {
        HelloTraceV2 helloTrace = new HelloTraceV2();
        TraceStatus hello = helloTrace.begin("hello");
        TraceStatus hello2 = helloTrace.beginSync(hello.getTraceId(), "hello2");
        helloTrace.exception(hello2, new Exception());
        helloTrace.exception(hello, new RuntimeException());
    }

    @Test
    void begin_end_level2() throws Exception {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() throws Exception {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new RuntimeException());
        trace.exception(status1, new Exception());
    }
}