package hello.advanced.trace.logTraceV2;

import hello.advanced.trace.TraceStatus;

public interface LogTraceV2 {

    TraceStatus begin(String status);
    void end(TraceStatus status);
    void exception(TraceStatus status, Throwable throwable);
}
