import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.enargit.karaf.core.entities.BasicEntity;
import org.reflections.Reflections;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class DaoCodeGenerator {



    public static void main(String[] args) {
        Package aPackage = Package.getPackage("org.enargit.karaf.core.entities");
        Reflections reflections = new Reflections(aPackage);
        List<Class<?>> classes = reflections.getSubTypesOf(BasicEntity.class).stream().filter(e -> !e.getName().endsWith("Entity")).collect(Collectors.toList());
        classes.forEach( c -> writeMapperServiceImpl(c.getSimpleName(), c));
    }

    public static void writeClassFile(String className, Class<?> clazz) {
        File targetFile = new File("E:/_DEV/_git_repos/internet/internet-data/src/main/java/org/enargit/karaf/data/api/" + className +"Dao.java");

        FreeMarkerConfiguration freeMarkerConfiguration = new FreeMarkerConfiguration();
        try {
            Map<String,Object> root = new HashMap<>();
            root.put("entityName", className);
            Template template = freeMarkerConfiguration.getCfg().getTemplate("dao.fm");
            FileOutputStream fos = new FileOutputStream(targetFile);
            Writer out = new OutputStreamWriter(fos);
            template.process(root, out);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (TemplateException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void writeClassFileImpl(String className, Class<?> clazz) {
        File targetFile = new File("E:/_DEV/_git_repos/internet/internet-data-impl/src/main/java/org/enargit/karaf/data/impl/" + className +"DaoImpl.java");

        FreeMarkerConfiguration freeMarkerConfiguration = new FreeMarkerConfiguration();
        try {
            Map<String,Object> root = new HashMap<>();
            root.put("entityName", className);
            Template template = freeMarkerConfiguration.getCfg().getTemplate("daoimpl.fm");
            FileOutputStream fos = new FileOutputStream(targetFile);
            Writer out = new OutputStreamWriter(fos);
            template.process(root, out);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (TemplateException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void writeRestService(String className, Class<?> clazz) {
        File targetFile = new File("E:/_DEV/_git_repos/internet/internet-rest/src/main/java/org/enargit/karaf/web/rest/api/" + className +"RestService.java");

        FreeMarkerConfiguration freeMarkerConfiguration = new FreeMarkerConfiguration();
        try {
            Map<String,Object> root = new HashMap<>();
            root.put("entityName", className);
            Template template = freeMarkerConfiguration.getCfg().getTemplate("rest.fm");
            FileOutputStream fos = new FileOutputStream(targetFile);
            Writer out = new OutputStreamWriter(fos);
            template.process(root, out);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (TemplateException e) {
            log.error(e.getMessage(), e);
        }
    }
    public static void writeRestServiceImpl(String className, Class<?> clazz) {
        File targetFile = new File("E:/_DEV/_git_repos/internet/internet-rest/src/main/java/org/enargit/karaf/web/rest/impl/" + className +"RestServiceImpl" +
                ".java");

        FreeMarkerConfiguration freeMarkerConfiguration = new FreeMarkerConfiguration();
        try {
            Map<String,Object> root = new HashMap<>();
            root.put("entityName", className);
            Template template = freeMarkerConfiguration.getCfg().getTemplate("restimpl.fm");
            FileOutputStream fos = new FileOutputStream(targetFile);
            Writer out = new OutputStreamWriter(fos);
            template.process(root, out);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (TemplateException e) {
            log.error(e.getMessage(), e);
        }
    }


    public static void writeMapperServiceImpl(String className, Class<?> aClass) {
        File targetFile = new File("E:/_DEV/_git_repos/internet/internet-mapper-impl/src/main/java/org/enargit/karaf/mapper/impl/" + className +
                "MapperImpl" +
                ".java");

        FreeMarkerConfiguration freeMarkerConfiguration = new FreeMarkerConfiguration();
        try {
            Map<String,Object> root = new HashMap<>();
            root.put("entityName", className);
            Template template = freeMarkerConfiguration.getCfg().getTemplate("mapperimpl.fm");
            FileOutputStream fos = new FileOutputStream(targetFile);
            Writer out = new OutputStreamWriter(fos);
            template.process(root, out);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (TemplateException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void writeMapperService(String className, Class<?> clazz) {
        File targetFile = new File("E:/_DEV/_git_repos/internet/internet-mapper/src/main/java/org/enargit/karaf/mapper/api/" + className +
                "Mapper" +
                ".java");

        FreeMarkerConfiguration freeMarkerConfiguration = new FreeMarkerConfiguration();
        try {
            Map<String,Object> root = new HashMap<>();
            root.put("entityName", className);
            root.put("excludes", excludeProperties(clazz));
            Template template = freeMarkerConfiguration.getCfg().getTemplate("mapper.fm");
            FileOutputStream fos = new FileOutputStream(targetFile);
            Writer out = new OutputStreamWriter(fos);
            template.process(root, out);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (TemplateException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchMethodException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static List<String> excludeProperties(Class<?> aClass) throws NoSuchMethodException {
        return getSetters(aClass).stream().map(m -> m.getName()).collect(Collectors.toList());
    }


    public static List<Method> getSetters(Class<?> aClass) throws NoSuchMethodException {
        List<Field> fieldList = getCollectionProperties(aClass);
        List<Method> methodList = new ArrayList<>();
        for (Field field : fieldList) {
            String name = "set" + capitalize(field.getName());
            methodList.add(aClass.getMethod(name, new Class<?>[]{field.getType()}));
        }
        return methodList;
    }

    public static List<Field> getCollectionProperties(Class<?> aClass) {
        return Arrays.stream(aClass.getDeclaredFields()).filter(f -> Collection.class.isAssignableFrom(f.getType()))
                .collect(Collectors.toList());
    }


    public static String capitalize(String s) {
        if (s!=null) {
            return s.substring(0,1).toUpperCase() + s.substring(1);
        }
        return null;
    }




}
