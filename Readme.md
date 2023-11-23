# Микросервисное приложние за наблюдением за погодой

## Используемые сервисы
   1. СУБД PostgreSQL
   2. Брокер сообщений kafka
   3. zipkin трайсер сервисов
   4. consumer сервис получатель данных
   5. producer сервис отравитель данных
   6. zookeeper хранилище данных кафка
   7. pgadmin графический клиент postgresql
   8. kafdrop  графический клиент kafka

## Требования к платформе развертывания
   1. docker
   2. docker-compose
   3. docker buildx
## Использования
    1. Сборка сервисов consumer и producer - build.sh
    2. Запуск - start.sh
    3. Остановка проекта - stop.sh
    4. Уничтожение - down.sh
    5. Создание нагрузки на endpoint /weather сервиса /producer - load_weather_data.bash $1 $2, 
    где первый параметр количество запросов, а второ порт