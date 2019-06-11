package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//localhost:8080/service/calc


@ApplicationPath("calc")
public class Additional extends Application {

    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<>();

        try {
            resources.add(Additional.class);
        }
        catch(Exception e) {
            e.getStackTrace();
        }
        
        return resources;
    }
}
