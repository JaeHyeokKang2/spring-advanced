package hello.advanced.trace.logTrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadLocalTraceTest {

    ThreadLocalTrace threadLocalTrace = new ThreadLocalTrace();

    @Test
    void begin_end_level2() {
        TraceStatus traceStatus = threadLocalTrace.begin("begin1");
        TraceStatus traceStatus2 = threadLocalTrace.begin("begin2");
        threadLocalTrace.end(traceStatus2);
        threadLocalTrace.end(traceStatus);
    }
}