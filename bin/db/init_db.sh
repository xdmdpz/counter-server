#!/bin/bash

echo "CREATE SCHEMA IF NOT EXISTS counter DEFAULT CHARACTER SET utf8 ;" | mysql -uroot -proot --default-character-set=utf8 ; 
mysql -uroot -proot --default-character-set=utf8 counter < /tmp/counter.sql
mysql -uroot -proot --default-character-set=utf8 counter < /tmp/init_data.sql