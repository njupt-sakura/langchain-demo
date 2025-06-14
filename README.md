# langchain-demo

### Build

```bash
mvn archetype-generate

java --version # 21.0.7
mvn -v         # 3.9.10
```

### Format

```bash
mvn com.spotify.fmt:fmt-maven-plugin:format
# or
make format
```

### Execute

```bash
mvn org.codehaus.mojo:exec-maven-plugin:exec
# or
mvn exec:exec
# or
make exec
```

### Build native image

```bash
# 使用 GraalVM, 并设置 JAVA_HOME 环境变量
mvn -Pnative package -DskipTests
```
