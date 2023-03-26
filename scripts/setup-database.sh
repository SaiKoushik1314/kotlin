#!/bin/bash
docker pull mcr.microsoft.com/mssql/server:2017-latest
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=<YourStrong!Passw0rd>' -p 1433:1433 --name lemans-sql -d mcr.microsoft.com/mssql/server:2017-latest
sleep 15
docker exec -i lemans-sql /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P '<YourStrong!Passw0rd>' -Q "CREATE DATABASE LEMANS"
