# spring-boot-rest-api

## Maria DB
```
$ brew install mariadb
$ brew services start mariadb

$ sudo mysql_secure_installation                                                                                                                                         ✘ 1
Password:

NOTE: RUNNING ALL PARTS OF THIS SCRIPT IS RECOMMENDED FOR ALL MariaDB
      SERVERS IN PRODUCTION USE!  PLEASE READ EACH STEP CAREFULLY!

In order to log into MariaDB to secure it, we'll need the current
password for the root user. If you've just installed MariaDB, and
haven't set the root password yet, you should just press enter here.

Enter current password for root (enter for none):
OK, successfully used password, moving on...

Setting the root password or using the unix_socket ensures that nobody
can log into the MariaDB root user without the proper authorisation.

You already have your root account protected, so you can safely answer 'n'.

Switch to unix_socket authentication [Y/n] Y
Enabled successfully!
Reloading privilege tables..
 ... Success!


You already have your root account protected, so you can safely answer 'n'.

Change the root password? [Y/n] Y
New password:
Re-enter new password:
Password updated successfully!
Reloading privilege tables..
 ... Success!


By default, a MariaDB installation has an anonymous user, allowing anyone
to log into MariaDB without having to have a user account created for
them.  This is intended only for testing, and to make the installation
go a bit smoother.  You should remove them before moving into a
production environment.

Remove anonymous users? [Y/n] Y
 ... Success!

Normally, root should only be allowed to connect from 'localhost'.  This
ensures that someone cannot guess at the root password from the network.

Disallow root login remotely? [Y/n] Y
 ... Success!

By default, MariaDB comes with a database named 'test' that anyone can
access.  This is also intended only for testing, and should be removed
before moving into a production environment.

Remove test database and access to it? [Y/n] Y
 - Dropping test database...
 ... Success!
 - Removing privileges on test database...
 ... Success!

Reloading the privilege tables will ensure that all changes made so far
will take effect immediately.

Reload privilege tables now? [Y/n] Y
 ... Success!

Cleaning up...

All done!  If you've completed all of the above steps, your MariaDB
installation should now be secure.

Thanks for using MariaDB!
```

```
$ sudo mysql -u root p

> create database blog;
> use blog;

> create table article ( id int primary key auto_increment, title text not null, body text not null, author text not null, updated_at datetime not null );

> create user app;
> grant all on blog.* to 'app'@'localhost' identified by 'password';
```

## Start Server

```
$ ./gradlew clean build
$ ./gradlew bootRun
```

## Test Request
### POST

```
$ curl -H "Content-Type: application/json" -XPOST 'localhost:8080/article' -d@testdata.json
{"id":1,"title":"Spring BootでREST　APIサーバーを立てる","body":"環境 : MacOS, Sprint Boot, MariaDB .....","author":"kgw0t","updatedAt":"2021-02-28 20:51:46"}
```

### GET

```
$ curl -XGET 'localhost:8080/article/1'
{"id":1,"title":"Spring BootでREST　APIサーバーを立てる","body":"環境 : MacOS, Sprint Boot, MariaDB .....","author":"kgw0t","updatedAt":"2021-02-28 20:51:46"}
```

### PUT

```
$ curl -H "Content-Type: application/json" -XPUT 'localhost:8080/article/1' -d@testdata2.json
{"id":1,"title":"更新された","body":"更新された","author":"更新された","updatedAt":"2021-02-28 20:56:21"}
```

### DELETE

```
$ curl -XDELETE 'localhost:8080/article/1'
{"id":1,"title":"更新された","body":"更新された","author":"更新された","updatedAt":"2021-02-28 20:57:20"}

$ curl -XGET 'localhost:8080/article/1'
// レスポンスなし
```
