## Order service

- Create an order
```bash
curl -d '{"itemId":"1", "quantity":"4"}' -H "Content-Type: application/json" -X POST http://localhost:8082/order/orders
```
