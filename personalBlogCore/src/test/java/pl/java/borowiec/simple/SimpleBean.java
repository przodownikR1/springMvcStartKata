package pl.java.borowiec.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class SimpleBean {

   
   
    
    @Value("#{ systemProperties['user.home'] }") 
    private String userHome ;
    
    @Autowired
    private Environment env;
  
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SimpleBean [name=" + name + "]";
    }
    
    @PostConstruct
    public void init(){
        System.err.println("=============  init komponent");
        System.err.println(env.getProperty("user.name"));
        
        Properties props = System.getProperties();
        props.list(System.out);
        System.err.println("######  " +userHome);
        
    }
    
    @PreDestroy
    public void destroy(){
        System.err.println("=============  destroy ...");
       
       
    }

  

}
