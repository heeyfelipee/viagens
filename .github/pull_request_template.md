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

## How to Test Locally

**Quick test (JDK21 - default):**
```bash
./mvnw -DskipTests=false verify
mvn com.diffplug.spotless:spotless-maven-plugin:apply  # if formatting needed
```

**Full quality checks (same as CI/CD with JDK17):**
```bash
# Option 1: With Java 17 available
mvn -Pstrict-quality -DskipTests=true verify

# Option 2: Specify Java 17 explicitly
mvn -Djava.version=17 -Pstrict-quality -DskipTests=true verify
```

**See PR-TEMPLATE.md for detailed instructions and troubleshooting.**

## CI/CD Checks

This PR will trigger:
- ✅ **build job**: Compile, format, and test with JDK21
- ✅ **quality job**: Spotless and Checkstyle validation (PR-only)
- ✅ **analysis job**: PMD and SpotBugs with JDK17 (PR-only)

## Checklist

- [ ] Code follows Google Java Style Guide
- [ ] Tests added and passing locally
- [ ] No Checkstyle or Spotless violations
- [ ] Performance considerations reviewed (if applicable)

---

See [DEVELOPMENT.md](../DEVELOPMENT.md) for full documentation.
