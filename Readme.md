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
> Скрипты находятся в папке scripts
   1. Сборка сервисов consumer и producer - build.sh
   2. Запуск - start.sh
   3. Остановка проекта - stop.sh
   4. Уничтожение - down.sh
   5. Создание нагрузки на endpoint /weather сервиса /producer - load_weather_data.bash $1 $2 $3, 
   где первый параметр количество запросов, второй хост и третий порт
   6.  Создание нагрузки на endpoints /getDataOrConstDataWeather/constData, /getDataOrConstDataWeather/data/tempr/{t}, 
   /getDataOrConstDataWeather/data, /getDataOrConstDataWeather/data/spendWinter/{s} - два скрипта 
   load_get_weather_data.bash $1 $2 $3 $4 $5 $6, где первый параметр хост, второй порт, третий количество запросов на endpoint /getDataOrConstDataWeather/constData, четвертый количество запросов на endpoint /getDataOrConstDataWeather/data/tempr/{t}, пятый количество запросов на endpoint /getDataOrConstDataWeather/data, шестой количество запросов на endpoint
   /getDataOrConstDataWeather/data/spendWinter/{s};
   localhost_get_weather_data.bash $1 $2 $3 $4 - скрипт, который делает запросы к endpoints на хост localhost по порту 8081,
   первый количество запросов на endpoint /getDataOrConstDataWeather/constData, второй количество запросов на endpoint /getDataOrConstDataWeather/data/tempr/{t}, третий количество запросов на endpoint /getDataOrConstDataWeather/data, четвертый количество запросов на endpoint   /getDataOrConstDataWeather/data/spendWinter/{s};
   _Важно!_ Данные скрипты могут очень сильно перегружать сервера! Используйте с осторожностью! 
   7.   Перезагрузка сервисов - restart.sh

&#169; Тащилин Антон б1-ИФСТ-31
