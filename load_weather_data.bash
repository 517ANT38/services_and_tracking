#!/bin/bash
for((i=0;i<$1;i++))
do

    curl  -X POST \
  "http://localhost:$2/weather" \
  --header 'Accept: */*' \
  --header 'Content-Type: application/json' \
  --data-raw "{
    \"desd\": \"sdhfjh$i\",
    \"date\": null,
    \"tempr\": 7$i.90,
    \"spendWinter\":$i.7,
    \"item\":\"Hello\"
    }"

done;