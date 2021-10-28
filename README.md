# SeraphEngine

## Prepare environment
```bash
docker-compose up -d
```

## Build Dozer
```bash
cd seraph.pipeline
docker build -t dozer .
```

## Start Dozer
```bash
docker-compose -f docker-compose-dozer.yml up --build -d
```