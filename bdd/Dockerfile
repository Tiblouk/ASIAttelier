FROM postgres:14.1-alpine AS postgres-bdd
COPY ./scripts /docker-entrypoint-initdb.d/

ENV POSTGRES_DB=test_db \
   POSTGRES_USER=test \
   POSTGRES_PASSWORD=test \
   PGDATA=/data/postgres