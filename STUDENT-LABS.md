# Student Practice Labs

Complete these after each instructor demo. Try first without looking at another student’s solution.

## Lab 1 — Add a pricing implementation

Create `PromotionalPremiumCalculator` implementing `PremiumCalculator`. Give Travel Insurance a 15% promotional reduction. Configure Spring to use it instead of `StandardPremiumCalculator` and run Lesson 1.

**Success:** a Travel quote uses the new algorithm without changing `QuoteService`.

## Lab 2 — Add a profile

Create a `ConsoleNotificationChannel` and expose it only under a `training` profile.

**Success:** Lesson 2 prints `CONSOLE -> ...` when active profile is `training`.

## Lab 3 — Resolve duplicate beans

Temporarily remove `@Qualifier("loyaltyPricing")` from Lesson 3 and observe the startup error. Resolve it using one of:
- restore `@Qualifier`
- make one implementation `@Primary`

Write one sentence explaining why type-only injection was ambiguous.

## Lab 4 — Write a unit test

Add a unit test for `QuoteService` where the mocked calculator returns `999.99`. Verify both the returned quote and the mock interaction.

## Lab 5 — Add AOP advice

Add `@AfterThrowing` advice to `AuditAspect`. Trigger it by passing a blank customer name.

**Success:** the aspect logs the failure while the service still throws the exception.

## Lab 6 — Add a JDBC query

Add `findByStatus(String status)` to the DAO contract and implementation using a named parameter.

**Success:** insert ACTIVE and CANCELLED policies and return only ACTIVE policies.

## Lab 7 — Practice rollback

Change `PolicyPurchaseService.purchase()` so an audit action of `PAYMENT_FAILED` is written immediately before the simulated exception. Run the demo and prove that **both** the policy row and audit row roll back.

## Lab 8 — Explore transaction boundaries

Create a non-transactional method that performs two writes and fails after the first. Compare its database state with the transactional method. Explain the difference.

## Lab 9 — Extend the JPA entity

Add `coverageAmount` to `PolicyEntity`, construct a policy with the field, and verify it is stored and read back. Let Hibernate update the schema automatically for this in-memory demo.

## Optional capstone

Build `ClaimService` for Fox Insurance:
- interface + implementation
- annotation-based bean
- JDBC repository or JPA repository
- transaction around claim creation and audit
- AOP timing/audit aspect
- unit test with Mockito
- integration test with Spring

Be prepared to explain where Spring is involved and where your code remains plain Java.
