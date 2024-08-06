package hello.advanced.trace.strategyLogic1;


import hello.advanced.trace.strategyLogic1.code.ContextV1;
import hello.advanced.trace.strategyLogic1.code.Strategy;
import hello.advanced.trace.strategyLogic1.code.StrategyLogicV1;
import hello.advanced.trace.strategyLogic1.code.StrategyLogicV2;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextV1Test {

    private static final Logger log = LoggerFactory.getLogger(ContextV1Test.class);

    @Test
    void strategyV1() {
        StrategyLogicV1 strategyLogicV1 = new StrategyLogicV1();
        ContextV1 contextV1 = new ContextV1(strategyLogicV1);
        contextV1.execute();

        StrategyLogicV2 strategyLogicV2 = new StrategyLogicV2();
        ContextV1 contextV2 = new ContextV1(strategyLogicV2);
        contextV2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategy = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 호출");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategy);
        contextV1.execute();
    }
}
