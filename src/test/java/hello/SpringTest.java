package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class SpringTest
{
    @Autowired
    private A a;

    @Test
    public void foo() throws Exception
    {
        assertNotNull(a);
        assertTrue(Mockito.mockingDetails(a).isMock());
    }
}

@Component
class A
{
    @Autowired
    B b;
}

@Component
class B
{

}

@Configuration
class TestConfiguration
{
    @Bean
    public A a()
    {
        return mock(A.class);
    }
}
