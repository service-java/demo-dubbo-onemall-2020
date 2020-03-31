package cn.iocoder.mall.pay.biz.job;

import cn.iocoder.mall.pay.biz.dao.PayNotifyTaskMapper;
import cn.iocoder.mall.pay.biz.dataobject.PayNotifyTaskDO;
import cn.iocoder.mall.pay.biz.service.PayNotifyServiceImpl;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 支付通知重试 Job
 */
@Component
@JobHandler(value = "payTransactionNotifyJob")
public class PayNotifyJob extends IJobHandler {

    @Autowired
    private PayNotifyTaskMapper payTransactionNotifyTaskMapper;

    @Autowired
    private PayNotifyServiceImpl payNotifyService;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public ReturnT<String> execute(String param) {
        // 获得需要通知的任务
        List<PayNotifyTaskDO> notifyTasks = payTransactionNotifyTaskMapper.selectByNotify();
        // 循环任务，发送通知
        for (PayNotifyTaskDO notifyTask : notifyTasks) {
            // 发送 MQ
            payNotifyService.sendNotifyMessage(notifyTask);
            // 更新最后通知时间
            // 1. 这样操作，虽然可能会出现 MQ 消费快于下面 PayTransactionNotifyTaskDO 的更新语句。但是，因为更新字段不同，所以不会有问题。
            // 2. 换个视角，如果先更新 PayTransactionNotifyTaskDO ，再发送 MQ 消息。如果 MQ 消息发送失败，则 PayTransactionNotifyTaskDO 再也不会被轮询到了。
            // 3. 当然，最最最完美的话，就是做事务消息，不过这样又过于复杂~
            PayNotifyTaskDO updateNotifyTask = new PayNotifyTaskDO()
                    .setId(notifyTask.getId()).setLastExecuteTime(new Date());
            payTransactionNotifyTaskMapper.update(updateNotifyTask);
        }
        return new ReturnT<>("执行通知数：" + notifyTasks.size());
    }

}
