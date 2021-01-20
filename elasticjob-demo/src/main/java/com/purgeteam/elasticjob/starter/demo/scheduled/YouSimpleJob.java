package com.purgeteam.elasticjob.starter.demo.scheduled;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author purgeyao
 * @since 1.0
 */
@Slf4j
@Component
public class YouSimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {


        switch (shardingContext.getShardingItem()) {
            case 0:
                // 执行定时任务1
                System.out.println("yousimple 000000");
                break;
            case 1:
                //执行定时任务2
                System.out.println("yousimple 1111111");
                break;
            case 2:
                System.out.println("yousimple 222222");
                // do something by sharding item 2
                break;
            default:
                break;
            // case n: ...
        }

       /* log.info(String.format("Thread ID: %s, 作业分片总数: %s, " +
                        "当前分片项: %s.当前参数: %s," +
                        "作业名称: %s.作业自定义参数: %s",
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()
        ));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
//        throw new RuntimeException("测试错误");
    }
}
