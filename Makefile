.PHONY: db db-stop

start:
	docker-compose -f ./docker/docker-compose.yml up -d

stop:
	docker-compose -f ./docker/docker-compose.yml down

restart: stop start

grafana:
	open http://localhost:3000


prometheus:
	open http://localhost:9090

swagger:
	open http://localhost:8080/swagger-ui.html