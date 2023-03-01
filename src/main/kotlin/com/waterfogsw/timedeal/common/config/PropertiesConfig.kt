package com.waterfogsw.timedeal.common.config

import com.waterfogsw.timedeal.common.config.properties.RedisProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(RedisProperties::class)
class PropertiesConfig
