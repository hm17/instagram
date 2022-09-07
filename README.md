# Instagram 3.0
<br>
This is a Spring Boot webapp for instagram 3.0

<br><br>

**Run App**
<br>
Use maven and run in terminal with the command: <br>
`./mvnw spring-boot:run`

<br>

**Test App**
<br>
Send curl message in terminal to get all accounts<br>
`curl 'localhost:8080/instagram/api/accounts'`

<br>
Add a single account<br>
`curl localhost:8080/instagram/api/accounts/add -d username=hm17 -d address=0x0`
