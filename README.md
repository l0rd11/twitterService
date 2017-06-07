# twitterService
## Description
twitterService is a twitter microservice for sius course.

### Starting
```
$ gradlew bootRun
```
#### first start
##### eureka service 
##### configSerfvice
##### rabbitMq with folowing config first time starting:
```
sudo rabbitmq-server
sudo rabbitmq-plugins enable rabbitmq_management
sudo rabbitmqctl add_user admin admin
sudo rabbitmqctl set_permissions admin  ”.*” ”.*” ”.*”
sudo rabbitmqctl set_user_tags admin administrator
```
normal start
```
sudo rabbitmq-server
```
Server will be available at ranadom port check it in eureka site 

### Endpoints
#### GET
get tweets about app
/twitter/getInfo/{name/phrase}
