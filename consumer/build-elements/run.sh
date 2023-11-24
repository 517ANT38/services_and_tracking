#!/bin/sh
echo "Entrypoint sh script started"
exec java -jar consumer.jar \${JAVA_OPTS} \${APPLICATIONCLASS} \${@}