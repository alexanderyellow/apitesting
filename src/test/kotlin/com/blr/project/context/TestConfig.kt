package com.blr.project.context

import com.blr.project.common.COMPONENT_SCAN
import com.blr.project.common.CONFIG_PROPERTY
import com.blr.project.context.aspects.UserAspect
import org.springframework.context.annotation.*
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@Configuration
@EnableAspectJAutoProxy
@PropertySource(CONFIG_PROPERTY) //${env}.properties
@ComponentScan(COMPONENT_SCAN)
class TestConfig {

    @Bean
    fun placeholderConfigurer() = PropertySourcesPlaceholderConfigurer()

    @Bean
    fun userAspect() = UserAspect()
}