
Swagger:

http://localhost:8730/assessment/swagger-ui-custom.html

or 

http://ec2-3-138-156-66.us-east-2.compute.amazonaws.com:8730/assessment/swagger-ui-custom.html

Username:  admin
Password:  1234

Please refrain from running "get-all" as the Server does not have the memory capacity to cope.

##  Missing due to time
- ErrorHandling via RestControllerAdvice 
    -  This should graciously handle the different HttpStatuses including 401 / 403 - which should link to the Security setup
- Time required to write WebMock Tests for Integration
    -  Required Integration Test to check that UnitTest happens - currently was tested manually by violating a SQL Unique constraint
    
    
