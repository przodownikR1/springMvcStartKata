package pl.java.borowiec.simple;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
@XmlRootElement
@Slf4j
public class SimpleBean {
    @Value("#{ systemProperties['user.home'] }") 
    private String userHome ;
    
 

    

    private String name;
    
   // @Scheduled(fixedRate=2000)
    public void showTest(){
        log.info("::::    Hello task");
    }
    
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

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }

  

}
