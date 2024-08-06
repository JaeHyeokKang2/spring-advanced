package hello.advanced.trace.logTrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UTFDataFormatException;

import static org.junit.jupiter.api.Assertions.*;


class HelloTraceV1Test {
    @Test
    void begin_end() throws Exception {
        HelloTraceV1 helloTrace = new HelloTraceV1();
        TraceStatus hello = helloTrace.begin("hello");
        helloTrace.end(hello);
    }

    @Test
    void begin_exception() throws Exception {
        HelloTraceV1 helloTrace = new HelloTraceV1();
        TraceStatus hello = helloTrace.begin("hello");
        helloTrace.exception(hello, new RuntimeException());
    }

}