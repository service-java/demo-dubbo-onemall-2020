package cn.iocoder.mall.admin.config;

import cn.iocoder.common.framework.util.ServiceExceptionUtil;
import cn.iocoder.mall.admin.api.constant.AdminErrorCodeEnum;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ServiceExceptionConfiguration {

    @EventListener(ApplicationReadyEvent.class) // 可参考 https://www.cnblogs.com/ssslinppp/p/7607509.html
    public void initMessages() {
        for (AdminErrorCodeEnum item : AdminErrorCodeEnum.values()) {
            ServiceExceptionUtil.put(item.getCode(), item.getMessage());
        }
    }

}
