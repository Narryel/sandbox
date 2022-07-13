.PHONY: db db-stop

start:
	docker-compose -f ./docker/docker-compose.yml up -d

stop:
	docker-compose -f ./docker/docker-compose.yml down


grafana:
	open http://localhost:3000