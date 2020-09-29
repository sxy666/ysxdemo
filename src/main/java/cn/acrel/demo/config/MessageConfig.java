package cn.acrel.demo.config;

import com.ctiot.aep.mqmsgpush.sdk.IMsgConsumer;
import com.ctiot.aep.mqmsgpush.sdk.IMsgListener;
import com.ctiot.aep.mqmsgpush.sdk.MqMsgConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig implements IMsgListener {
    String server = "msgpush.ctwing.cn:16651"; //消息服务地址
    String tenantId = "xxx";//租户ID
    String token = "xxx";//身份认证token串
    String certFilePath = ""; //直接填空字符串，CA证书，JDK已经内置相关根证书，无需指定

    @Override
    public void onMessage(String s) {
        //接收消息
        System.out.println(s);
        //消息处理...
        //为了提高效率，建议对消息进行异步处理（使用其它线程、发送到Kafka等）
    }

    @Bean
    public IMsgConsumer consume0() {
        IMsgConsumer consumer = new MqMsgConsumer();
        try {
            //初始化
            /**
             * @param server  消息服务server地址
             * @param tenantId 租户Id
             * @param token    用户认证token
             * @param certFilePath 证书文件路径
             * @param topicNames   主题名列表，如果该列表为空或null，则自动消费该租户所有主题消息
             * @param msgListener 消息接收者
             * @return 是否初始化成功
             */
            consumer.init(server, tenantId, token, certFilePath, null, this);

            //开始接收消息
            consumer.start();

            //程序退出时，停止接收、销毁
            //consumer.stop();
            //consumer.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("exit");
        return consumer;
    }
}



