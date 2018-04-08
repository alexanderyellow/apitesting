package com.blr.project.context

import com.blr.project.context.aspects.UserAspect
import org.springframework.context.annotation.*
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:config.properties") //${env}.properties
@ComponentScan("com.adform.dmp.*")
class TestConfig {

    @Bean
    fun placeholderConfigurer() = PropertySourcesPlaceholderConfigurer()

    @Bean
    fun userAspect() = UserAspect()
}