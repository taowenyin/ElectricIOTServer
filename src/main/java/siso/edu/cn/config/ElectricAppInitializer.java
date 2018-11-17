package siso.edu.cn.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.MultipartConfig;
import java.nio.charset.Charset;

public class ElectricAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private final static int MAX_UPLOAD_SIZE = 2 * 1024 * 1024;
    private final static int MAX_REQUEST_SIZE = 4 * 1024 * 1024;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, DatabaseConfig.class, NettyConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {

        // 解决POST传输中文时的乱码
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");

        // 解决PUT传输时无法采用表单传输数据的问题
        HttpPutFormContentFilter httpPutFormContentFilter = new HttpPutFormContentFilter();

        return new Filter[]{characterEncodingFilter, httpPutFormContentFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
                "",
                MAX_UPLOAD_SIZE,
                MAX_REQUEST_SIZE,
                0);
        registration.setMultipartConfig(multipartConfigElement);
    }
}
