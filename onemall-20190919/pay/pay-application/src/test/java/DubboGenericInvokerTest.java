import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;

public class DubboGenericInvokerTest {

    public static void main(String[] args) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("api-generic-consumer");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        application.setRegistry(registry);

        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        // 弱类型接口名
        reference.setInterface("cn.iocoder.mall.order.api.OrderService");
        // 声明为泛化接口
        reference.setGeneric(true);

        reference.setApplication(application);

        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();

        String name = (String) genericService.$invoke("updatePaySuccess", new String[]{String.class.getName()}, new Object[]{"1"});
        System.out.println(name);
    }

}
