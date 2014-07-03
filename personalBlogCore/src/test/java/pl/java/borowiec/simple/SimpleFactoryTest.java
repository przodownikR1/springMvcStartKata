package pl.java.borowiec.simple;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:simpleFactory.xml" })
public class SimpleFactoryTest {

    @Autowired
    private Product aaa;
    
    @Test
    public void test(){
        System.err.println(aaa);
    }
}
