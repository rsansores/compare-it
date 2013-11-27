POSTING DATA Examples
==================

PRODUCTS
------------------

```
curl -X POST -S -H 'Accept: application/json' \
-F "name=Avena 3 minutos Quakeriado" \
-F "price=10.90" -F "is_promotion=0" \
-F "discount=0.00" -F "deleted=0" \
-F "description=Avena de 3 minutos de 400 gr" \
-F "ticket_image=@/home/obedmr/Pictures/test.jpg;type=image/jpg" \
-F "product_image=@/home/obedmr/Pictures/test.jpg;type=image/jpg" \
-F "enterprise=http://compareit.obedmr.com/rest-api/Enterprise/3/" \
-F "reliability=http://compareit.obedmr.com/rest-api/Reliability/2/" \
 http://compareit.obedmr.com/rest-api/products/
```
