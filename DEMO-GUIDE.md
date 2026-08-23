# Live Demo Guide

Use this guide while presenting. Each demo is deliberately short enough to run, explain, modify, and re-run.

## Common commands

Set a main class in the commands below.

```bash
# Maven
mvn -q exec:java -Dexec.mainClass=<MAIN_CLASS>

# Gradle
gradle run -PmainClass=<MAIN_CLASS>
```

## Demo 1 — POJOs → interfaces → DI → Spring container

**Main:** `com.foxinsurance.training.lesson1.Lesson1App`

Walk through:
1. `PremiumCalculator` defines a contract.
2. `StandardPremiumCalculator` implements the contract.
3. `QuoteService` depends on the interface, not the concrete class.
4. `Lesson1Config` tells Spring which objects to create.
5. `AnnotationConfigApplicationContext` becomes the container.
6. Spring resolves the method parameter in `quoteService(PremiumCalculator calculator)`.

Classroom change: replace the AUTO rate or add another `PremiumCalculator` implementation. Ask students what happens if two candidates exist.

Then run `QuoteServiceUnitTest` to show that the business object needs no Spring test context.

## Demo 2 — Beans, profiles, scope, lazy and properties

**Main:** `com.foxinsurance.training.lesson2.Lesson2App`

Run three times:

```bash
# default profile
mvn -q exec:java -Dexec.mainClass=com.foxinsurance.training.lesson2.Lesson2App
# explicit profile
mvn -q exec:java -Dexec.mainClass=com.foxinsurance.training.lesson2.Lesson2App -Dexec.args="sms"
```

Show:
- bean aliases `companyName` / `insurerName`
- `@Profile`
- prototype IDs changing
- lazy constructor output appearing only when requested
- `${...}` external property resolution from `fox.properties`

## Demo 3 — Annotation scanning and injection styles

**Main:** `com.foxinsurance.training.lesson3.Lesson3App`

Highlight `@Service`, `@Repository`, `@Component`, `@ComponentScan`, constructor injection, setter injection, `@Value`, and `@Qualifier("loyaltyPricing")`.

Classroom experiment: remove the qualifier. Spring now sees two `PricingRule` beans; discuss ambiguity and the ways to resolve it (`@Qualifier`, `@Primary`, redesign).

Watch `@PostConstruct` and `@PreDestroy` messages during startup/shutdown.

## Demo 4 — Testing Spring applications

Run all tests or a specific class:

```bash
mvn test
mvn -Dtest=SpringTestingFeaturesTest test

gradle test
gradle test --tests '*SpringTestingFeaturesTest'
```

Compare:
- `QuoteServiceUnitTest`: Mockito, no Spring container
- `AnnotatedQuoteServiceIntegrationTest`: Spring TestContext + injected service
- `SpringTestingFeaturesTest`: `@ActiveProfiles` and `@DirtiesContext`
- `JdbcPolicyDaoTest`: `@Sql` + `@Transactional` test

Ask: “Does this test need the container to prove its behavior?” If no, prefer a unit test.

## Demo 5 — AOP and proxies

**Main:** `com.foxinsurance.training.lesson5.Lesson5App`

Explain target → proxy → caller. `PolicyIssuanceServiceImpl` contains business logic; `AuditAspect` provides cross-cutting behavior.

Observe output order from `@Before`, service execution, `@AfterReturning`, and `@Around` timing.

Show `AopUtils.isAopProxy(service)`.

## Demo 6 — Database integration mental model

No separate main class is required. Walk through:
- `PolicyDao` = DAO contract
- `DatabaseConfig` = `DataSource`, `JdbcClient`, `PlatformTransactionManager`
- `JdbcPolicyDao` = `@Repository` implementation

Diagram on whiteboard:

```text
Service → DAO interface → @Repository → JdbcClient → DataSource → H2
```

## Demo 7 — JdbcClient CRUD

**Main:** `com.foxinsurance.training.lesson7.Lesson7App`

Trace:
1. insert with named parameters
2. query scalar ID
3. map one row to `PolicyRecord`
4. update status
5. retrieve all rows

Set a breakpoint inside the RowMapper lambda.

## Demo 8 — Transactions and rollback

**Main:** `com.foxinsurance.training.lesson8.Lesson8App`

The method writes to both `policies` and `policy_audit`. The first purchase commits. The second deliberately throws after both writes; Spring rolls the transaction back.

Key teaching point: `@Transactional` works through a Spring proxy. Call the bean through the context, not by constructing it with `new`.

## Demo 9 — JPA

**Main:** `com.foxinsurance.training.lesson9.Lesson9App`

Show:
- `@Entity` metadata
- generated ID
- `EntityManagerFactory`
- `@PersistenceContext EntityManager`
- `persist()`
- find
- change managed entity state and allow dirty checking to write the update

Compare JPA repository code with the explicit SQL in `JdbcPolicyDao`.
