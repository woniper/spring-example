package net.woniper.spring.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ResolvableType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFrameworkUtilsApplicationTests {

    @Autowired
    private DemoClass demoClass;

    @Test
    public void testBeansUtils() throws Exception {
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(DemoClass.class);

        // class
        PropertyDescriptor classProperty = propertyDescriptors[0];
        assertThat(classProperty.getName()).isEqualTo("class");
        assertThat(classProperty.getReadMethod().getName()).isEqualTo("getClass");

        // list
        PropertyDescriptor listProperty = propertyDescriptors[1];
        assertThat(listProperty.getName()).isEqualTo("list");
        assertThat(listProperty.getReadMethod().getName()).isEqualTo("getList");
    }

    @Test
    public void testClassUtils() throws Exception {
        Constructor<DemoClass> demoClassConstructor = ClassUtils.getConstructorIfAvailable(DemoClass.class);

        // DemoClass Constructor Info
        assertThat(demoClassConstructor.toString()).isEqualTo("public net.woniper.spring.utils.DemoClass()");

        // DemoClass newInstance Constructor Info
        DemoClass demoClass = demoClassConstructor.newInstance();
        assertThat(demoClass.toString()).isEqualTo("DemoClass(list=[])");
    }

    @Test
    public void testSystemPropertyUtils() throws Exception {
        // home directory
        String userHome = SystemPropertyUtils.resolvePlaceholders("${user.home}");

        // resolved home directory
        String userHomeText = SystemPropertyUtils.resolvePlaceholders("my home directory is ${user.home}");

        assertThat(userHomeText).isEqualTo("my home directory is " + userHome);
    }

    @Test
    public void testServletRequestUtils() throws Exception {
        HttpServletRequest mockServletRequest = mock(HttpServletRequest.class);

        // ServletRequestUtils
        int age = ServletRequestUtils.getIntParameter(mockServletRequest, "age", -1);
        assertThat(age).isEqualTo(-1);

        // WebUtils
        ServletContext mockServletContext = mock(ServletContext.class);
        when(mockServletContext.getAttribute(WebUtils.TEMP_DIR_CONTEXT_ATTRIBUTE))
                .thenReturn(new File("/mock/directory"));
        when(mockServletRequest.getServletContext())
                .thenReturn(mockServletContext);

        File tempDir = WebUtils.getTempDir(mockServletRequest.getServletContext());
        assertThat(tempDir.getAbsolutePath()).isEqualTo("/mock/directory");
    }

    @Test
    public void testAopUtils() throws Exception {
        assertThat(AopUtils.getTargetClass(demoClass).toString()).isEqualTo("class net.woniper.spring.utils.DemoClass");
        assertThat(AopUtils.isAopProxy(demoClass)).isTrue();
        assertThat(AopUtils.isCglibProxy(demoClass)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(demoClass)).isFalse();
    }

    @Test
    public void testReflectionUtils() throws Exception {
        ReflectionUtils.doWithFields(DemoClass.class, System.out::print);
        ReflectionUtils.doWithMethods(DemoClass.class, System.out::print);

        Field list = ReflectionUtils.findField(DemoClass.class, "list");
        assertThat(list.toString())
                .isEqualTo("private java.util.List net.woniper.spring.utils.DemoClass.list");

        assertThat(ResolvableType.forField(list).toString())
                .isEqualTo("java.util.List<java.util.Map<java.lang.String, java.lang.Object>>");
    }
}
