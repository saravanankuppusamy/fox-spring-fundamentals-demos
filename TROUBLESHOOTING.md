# Troubleshooting

## `mvn` or `gradle` is not recognized

Install Maven 3.9+ or Gradle 8.10+ and restart the terminal. You only need one of them.

## Wrong Java version

```bash
java -version
```

This repository targets Java 21. Configure `JAVA_HOME` to a JDK 21 installation.

## Dependency download errors

Maven and Gradle download dependencies from Maven Central. Corporate proxies may require proxy configuration in Maven `settings.xml` or Gradle properties.

## `NoUniqueBeanDefinitionException`

This is intentional in some experiments: two beans implement the same interface. Use `@Qualifier` or `@Primary`, or redesign the dependency.

## Profile bean missing

For Lesson 2, activate `email`, `sms`, or `training` (if you completed Lab 2). With no active profile, the `default` profile bean is selected.

## Database disappears between runs

H2 is in-memory. This is intentional: every application process starts with a clean training database.

## Why no Spring Boot?

The course is Spring Fundamentals. Explicit configuration makes the Spring container and infrastructure visible. After students understand this repository, Spring Boot becomes easier to reason about because Boot automates many of these same configuration decisions.
