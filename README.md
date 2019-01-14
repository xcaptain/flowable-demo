# flowable-demo

demo based on [flowable blog](https://blog.flowable.org/2018/12/19/building-your-own-flowable-spring-boot-application/)

## build

1. `./mvnw install`
2. in vscode press F5 to debug

## test

get process definitions:

```sh
curl -i --user flowfest-rest:test 'localhost:8080/latest-definitions/'
```

get tasks:

```sh
curl -i --user flowfest-rest:test 'localhost:8080/process-api/runtime/tasks/'
```
