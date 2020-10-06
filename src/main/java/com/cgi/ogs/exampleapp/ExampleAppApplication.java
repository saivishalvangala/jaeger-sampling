package com.cgi.ogs.exampleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.jaegertracing.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableSwagger2
public class ExampleAppApplication
{

    public static void main(final String[] args)
    {
        SpringApplication.run(ExampleAppApplication.class, args);
    }

    @Bean
    public Docket api()
    {
        // logHelper.info(Constants.APPNAME,
        // Constants.BUNDLE_NAME,Constants.IC_SUCCESS,"docket.created");
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    @Bean
    public io.opentracing.Tracer jaegerTracer()
    {

        final Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv()
                .withType("const").withParam(1);
        final Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv()
                .withLogSpans(true);
        final Configuration config = new Configuration("example-app").withSampler(samplerConfig)
                .withReporter(reporterConfig);

        return config.getTracer();

    }
}
