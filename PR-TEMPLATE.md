# Pull Request Template

## Description

Describe the changes in this PR. Include:

- What problem does this solve or what feature does it add?
- Why was this approach chosen?
- Any important design decisions or trade-offs

## Type of Change

- [ ] Bug fix (non-breaking change that fixes an issue)
- [ ] New feature (non-breaking change that adds functionality)
- [ ] Breaking change (fix or feature that would cause existing functionality to change)
- [ ] Documentation update

## How to Test Locally (JDK21 - Default)

To quickly test this PR locally, clone the branch and run:

```bash
git checkout <branch-name>
cd viagens

# Build and run tests with default JDK21
./mvnw -DskipTests=false verify

# Format code if needed
mvn com.diffplug.spotless:spotless-maven-plugin:apply
```bash

### Running Full Quality Checks (Optional)

To run the same strict analysis that CI/CD runs on PRs, use the `strict-quality` profile:

```bash
# Requires Java 17 to be available (for PMD/SpotBugs bytecode compatibility)
# Option 1: If you have Java 17 installed and in PATH
mvn -Pstrict-quality -DskipTests=true verify

# Option 2: Specify Java 17 explicitly
mvn -Djava.version=17 -Pstrict-quality -DskipTests=true verify

# Option 3: Use docker (if available)
docker run -it --rm -v /path/to/viagens:/workspace -w /workspace \
  eclipse-temurin:17-jdk mvn -Pstrict-quality -DskipTests=true verify
```bash

## GitHub Actions CI/CD Pipeline

When this PR is pushed, the following checks will run:

1. **build job** (JDK21):
   - Compiles code with `mvn verify`
   - Runs Spotless formatting validation
   - Runs Checkstyle validation
   - Runs unit tests
   - Uploads SpotBugs report

2. **quality job** (JDK21, PR-only):
   - Fails PR if code isn't properly formatted (Spotless)
   - Fails PR if Checkstyle violations are found

3. **analysis job** (JDK17, PR-only):
   - Runs PMD with custom ruleset
   - Runs SpotBugs with strict settings
   - Fails PR if violations found
   - Uploads PMD and SpotBugs reports

## Checklist

- [ ] My code follows the Google Java Style Guide (auto-formatted by Spotless)
- [ ] I have added tests for new functionality
- [ ] All tests pass locally: `./mvnw -DskipTests=false verify`
- [ ] No Checkstyle violations: `mvn checkstyle:check`
- [ ] Code is properly formatted: `mvn com.diffplug.spotless:spotless-maven-plugin:check`

## Performance Considerations

If your changes involve string operations:

- [ ] I have reviewed for inefficient String concatenation (use StringBuilder instead)
- [ ] I have reviewed for inefficient loops with string operations
- [ ] If relevant, I verified with `JmhStringJoinBenchmark` or `JmhBenchmarks`

Run benchmarks locally:

```bash
mvn -DskipTests=true jmh:benchmark
```bash

## Notes

- PMD and SpotBugs are **skipped by default** in local builds to preserve JDK21 compatibility
- These tools are **enabled in CI/CD** under JDK17 to catch issues early
- To run them locally with JDK21, use the `strict-quality` profile or switch to JDK17

## How to Revert to Main

```bash
git checkout main
git pull origin main
```bash

---

*Thanks for contributing to viagens! 🚀*
