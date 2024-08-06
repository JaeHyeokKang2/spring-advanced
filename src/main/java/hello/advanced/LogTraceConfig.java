package hello.advanced;

import hello.advanced.trace.logTrace.ThreadLocalTrace;
import hello.advanced.trace.logTraceV2.FieldLogTrace;
import hello.advanced.trace.logTraceV2.LogTraceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTraceV2 logTraceV2() {
        return new ThreadLocalTrace();
    }
}
