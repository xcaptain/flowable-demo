# flowable-demo

demo based on [flowable blog](https://blog.flowable.org/2018/12/19/building-your-own-flowable-spring-boot-application/)

## build

1. `./mvnw install`
2. in vscode press F5 to debug

`pom.xml` contains postgresql dependency, add a custom `FlowableConfiguration` class to load flowable configuration on startup.

if the error log says:

```log
Could not update Flowable database schema: unknown version from database: '6.4.1.3'
```

then run `select * from act_ge_property` to see if flowable version is not correct, detailed discuss see [https://forum.flowable.org/t/flowable-database-exception/797/2](https://forum.flowable.org/t/flowable-database-exception/797/2)

Because I have built flowable from source, so my database upgraded to `6.4.1.3`, to fix this error, just change `flowable-spring-boot-starter-rest` version to `6.4.1-SNAPSHOT`

## test

get process definitions:

```sh
curl -i --user flowfest-rest:test 'localhost:8080/latest-definitions/'
```

get tasks:

```sh
curl -i --user flowfest-rest:test 'localhost:8080/process-api/runtime/tasks/'
```
