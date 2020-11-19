# AIOpsConceptualModeling
Model key interfaces, fields and ontologies in cloud-native systems 

Technology stack:  
springboot + gradle + jena  

Develop log 11.2.2020  
Author lidetao  

1.Lombok已添加，fetch到最新的代码请在本地idea安装Lombok插件，加入注解@data即可自动构建get/set方法，在structure中查看    
新增model层本体实例OntModel，注入yaml时请注意Map ontProp和ontPropRelation的key需要一致且均为本体中的所有属性  
  
2.原代码中对本体直接进行操作的函数已移动至DAO层，且包括SOURCE、NS、文件输出路径在内的常量已抽象到顶层，请注意查看  
（如果可行的话建议通过yaml一并注入？）  
  
3.service层已实现初始化本体的函数ontService，参数为OntModel 

4.各层文件命名已变更，mainController为构建本体的接口，yaml从该接口注入并实例化为OntModel baseOnt，以此为参数调用ontService函数即可进行本体初始化。  
  DAO层已改为通用型变量命名，提示语首字母改为大写，其他代码文件也请注意及时更改  

5.test文件夹下冗余文件已全部清除  

6.RESTFUL风格接口暂未实现  

7.输出/备用/测试文件已全部转入./data目录下，引用时请注意路径问题，暂未构建子目录  

Develop log 11.4.2020  
Author lidetao  

1.实体已变更为class+relation，在model层定义了一个二元组来保存relation的domain和range

Develop log 11.15.2020
Author lidetao

1.Annotation property和Datatype property已区分并重写相关DAO和service方法
2.Object property相关方法已修正,现在可以正确地添加多个domain和range
3.类具有的固定属性现在用Annotation property表达，其他属性用Datatype property表达

开发工具：
1.idea
2.jena+springboot+gradle
3.本体可视化工具：http://www.visualdataweb.de/webvowl/
