# springboot-apache-pulsar


### Create Admin user :

```
CSRF_TOKEN=$(curl http://localhost:7750/pulsar-manager/csrf-token)

curl \
  -H "X-XSRF-TOKEN: $CSRF_TOKEN" \
  -H "Cookie: XSRF-TOKEN=$CSRF_TOKEN;" \
  -H "Content-Type: application/json" \
  -X PUT http://localhost:7750/pulsar-manager/users/superuser \
  -d '{"name": "admin", "password": "apachepulsar", "description": "test", "email": "username@test.org"}'
```

![Uploading Screenshot 2024-03-14 at 9.44.01 PM.png…]()
