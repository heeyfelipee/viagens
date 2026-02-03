**Developer Guide**:
- **Build / Tests (JDK21)**: `JAVA_HOME=/tmp/jdk21 PATH=/tmp/jdk21/bin:$PATH mvn -DskipTests=false verify`
- **Format code (Spotless)**: Spotless runs automatically during `validate` phase. To apply manually: `mvn com.diffplug.spotless:spotless-maven-plugin:apply`.
- **Checkstyle**: runs during `verify`. To run only checkstyle: `mvn checkstyle:check`.
- **PMD / SpotBugs**: currently skipped for Java 21 in this branch due to analyzer incompatibility with Java 21 bytecode (classfile major version 65). When newer PMD/SpotBugs versions that support Java 21 are available, remove `<skip>true</skip>` from `pom.xml` for the respective plugins and run `mvn verify` to enable checks.
- **Markdown lint**: `npm ci && npx markdownlint-cli "**/*.md" --ignore node_modules`.
- **Benchmarks (quick micro-benchmark)**: a small micro-benchmark test `PerformanceBenchmarksTest` compares `String` concat vs `StringBuilder` in `src/test/java`. Run tests: `mvn -DfailIfNoTests=false test`.

**Performance note**:
- The micro-benchmark shows `StringBuilder` vastly outperforms repeated `String` concatenation in loops. Replace repeated `s = s + "x"` patterns with `StringBuilder` or `String.join` in performance-sensitive code.

**CI**:
- A GitHub Actions workflow is added at `.github/workflows/ci.yml` which runs on JDK21, executes `npm ci` + `markdownlint` and `mvn verify`.

If you want, next I can:
- Attempt to upgrade PMD/SpotBugs to versions that support Java 21 and re-run analyses.
- Add more JMH-based benchmarks and a profile to run them.
- Create automated PR checks to fail on linter/analysis violations instead of skipping.
