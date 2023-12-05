package com.hli.yuzun;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import java.net.InetAddress;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
//添加@ComponentScan注解，使Spring Boot对文件进行扫描，不加则无法找到Controller
@ComponentScan(basePackages = "com.hli")
//添加@MapperScan注解，使Spring Boot对持久层高的加载
@MapperScan("com.hli.modules.**.mapper")
public class YuzunApplication {

	public static void main(String[] args) {
		Long time = System.currentTimeMillis();
		System.err.println("oops: main入口函数编码-" +System.getProperty("file.encoding"));
		ConfigurableApplicationContext application = SpringApplication.run(YuzunApplication.class, args);
		Environment env = application.getEnvironment();
		System.err.println("项目在" + (System.currentTimeMillis() - time) + "毫秒内启动完成了！！！！！！");
	}


	@Bean
	//My-Batis-Plus分页插件,不加的话会导致分页查询时total一直为0
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
		return interceptor;
	}

}
