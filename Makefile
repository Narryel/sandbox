.PHONY: db db-stop gatling

start:
	docker-compose -f ./docker/docker-compose.yml up -d

stop:
	docker-compose -f ./docker/docker-compose.yml down

restart: stop start

browse: grafana prometheus swagger

grafana:
	open http://localhost:3000

prometheus:
	open http://localhost:9090

swagger:
	open http://localhost:8080/swagger-ui.html

gatling:
	./gatling/gatling-charts-highcharts-bundle-3.8.2/bin/gatling.sh -rm local