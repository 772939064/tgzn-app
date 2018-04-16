package com.tgzn.app.appuser.config;

import com.tgzn.app.appuser.utils.CacheUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * RedisAutoConfiguration
 * Redis自动配置
 * @author Yarn
 * @date 2018-04-11 21:08
 **/
@Configuration
@Import({RedisConfig.class, CacheUtils.class})
public class RedisAutoConfiguration {

}
