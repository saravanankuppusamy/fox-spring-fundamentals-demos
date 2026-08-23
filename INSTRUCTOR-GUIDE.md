# Instructor Guide — Suggested 2-Day Delivery

This is a flexible delivery plan. Adjust the timing to match discussion, breaks, and the official course exercises.

## Day 1 — Core container, beans, annotations, testing

| Time | Topic | Trainer activity |
|---|---|---|
| 09:00–09:30 | Spring mental model | Explain POJO, IoC, DI, coding to interfaces |
| 09:30–10:15 | Lesson 1 demo | Manual object wiring vs Spring `ApplicationContext` |
| 10:15–10:30 | Break | |
| 10:30–11:30 | Beans/config | `@Configuration`, `@Bean`, names, lookup, scopes |
| 11:30–12:00 | Profiles/properties/lazy | Run Lesson 2 variants |
| 12:00–13:00 | Lunch | |
| 13:00–14:15 | Annotation config | stereotypes, scan, injection, qualifier, lifecycle |
| 14:15–14:30 | Break | |
| 14:30–15:45 | Testing | unit vs integration; Spring TestContext; Mockito |
| 15:45–16:30 | Student practice | Labs 1–4 |
| 16:30–17:00 | Review | Explain DI and testability in own words |

## Day 2 — AOP, data access, JDBC, transactions, JPA

| Time | Topic | Trainer activity |
|---|---|---|
| 09:00–09:20 | Day 1 recap | Reconstruct container mental model |
| 09:20–10:30 | AOP | proxy, join point, pointcut, advice; run Lesson 5 |
| 10:30–10:45 | Break | |
| 10:45–11:30 | DB integration | DAO, DataSource, exception translation |
| 11:30–12:15 | JdbcClient | run CRUD; compare direct JDBC boilerplate conceptually |
| 12:15–13:15 | Lunch | |
| 13:15–14:20 | Transactions | commit, rollback, proxy boundary, propagation discussion |
| 14:20–14:35 | Break | |
| 14:35–15:45 | JPA | mapping, persistence context, EntityManager, lifecycle |
| 15:45–16:30 | Student practice | Labs 5–9 |
| 16:30–17:00 | Capstone review | Compare JDBC vs JPA and explain when Spring adds value |

## Trainer preparation

Before class:

```bash
mvn clean test
# or
gradle clean test
```

Open the project at repository root. Keep `DEMO-GUIDE.md` open next to the IDE. Run each main class once before delivery.

## Suggested questions during demos

- Who creates this object: our code or Spring?
- Is this dependency required or optional?
- Why is the field typed as an interface?
- How would we replace the implementation for a test?
- Is this bean a target or a proxy?
- Where does the transaction begin and end?
- Is this object currently managed by the JPA persistence context?
- Would this test be faster and clearer without Spring?
