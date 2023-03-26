INPUT=parts.csv
TABLE=LEMANS.DIGITAL.PARTS
OLDIFS=$IFS
IFS=','
[ ! -f $INPUT ] && { echo "$INPUT file not found"; exit 99; }

while read punctuatedPartNumber partDescr productId originalRetailPrice brandName imageSource
do
echo "insert into $TABLE  (punctuated_part_number,part_description,product_id,original_retail_price,brand_name,image_source) values ('$punctuatedPartNumber', '$partDescr', $productId,'$originalRetailPrice', '$brandName','$imageSource')"
VAR="insert into $TABLE  (punctuated_part_number,part_description,product_id,original_retail_price,brand_name,image_source) values ('$punctuatedPartNumber', '$partDescr', $productId,'$originalRetailPrice', '$brandName', '$imageSource');"
echo $VAR >> ~/Downloads/digitalapp/src/main/resources/db.migration/V0.0.3__partsinserts.sql
done < $INPUT
#docker exec bankcard-sql /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P '<YourStrong!Passw0rd>'  -d master -i ../src/main/resources/db/migration/mssql/partsinserts.sql


IFS=$OLDIFS


