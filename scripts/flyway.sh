FLYWAY_CMD="./gradlew flywayMigrate -PflywayUser=sa -PflywayPassword=<YourStrong!Passw0rd> -PflywayUrl=jdbc:sqlserver://localhost:1433;database=LEMANS"
exec $FLYWAY_CMD
