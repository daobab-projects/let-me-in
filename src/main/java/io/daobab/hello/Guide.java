package io.daobab.hello;

import io.daobab.generator.DaobabGenerator;
import io.daobab.generator.template.TemplateLanguage;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings({"unchecked", "rawtypes"})
@Configuration
public class Guide {

    @Value("${daobab.hello.url}")
    private String url;
    @Value("${daobab.hello.user}")
    private String user;
    @Value("${daobab.hello.pass}")
    private String pass;
    @Value("${daobab.hello.driverClassName}")
    private String driverClassName;

    protected final DaobabGenerator generator = new DaobabGenerator();


    @PostConstruct
    public void init() {
        step1_checkConnection();
//        step2_generateClasses();
    }

    public void step1_checkConnection() {
        //STEP 1: check the database connection
        generator.checkConnection(url, user, pass, getDriverClass());
    }

    public void step2_generateClasses() {
        //STEP 2: generate classes
        generator.setLanguage(TemplateLanguage.JAVA);
        generator.setPackage("io.daobab.hello.dao");
        //where to write output classes
        generator.setPath("C:\\Daobab\\");

        //your database may contain many catalogues or schemas,
        //it's printed at step 1
        //here you can limit the scope to particular catalog and schema

//        generator.generateOnlyForCatalogues("catalogue");
//        generator.generateOnlyForSchemas("schema");

        generator.reverseEngineering(url, user, pass, getDriverClass());


        //At the end, don't forget to copy the generated classes to 'io.daobab.hello.dao' package
        //and put the DataSource connection pool.
    }

    protected Class getDriverClass() {
        try {
            return Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
