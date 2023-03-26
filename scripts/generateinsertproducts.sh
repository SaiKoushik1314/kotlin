INPUT=products.csv
TABLE=LEMANS.DIGITAL.PRODUCT
OLDIFS=$IFS
IFS=','
[ ! -f $INPUT ] && { echo "$INPUT file not found"; exit 99; }

while read productId productName categoryName
do
echo "insert into $TABLE (product_id, product_name, category_name) values ($productId, '$productName', '$categoryName')"
VAR="insert into LEMANS.DIGITAL.PRODUCT (product_id, product_name, category_name) values ("$productId",'$productName','$categoryName');"
echo $VAR >> ~/Downloads/digitalapp/src/main/resources/db.migration/V0.0.2__productsinserts.sql
done < $INPUT
#docker exec bankcard-sql /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P '<YourStrong!Passw0rd>'  -d master -i .~/Downloads/digitalapp/src/main/resources/db.migration.mssql/productsinserts.sql
IFS=$OLDIFS


