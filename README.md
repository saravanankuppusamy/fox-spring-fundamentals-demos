# Fox Insurance — Spring Fundamentals (2-Day Demo Repository)

A trainer-ready, student-friendly repository for learning **core Spring Framework fundamentals** through a consistent insurance domain: **Auto, Home, Travel, and Health Insurance**.

The project intentionally demonstrates the Spring Framework directly instead of hiding the container behind Spring Boot. Students can therefore see `ApplicationContext`, bean configuration, dependency injection, scopes, profiles, lifecycle callbacks, testing, AOP proxies, JDBC, transactions, and JPA clearly.

## What you will learn

| Course lesson | Fox Insurance demo |
|---|---|
| 1. Introduction to Spring | Quote pricing using interfaces, POJOs, DI, `@Configuration`, `ApplicationContext` |
| 2. Defining/using beans | Bean names, singleton/prototype concepts, profiles, lazy beans, external properties |
| 3. Annotation-based beans | `@Component`, `@Service`, `@Repository`, component scan, constructor/setter injection, `@Qualifier`, lifecycle |
| 4. Testing | JUnit, Mockito, `@SpringJUnitConfig`, `@ActiveProfiles`, `@TestPropertySource`, `@DirtiesContext`, `@Sql`, transactional tests |
| 5. AOP | Audit/timing cross-cutting concerns using proxies and `@Before`, `@AfterReturning`, `@Around` |
| 6. Database integration | DAO pattern, `DataSource`, Spring exception model, repository separation |
| 7. Spring JDBC | `JdbcClient`, named parameters, row mapping, CRUD; H2 database |
| 8. Transactions | `PlatformTransactionManager`, `@Transactional`, commit and rollback |
| 9. Spring + JPA | `EntityManagerFactory`, `EntityManager`, `@PersistenceContext`, entity lifecycle, dirty checking |

## Prerequisites

- JDK 21 (JDK 17+ is supported by Spring 7; this repository standardizes on 21 for the class)
- Git
- **Either** Maven 3.9+ **or** Gradle 8.10+
- IDE: IntelliJ IDEA, Eclipse, or VS Code with Java extensions

No external database is required. The data demos use an in-memory H2 database.

## Clone and verify

```bash
git clone <your-repository-url>
cd fox-spring-fundamentals
java -version
```

### Maven path

```bash
mvn clean compile
mvn -q exec:java -Dexec.mainClass=com.foxinsurance.training.lesson1.Lesson1App
```

### Gradle path

```bash
gradle clean build -x test
gradle run -PmainClass=com.foxinsurance.training.lesson1.Lesson1App
```

> Maven and Gradle use the same `src/main/java`, `src/main/resources`, and `src/test` folders. Choose one build tool; you do not need to run both.

## Run the demos

Replace the main class in the Maven/Gradle command with:

```text
com.foxinsurance.training.lesson1.Lesson1App
com.foxinsurance.training.lesson2.Lesson2App
com.foxinsurance.training.lesson3.Lesson3App
com.foxinsurance.training.lesson5.Lesson5App
com.foxinsurance.training.lesson7.Lesson7App
com.foxinsurance.training.lesson8.Lesson8App
com.foxinsurance.training.lesson9.Lesson9App
```

Lesson 4 is deliberately test-driven; run its examples with `mvn test` / `gradle test`.

### Profile demo

Maven:

```bash
mvn -q exec:java -Dexec.mainClass=com.foxinsurance.training.lesson2.Lesson2App -Dexec.args="sms"
```

Gradle:

```bash
gradle run -PmainClass=com.foxinsurance.training.lesson2.Lesson2App --args="sms"
```

Try `email`, `sms`, and no argument (default profile).

## Recommended student workflow

1. Run the lesson demo unchanged.
2. Put a breakpoint in the service/configuration class.
3. Predict what Spring will create or inject.
4. Change one thing (profile, bean scope, qualifier, SQL, transaction failure flag).
5. Re-run the demo.
6. Run the related tests.
7. Complete the practice task in `STUDENT-LABS.md`.
8. Compare behavior before and after your change.

## Repository map

```text
fox-spring-fundamentals/
├── pom.xml                       # Maven build
├── build.gradle                  # Gradle build
├── settings.gradle
├── README.md
├── COURSE-MAP.md
├── DEMO-GUIDE.md
├── INSTRUCTOR-GUIDE.md
├── STUDENT-LABS.md
├── TROUBLESHOOTING.md
└── src/
    ├── main/
    │   ├── java/com/foxinsurance/training/
    │   │   ├── domain/
    │   │   ├── lesson1/ ... lesson9/
    │   │   └── data/
    │   └── resources/fox.properties
    └── test/
        ├── java/com/foxinsurance/training/...
        └── resources/
```

## Mental model

Think of Spring as an **object factory + wiring manager + infrastructure provider**:

```text
Configuration metadata
       ↓
ApplicationContext (Spring Container)
       ↓
creates Beans → injects dependencies → wraps selected beans with proxies
       ↓
Your POJOs execute business logic
       ↓
Spring infrastructure handles concerns such as transactions, persistence and tests
```

A useful rule for this course: **business logic should know as little about Spring as practical**. The `QuoteService` in Lesson 1 is a POJO and can be unit tested without starting Spring.

## Maven vs Gradle quick reference

| Goal | Maven | Gradle |
|---|---|---|
| Compile | `mvn compile` | `gradle classes` |
| Test | `mvn test` | `gradle test` |
| Clean | `mvn clean` | `gradle clean` |
| Run demo | `mvn exec:java -Dexec.mainClass=...` | `gradle run -PmainClass=...` |
| Dependency tree | `mvn dependency:tree` | `gradle dependencies` |

## After the class

Use the labs to extend Fox Insurance with a new insurance product, profile, repository query, aspect, transaction rule, and JPA operation. The goal is not only to make the code run, but to explain **which object Spring creates, why it injects a particular implementation, and where infrastructure behavior occurs**.

See `DEMO-GUIDE.md` for runnable commands and `INSTRUCTOR-GUIDE.md` for the two-day delivery flow.
