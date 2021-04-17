# spring-boot-rest-api

## Start Server

```
$ ./gradlew clean build
$ ./gradlew bootRun
```

## Test Request
### POST

```
$ curl -H "Content-Type: application/json" -XPOST 'localhost:8080/article' -d@post.json
{"id":1,"title":"Spring BootでREST　APIサーバーを立てる","body":"環境 : MacOS, Sprint Boot, MariaDB .....","author":"kgw0t","updatedAt":"2021-02-28 20:51:46"}
```

### GET

```
$ curl -XGET 'localhost:8080/article/1'
{"id":1,"title":"Spring BootでREST　APIサーバーを立てる","body":"環境 : MacOS, Sprint Boot, MariaDB .....","author":"kgw0t","updatedAt":"2021-02-28 20:51:46"}
```

### PUT

```
$ curl -H "Content-Type: application/json" -XPUT 'localhost:8080/article/1' -d@put.json
{"id":1,"title":"更新された","body":"更新された","author":"更新された","updatedAt":"2021-02-28 20:56:21"}
```

### DELETE

```
$ curl -XDELETE 'localhost:8080/article/1'
{"id":1,"title":"更新された","body":"更新された","author":"更新された","updatedAt":"2021-02-28 20:57:20"}

$ curl -XGET 'localhost:8080/article/1'
// no response
```
