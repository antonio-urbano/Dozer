# immagina dozer gia buildata

echo "Starting tests!"
for file in ./queries/*
do
    echo "Found file $file"
    query=$(<$file)
    echo "Read query $query"
    echo "Executing Dozer with found query"

    docker run \
          --network dozer-network \
          -e "SERAPH_QUERY=${query}" \
          -e "KAFKA_BROKER=broker:9093" \
          -e "NEO4J_BOLT=bolt://neo4j-sink:7687" \
          -e "NEO4J_USERNAME=neo4j" \
          -e "NEO4J_PASSWORD=sink" \
          -e "KAFKA_BROKER_CONNECTOR=broker:9093" \
          -e "KAFKA_CONNECT=connect:8083" \
          -e "NEO4J_HOSTNAME=neo4j-sink" \
          -e "FORCE_RESTART=true" \
          -e "KAFKA_CONNECT_NEO4J_BOLT=bolt://neo4j-sink:7687" \
          -e "TEST_FOLDER=/test-results" \
          -e "STOP_DATETIME=2021-01-01T00:05:00Z" \
          -v ${PWD}/test-results:/test-results \
        dozer
done

#dentro test-folder
#ci saranno
#match_linear_PT1M.csv
#match_linear_PT10M.csv

