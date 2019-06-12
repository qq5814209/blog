package com.me.config;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AlipayConfig {

    @Autowired
    private PayProperties properties;

    @Bean
    public AlipayClient alipayClient(){
        return new DefaultAlipayClient(properties.getGatewayUrl(),
                properties.getAppid(),
                properties.getPrivateKey(),
                properties.getFormate(),
                properties.getCharset(),
                properties.getAlipayPublicKey(),
                properties.getSignType());
    }


}
