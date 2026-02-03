# Quick Start Guide

## Clone and Build (5 minutes)

```bash
git clone https://github.com/seu-usuario/viagens.git
cd viagens
./mvnw clean verify    # Compile, format, and run tests
```

## Development Workflow

### 1. Make Your Changes

Edit code in `src/main/java/com/empresa/viagens/`

### 2. Run Local Checks

```bash
# This runs automatically during verify, but you can check individually:

# Format check (auto-fixes)
mvn com.diffplug.spotless:spotless-maven-plugin:apply

# Style check
mvn checkstyle:check

# Tests
mvn test

# Full verify
./mvnw clean verify
```

### 3. Run Benchmarks (optional)

```bash
# Performance micro-benchmarks
mvn -DskipTests=true jmh:benchmark
```

### 4. Push and Open PR

```bash
git checkout -b my-feature
git add .
git commit -m "feat: add amazing feature"
git push origin my-feature
# Create PR on GitHub
```

## Local Environment

### Requirements

- **Java**: 21 (default) or 17 (for PMD/SpotBugs)
- **Maven**: Included (./mvnw)
- **Node.js**: 18+ (for markdown linting, optional)

### Check Your Setup

```bash
# Java version
java -version

# Maven (included)
./mvnw -v

# Node (optional)
node --version
```

## Running Strict Analysis Locally

By default, PMD and SpotBugs are **skipped** to keep development fast. To run them:

```bash
# If you have Java 17 available
mvn -Pstrict-quality -DskipTests=true verify

# Or specify Java 17
mvn -Djava.version=17 -Pstrict-quality -DskipTests=true verify
```

This is what runs in the GitHub Actions CI/CD pipeline for pull requests.

## Common Issues

### "SpotBugs bytecode incompatibility with Java 21"

**Solution**: Use Java 17 for strict analysis, or skip PMD/SpotBugs:

```bash
# Default behavior (skips PMD/SpotBugs with JDK21)
./mvnw clean verify

# With Java 17 (if available)
mvn -Pstrict-quality -DskipTests=true verify
```

### "Checkstyle violations"

```bash
# See violations
mvn checkstyle:checkstyle

# View HTML report
open target/site/checkstyle.html
```

### "Spotless formatting issues"

```bash
# Auto-fix formatting
mvn com.diffplug.spotless:spotless-maven-plugin:apply

# Check without fixing
mvn com.diffplug.spotless:spotless-maven-plugin:check
```

### "Tests failing"

```bash
# Run specific test
mvn test -Dtest=YourTestClass

# Run with verbose output
mvn test -X
```

## Project Structure

```
viagens/
├── src/main/java/com/empresa/viagens/    # Application code
├── src/test/java/com/empresa/viagens/    # Tests
├── pom.xml                                # Maven config
├── pmd-ruleset.xml                        # PMD rules (strict mode)
├── checkstyle-strict.xml                  # Checkstyle rules (strict mode)
├── DEVELOPMENT.md                         # Detailed developer guide
├── HELP.md                                # Help documentation
└── .github/workflows/ci.yml               # CI/CD pipeline
```

## First Contribution Checklist

- [ ] Java 21 installed and set as default
- [ ] Cloned repo: `git clone https://github.com/seu-usuario/viagens.git`
- [ ] Tested build: `./mvnw clean verify` (should pass)
- [ ] Created feature branch: `git checkout -b feature/my-feature`
- [ ] Made changes following code style (auto-formatted by Spotless)
- [ ] Ran tests: `./mvnw test`
- [ ] Committed: `git commit -m "feat: description"`
- [ ] Pushed: `git push origin feature/my-feature`
- [ ] Created PR on GitHub

## Need Help?

- **Documentation**: See [DEVELOPMENT.md](DEVELOPMENT.md)
- **GitHub Issues**: Check existing issues or create new ones
- **Code Style**: Google Java Style (auto-formatted by Spotless)
- **Performance**: Run `mvn -DskipTests=true jmh:benchmark`

---

Happy coding! 🚀
