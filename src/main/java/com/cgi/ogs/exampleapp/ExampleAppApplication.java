package com.cgi.ogs.exampleapp;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${application.name}")
    private String applicationName;

    @Value("${samplertype}")
    private String samplerType;

    @Value("${samplerParam}")
    private String samplerParam;

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
        Configuration.SamplerConfiguration samplerConfig;
        System.out.println("samplertype: " + samplerType + ", samplerParam: " + samplerParam);
        if (samplerParam.equals("NULL"))
        {
            samplerConfig = Configuration.SamplerConfiguration.fromEnv().withType(samplerType);
        }
        else
        {
            int param = Integer.parseInt(samplerParam);
            samplerConfig = Configuration.SamplerConfiguration.fromEnv().withType(samplerType).withParam(param);
        }

        final Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv()
                .withLogSpans(true);
        final Configuration config = new Configuration(applicationName).withSampler(samplerConfig)
                .withReporter(reporterConfig);

        return config.getTracer();

    }
}
