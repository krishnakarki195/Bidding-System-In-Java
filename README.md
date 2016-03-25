Academic project for Web application architecture Worked as an all-round team member to develop full-fledged bidding system that included technologies like Spring AOP, Spring Security, JPA with Hibernate, Restful services, JSON etc.

Functional Requirements:

User: can view products and current price in real time and bid a new price.
Admin: can create new user and delete existing user.

Non-functional Requirements:

Database: RBDMS (MySQL)
Implement 3 layer model:

Presentation layer:

Deploy RESTful web service using Spring WebMVC.
Validate user request parameters.
Business layer:

Use @Service to configure Service Bean.
Use @Transactional to control transaction.
Persistent layer: use Hibernate.

Log duration of each processing by using Spring AOP.
Transaction management is implemented by Spring AOP.
Security management is implemented by Spring AOP + Spring Security.
Use Case

User: can view and bid and add product.
Admin: can create/delete user. Admin can’t bid
