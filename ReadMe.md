#DIGITAL ECOM APPLICATION

The app will expose an end point to get all products with min and max price per brand. 

##Tech Stack
1. Kotlin
2. SpringBoot
3. MS-Sql
4. Angular-UI
5. flyway

##SetUp

Application uses gradle. Below command should pull all the necessary dependencies.

````
./gradlew clean --refresh-dependencies
````
The app uses MS-Sql Server as local database.  If you run setup-database.sh. You should be able to pull
docker image and it created LEMANS database. You can use IntelliJ or Ms-Azure Studio to connect.
If you have permissions denied while running run the below command.
```
chmod +x ./scripts/setup-database.sh
```
Run this command to setup schema, tables, inserts
```shell script
./scripts/setup-database.sh
```
In scripts folder, You have sql scripts and all shell scripts. The app has insertproducts.sh and insertParts.sh that will generate inserts and write the to sql files.
I have brought in Flyway into the project, Flyway, When ran will automatically create schema,tables, inserts.
It will check for hash and run those which have not been ran so far. 
```
chmod +x ./scripts/flyway.sh
```
Run this command to setup schema, tables, inserts
```shell script
./scripts/flyway.sh
```

Then Run the application. Application will run on port 8087. Import the postman collection on the project and hit the end point to see data.


###Questions,Assumptions,FutureFeatures

1. I assumed that if there are similar product from different brands, They will have separate product id's and will be treated as different products.
2. There are many fields in database that I don't use like category. We can create endpoints to show products by category. We could use Strategy and composite patterns to maintain a multi filter sort.
3. If we have millions of products, we should use pagination to load up products. 100 products in one go.
4. We can have images on server or in angular project, That way we can load them quickly.
5. We could have nice logging model that will help us log the necessary fields and help search logs

