package cn.iocoder.mall.product.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"cn.iocoder.mall.product"})
@EnableAsync(proxyTargetClass = true)
public class ProductApplication {

    /**
     * 设置需要读取的配置文件的名字。
     * 基于 {@link org.springframework.boot.context.config.ConfigFileApplicationListener#CONFIG_NAME_PROPERTY} 实现。
     */
    private static final String CONFIG_NAME_VALUE = "biz,rest,rpc,application";

    public static void main(String[] args) {
        // 设置环境变量
        System.setProperty(ConfigFileApplicationListener.CONFIG_NAME_PROPERTY, CONFIG_NAME_VALUE);

        // 启动 Spring Boot 应用
        SpringApplication.run(ProductApplication.class, args);
    }

}
