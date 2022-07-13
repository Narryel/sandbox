.PHONY: db db-stop

db:
	docker-compose -f ./docker-compose-db.yml up -d

db-stop:
	docker-compose -f ./docker-compose-db.yml down