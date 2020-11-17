package com.example.demo.dao;
import com.github.jsonldjava.utils.Obj;
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

    public Map<String,Set<Tuple<Object,Object>>> relations = new HashMap<>();


    public Map<String,Set<Triple<Object,String,Object>>> classAndProps = new HashMap<>();
    public Map<String, Set<Tuple<Object,Object>>> yamlToRelations() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(path);
        Map<String, Object> obj = yaml.load(inputStream);



        for(Map.Entry<String, Object> entry : obj.entrySet()){
            String relation = entry.getKey();
            Object props = entry.getValue();

            if(props instanceof Map)
            {
                int type = 0;
                HashSet<Tuple<Object,Object>> allProps = new HashSet<>();
                for(Map.Entry<?, ?> entry2 : ((Map<?, ?>) props).entrySet())
                {
                    Object prop =  entry2.getKey();
                    Object value = entry2.getValue();
                    if(prop.toString().equals("type")&&value.toString().equals("class")){
                        type=1;
                        //是类
                    }
                    if(prop.toString().equals("type")&&value.toString().equals("relation")){
                        type=2;
                        //是关系
                    }
                }
                if(type==1){
                    continue;
                }
                if(type==2){
                    for(Map.Entry<?, ?> entry2 : ((Map<?, ?>) props).entrySet())
                    {
                        Object prop =  entry2.getKey();
                        Object value = entry2.getValue();
                        Tuple<Object,Object> newTuple = new Tuple<>();
                        newTuple.setFirst(prop);
                        newTuple.setSecond(value);
                        allProps.add(newTuple);

                    }
                }


                System.out.println(relations);
                System.out.println(allProps);

                relations.put(relation,allProps);
            }

        }

        return relations;
    }



    public Map<String, Set<Triple<Object,String,Object>>> yamlToClass(){
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
                int type = 0;
                HashSet<Triple<Object,String,Object>> allProps = new HashSet<>();
                for(Map.Entry<?, ?> entry2 : ((Map<?, ?>) props).entrySet())
                {
                    Object prop =  entry2.getKey();
                    Object value = entry2.getValue();
                    if(prop.toString().equals("type")&&value.toString().equals("class")){
                        type=1;
                        //是类
                    }
                    if(prop.toString().equals("type")&&value.toString().equals("relation")){
                        type=2;
                        //是关系
                    }
                }
                if(type==1){
                    for(Map.Entry<?, ?> entry2 : ((Map<?, ?>) props).entrySet())
                    {
                        Object prop =  entry2.getKey();
                        Object value = entry2.getValue();
                        Triple<Object,String,Object> newTriple = new Triple<>();
                        newTriple.setFirst(prop);
                        String myprop = prop.toString();
                        if(myprop.charAt(0)=='m'&&myprop.charAt(1)=='y'){
                            newTriple.setSecond("Data");
                        }
                        else {
                            newTriple.setSecond("Meta");
                        }

                        newTriple.setThird(value);
                        allProps.add(newTriple);

                    }
                }
                if(type==2){
                    continue;
                }


                System.out.println(classes);
                System.out.println(allProps);

                classAndProps.put(classes,allProps);
            }

        }

        return classAndProps;
    }

}
