package hello.advanced.trace;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TraceId {

    private String traceId;
    private int level;

    public TraceId() {
        this.traceId = creatId();
        this.level = 0;

    }

    public TraceId(String traceId, int level) {
        this.traceId = traceId;
        this.level = level;
    }

    public String creatId() {
        return UUID.randomUUID().toString().substring(0,8);
    }

    public TraceId createNextId(){
        return new TraceId(traceId, level + 1);
    }

    public TraceId createPreviousId(){
        return new TraceId(traceId, level - 1);
    }

    public boolean isFirstLevel(){
        return level == 0;
    }
}
