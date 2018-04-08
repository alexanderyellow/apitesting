package com.adform.dmp.context

import com.adform.dmp.context.aspects.UserAspect
import org.springframework.context.annotation.*
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@Configuration
@EnableAspectJAutoProxy
@PropertySource(/*"classpath:dev1.properties",*/ "classpath:config.properties") //${env}.properties
@ComponentScan("com.adform.dmp.*")
class TestConfig {

    @Bean
    fun placeholderConfigurer() = PropertySourcesPlaceholderConfigurer()

    @Bean
    fun userAspect() = UserAspect()
}