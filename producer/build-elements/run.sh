#!/bin/sh
echo "Entrypoint sh script started"
exec java -jar producer.jar \${JAVA_OPTS} \${APPLICATIONCLASS} \${@}