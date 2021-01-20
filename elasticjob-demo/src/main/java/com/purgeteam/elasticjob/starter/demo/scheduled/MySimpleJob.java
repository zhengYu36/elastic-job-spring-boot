package com.purgeteam.elasticjob.starter.demo.scheduled;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author purgeyao
 * @since 1.0
 */

//目前我使用了这个
@Slf4j
@Component
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info(String.format("Thread ID: %s, 作业分片总数: %s, " +
                        "当前分片项: %s.当前参数: %s," +
                        "作业名称: %s.作业自定义参数: %s",
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()
        ));

        //shardingContext.getShardingItem
        // 是被拆分的几个部分，这里可以来执行具体操作说明
        switch (shardingContext.getShardingItem()) {
            case 0:

                /**
                 * 注意：这里就可以来写自己需要操作的功能了，
                 * 例如求数据库的信息，
                 * 消息推送等，都可以在这里来操作了
                 *
                 * 注意点：但是有一个问题，就是所有的分片只有是一个定时时间
                 * 这就比较麻烦了
                 */

                // 执行定时任务1
                System.out.println("000000");
                break;
            case 1:
                //执行定时任务2
                System.out.println("1111111");
                break;
            case 2:
                System.out.println("222222");
                // do something by sharding item 2
                break;
            default:
                break;
            // case n: ...
        }


    }
}
