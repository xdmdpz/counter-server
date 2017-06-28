#!/bin/bash
docker rmi $(docker images -f "dangling=true" -a -q)
docker build -t framework-mysql --force-rm --no-cache .
docker stop mysql; docker rm mysql

docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d framework-mysql
sleep 10s
docker exec mysql /tmp/init_db.sh
echo "Framework mysql db started. Ip is: "
docker-machine ip
