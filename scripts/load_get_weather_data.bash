#!/bin/bash  

function random(){ echo $(($1 + $RANDOM % $2));}

function getDataOrConstDataWeather0(){  
  for((i=0; i<$1; i++))
  do
    curl  -X GET \
    "http://$2:$3/getDataOrConstDataWeather/constData" \
    --header 'Accept: */*'> /dev/null 
  done
}

function getDataOrConstDataWeather1(){
    for((i=0; i<$1; i++))
    do
    curl  -X GET \
    "http://$2:$3/getDataOrConstDataWeather/data/tempr/$(random 1 99)" \
    --header 'Accept: */*' > /dev/null 
    done

}

function getDataOrConstDataWeather2(){
    for((i=0; i<$1; i++))
    do
        curl  -X GET \
        "http://$2:$3/getDataOrConstDataWeather/data" \
        --header 'Accept: */*'> /dev/null 
    done
}

function getDataOrConstDataWeather3(){
    for((i=0; i<$1; i++))
    do
    curl  -X GET \
    "http://$2:$3/getDataOrConstDataWeather/data/spendWinter/$(random 1 99)" \
    --header 'Accept: */*' > /dev/null 
    done

} 

getDataOrConstDataWeather0 $3 $1 $2 

getDataOrConstDataWeather1 $4 $1 $2 

getDataOrConstDataWeather2 $5 $1 $2 

getDataOrConstDataWeather3 $6 $1 $2
