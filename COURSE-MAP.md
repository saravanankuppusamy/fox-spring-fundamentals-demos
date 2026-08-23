# Course-to-Demo Map

This repository follows the nine-lesson sequence in the WA1850 Spring Fundamentals lesson guide.

| Lesson | Core concepts | Demo entry point / test |
|---|---|---|
| 1 | Spring philosophy, coding to interfaces, DI, testability, container | `lesson1/Lesson1App`, `QuoteServiceUnitTest` |
| 2 | ApplicationContext, `@Bean`, names, scopes, profiles, eager/lazy, properties | `lesson2/Lesson2App`, `BeanConfigurationTest` |
| 3 | Component scan, stereotypes, constructor/setter injection, qualifier, lifecycle | `lesson3/Lesson3App`, integration test |
| 4 | Unit vs integration tests, Spring TestContext, profiles/properties/SQL | tests in `lesson1`, `lesson3`, `lesson4`, `lesson7` |
| 5 | Cross-cutting concerns, proxies, advice, pointcuts | `lesson5/Lesson5App`, `AopIntegrationTest` |
| 6 | DAO pattern, `DataSource`, database abstraction, `@Repository` | `lesson6` interfaces + `data/DatabaseConfig` |
| 7 | `JdbcClient`, named params, row mapping, CRUD | `lesson7/Lesson7App`, `JdbcPolicyDaoTest` |
| 8 | Declarative transactions, manager, rollback, read-only | `lesson8/Lesson8App`, `TransactionRollbackTest` |
| 9 | ORM/JPA, EMF, persistence context, EntityManager, lifecycle | `lesson9/Lesson9App`, `JpaPolicyRepositoryTest` |

## Why one coherent domain?

Every demo uses the same Fox Insurance vocabulary so students can focus on the Spring concept instead of relearning a business scenario. The domain is intentionally small enough for classroom use.
