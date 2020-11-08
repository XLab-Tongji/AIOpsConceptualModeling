package com.example.demo.dao;
import org.yaml.snakeyaml.*;
import java.io.InputStream;
import java.util.*;

import com.example.demo.model.*;
/**
 * @author xjt
 */
public class YamlDao {

    private final String path;


    public YamlDao(String s){
      path = s;
    }

    public Map<String,Triple<String, String,String>> relations = new HashMap<>();


    public Map<String,Set<Tuple<String,String>>> classAndProps = new HashMap<>();
    public Map<String, Triple<String,String,String>> yamlToRelations() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(path);
        Map<String, Object> obj = yaml.load(inputStream);



        for(Map.Entry<String, Object> entry : obj.entrySet()){
            String classes = entry.getKey();
            Object props = entry.getValue();

            if(props instanceof String)
            {
                String analyse = props.toString();
                String[] myana = analyse.split("--");
                String class1 = myana[0];
                String relation = myana[1];
                String class2 = myana[2];
                Triple<String,String,String> rel = new Triple<>();
                rel.setFirst(class1);
                rel.setSecond(relation);
                rel.setThird(class2);
                relations.put(classes,rel);
            }


        }

        return relations;
    }




    public Map<String, Set<Tuple<String,String>>> yamlToClass(){
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(path);
        Map<String, Object> obj = yaml.load(inputStream);


        for(Map.Entry<String, Object> entry : obj.entrySet()){
            String classes = entry.getKey();
            Object props = entry.getValue();
            if(props instanceof Map)
            {
                HashSet<Tuple<String,String>> allProps = new HashSet<>();
                for(Map.Entry<?, ?> entry2 : ((Map<?, ?>) props).entrySet())
                {
                    Object prop =  entry2.getKey();
                    Object value = entry2.getValue();
                        Tuple<String,String> newTuple = new Tuple<>();
                        newTuple.setFirst(prop.toString());
                        newTuple.setSecond(value.toString());
                        allProps.add(newTuple);

                }

                System.out.println(classes);
                System.out.println(allProps);

                classAndProps.put(classes,allProps);
            }

        }

        return classAndProps;
    }

}
