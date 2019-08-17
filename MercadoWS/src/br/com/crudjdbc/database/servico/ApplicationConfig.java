package br.com.crudjdbc.database.servico;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("mercado")
public class ApplicationConfig extends Application {

    @Override
    
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> resources = new HashSet<>();
    	addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
    	resources.add(Servicos.class);
    }
}