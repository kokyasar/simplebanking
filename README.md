## Eteration Simple Banking API 


The bank account is exclusively interested in maintaining the name of the account owner, the number of the account and the account’s balance. 
The endpoints will be limited to methods that provide a means of crediting and debiting the account.


#### Setup

- The application is running on port 8085
- For running test, `gradle test`

#### Technical Details

- Spring Boot is used as application framework
- JDK11 used for programming language
- PostgreSQL is used for data storage

#### REST API Details


```sh 
GET  http://localhost:8085/account/v1/669-7765           # Get transactions of account
POST http://localhost:8085/account/v1/credit/669-7765    # Post deposit transaction to account
POST http://localhost:8085/account/v1/debit/669-7765     # Post withdraw transaction to account

```
