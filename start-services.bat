cd seata-account-service
call mvn clean
Echo seata-account-service cleaned
call mvn package
Echo seata-account-service packaged 

cd seata-business-service
call mvn clean
Echo seata-business-service cleaned
call mvn package
Echo seata-business-service packaged 

cd seata-orders-service
call mvn clean
Echo seata-orders-service cleaned
call mvn package
Echo seata-orders-service packaged 

cd seata-stock-service
call mvn clean
Echo seata-stock-service cleaned
call mvn package
Echo seata-stock-service packaged 

docker-compose build --no-cache
docker-compose up -d