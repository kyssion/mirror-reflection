# MIRROR-REFLECTION

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![](https://img.shields.io/badge/openjdk-1.8%2B-green.svg)]() ![](https://img.shields.io/badge/release-1.0--GA-brightgreen.svg) ![](https://img.shields.io/badge/coverage-95%25-yellowgreen.svg)

mirror-reflection 是一个高性能的java反射类库的一个封装,旨在降低java反射相关操作的难度,提供更好的编程体验.

## mirror-reflection解决的主要问题

1. 降低java反射使用难度,能更加容易的编写出优美的反射代码
2. 扩展java反射操作,实现通过名称或者字符串快速操作变量或者运行方法
3. 针对java反射操作进行优化,内部使用缓存机制,提高java反射操作多次调用时候的性能
4. 通过本框架对java反射操作的优化,可以更加方便的集成到其他框架中,方便其他各种框架的开发

## mirror-refllection 环境和依赖要求

- java环境
  - java8+,兼容java9+反射模型
- 构建工具
  - gradle5.0+
- 其他依赖
  - 无第三方依赖

## mirror-refllection 使用方法

### 1. reflector和reflectorFactory类

> reflector类

针对java class的一层封装,提供java类的field和method缓存功能

引申:Agent接口-> mirror为了简化操作,将method操作和field操作都简化成一个agent,当需要运行或者取值的时候只需要运行接口的invoke方法即可(相当于针对java反射操作的一层封装)

> 主要方法

方法名称|参数|作用
---|---|---
getGetAgent|propertyName:string|获取对应名称的field get agent(相当于get方法)
getSetAgent|propertyName:string|获取对应名称的field set agent(相当于set方法)
getGetterType|propertyName:string|获取对应名称的field get方法返回值class类型
getSetterType|propertyName:string|获取对应名称的field set方法返回值class类型
getMethod|methodName:string|获取对应名称的方法列表(java支持函数重载,所以返回值是列表)

> reflectorFacotry类

针对reflect的一层封转简化创建过程,并提供缓存功能

> 主要方法

方法名称|参数|作用
---|---|---
findForClass|type:class|获取class对应的reflector类

### 2. mirrorClass

这个方法是针对reflector的一层封装,支持路径解析方法获取field或者method的反射

-----

引申:mirror的路径解析原则

基本语法 

- 非数组或列表或者map的情况 
  - 语句:xxx.yyy.zzz(以下的解释只是方便理解,实际上并不是采用这种操作)
    - 当要解析的是变量信息时 mirror框架拿到getXxx().getYyy().getZzz()对应的参数反射
    - 当要解析的是方法时 mirror框架将会拿到getXxx().getYyy().zzz()的method反射
- 数组或列表或者map的情况
  - 语句xxx.yyy[ppp].zzz
    - mirror框架的即系原则和上面类似,总结一下就是可以拿到对应路径的下的变量反射或者函数反射

-----

> 主要方法

ps: 相比较reflector支持路径解析

方法名称|参数|作用
---|---|---
getGetAgent|propertyName:string|获取对应名称的field get agent(相当于get方法)
getSetAgent|propertyName:string|获取对应名称的field set agent(相当于set方法)
getGetterType|propertyName:string|获取对应名称的field get方法返回值class类型
getSetterType|propertyName:string|获取对应名称的field set方法返回值class类型
getMethod|methodName:string|获取对应名称的方法列表(java支持函数重载,所以返回值是列表)

### 3. mirrorObject

一个object对象的代理通过这个方法可以更加方便的使用反射+路径解析的方式操作这个object对象

主要方法


方法名称|参数|作用
---|---|---
getValue|name:string,item:class|获取名称微string类型为item类型的值
setValue|name:string,value:object|为名称微name的对象赋value值
invoke|name:string,item:class,params:Object[]|运行名称为name,返回值为item(可以为null),参数为params的方法

## 开源协议和授权

mirror-reflection is Open Source software released under the [Apache 2.0 license](https://www.apache.org/licenses/LICENSE-2.0.html).
