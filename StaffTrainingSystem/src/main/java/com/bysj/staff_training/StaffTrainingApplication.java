package com.bysj.staff_training;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.servlet.MultipartConfigElement;
import javax.swing.*;

@SpringBootApplication
@MapperScan("com.bysj.staff_training.dao")
public class StaffTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffTrainingApplication.class, args);
    }

    //tomcatEmbedded 这段代码是为了解决，上传文件大于10M出现连接重置的问题，此异常内容 GlobalException 也捕获不到
    //如果尝试上传的文件大小超出了大小限制，则Tomcat会将其裁剪为默认的2mb并重置连接
    //设置（Tomcat的/ conf / server.xml）中参数maxSwallowSize为-1，（对开发有利，但对生产不利，如果用户尝试上载100mb文件，Tomcat将浪费资源来处理额外的带宽）
//    @Bean
//    public TomcatServletWebServerFactory tomcatEmbedded() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
//            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
//                //-1 means unlimited
//                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
//            }
//        });
//        return tomcat;
//    }

}
