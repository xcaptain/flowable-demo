# flowable-demo

基于[flowable 官方博客](https://blog.flowable.org/2018/12/19/building-your-own-flowable-spring-boot-application/)开发的使用 spring boot + flowable 实现的工作流应用演示程序

## 开发

1. `./mvnw install` 安装依赖
2. 在 vscode 中按下 F5 进入调试界面

## 测试

在程序启动时会自动创建用户，并且分配对应权限，会自动从`src/main/resources/processes/`提取出对应流程定义并且部署

测试获取最新流程定义列表：

```sh
curl -i --user flowfest-rest:test 'localhost:8080/latest-definitions/'
```

测试获取所有任务列表：

```sh
curl -i --user flowfest-rest:test 'localhost:8080/process-api/runtime/tasks/'
```
