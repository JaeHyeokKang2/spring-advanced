package hello.advanced.trace.logTrace;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name) throws InterruptedException {
        log.info("저장 name={} -> nameStore -> {}", name, nameStore);
        nameStore = name;
        int millis = 1000;
        Thread.sleep(millis);
        log.info("조회 nameStore={}", nameStore);
        return nameStore;
    }
}
