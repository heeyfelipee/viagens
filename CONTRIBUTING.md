# 🤝 Guia de Contribuição - Viagens

Obrigado por se interessar em contribuir para o projeto Viagens! Este documento oferece diretrizes e instruções para contribuidores.

## 📋 Índice

- [Código de Conduta](#código-de-conduta)
- [Como Começar](#como-começar)
- [Processo de Contribuição](#processo-de-contribuição)
- [Padrões de Código](#padrões-de-código)
- [Commit Messages](#commit-messages)
- [Testes](#testes)
- [Documentação](#documentação)
- [Pull Requests](#pull-requests)
- [Reporting Bugs](#reporting-bugs)
- [Sugestões de Features](#sugestões-de-features)

---

## 📜 Código de Conduta

Esperamos que todos os contribuidores:

✅ Sejam respeitosos e inclusivos  
✅ Forneçam feedback construtivo  
✅ Focalizem no que é melhor para a comunidade  
✅ Sejam pacientes e educados  
✅ Respeitem a privacidade dos outros  

❌ Comportamento abusivo, assédio ou discriminação não serão tolerados

---

## 🚀 Como Começar

### 1. Setup Local

```bash
# Clone o repositório
git clone https://github.com/heeyfelipee/viagens.git
cd viagens

# Configure sua chave SSH/Git
git config user.name "Seu Nome"
git config user.email "seu.email@example.com"

# Instale as dependências
./mvnw dependency:resolve

# Crie uma branch para sua feature
git checkout -b feature/sua-nova-feature
```bash

### 2. Ambiente de Desenvolvimento

```bash
# Compilar
./mvnw clean compile

# Executar testes
./mvnw test

# Executar aplicação
./mvnw spring-boot:run

# Verificações de qualidade
./mvnw spotless:apply
./mvnw checkstyle:check
```bash

### 3. Acessar Swagger UI

```bash
http://localhost:8080/swagger-ui.html
```bash

---

## 🔄 Processo de Contribuição

### Passo 1: Fork o Repositório

```bash
# Via GitHub UI: botão "Fork"
# Então clone seu fork:
git clone https://github.com/seu-usuario/viagens.git
cd viagens
git remote add upstream https://github.com/heeyfelipee/viagens.git
```bash

### Passo 2: Crie uma Branch

```bash
# Atualize da branch principal
git fetch upstream
git checkout upstream/main
git checkout -b feature/descricao-da-feature

# Ou para bug fixes:
git checkout -b fix/descricao-do-bug
```bash

### Passo 3: Faça suas Mudanças

```bash
# Edite os arquivos
# Teste localmente
./mvnw clean test

# Formate o código
./mvnw spotless:apply
```bash

### Passo 4: Commit

```bash
# Commit com mensagem clara
git add .
git commit -m "feat: adicionar nova feature XYZ

Descrição detalhada do que foi implementado e por quê.
"
```bash

### Passo 5: Push

```bash
# Push para seu fork
git push origin feature/descricao-da-feature
```bash

### Passo 6: Pull Request

1. Abra um PR no GitHub
2. Preencha o template de PR
3. Aguarde code review
4. Faça ajustes conforme solicitado
5. PR será merged quando aprovado

---

## 📝 Padrões de Código

### Estilo

```java
// ✅ BOAS PRÁTICAS
public class ViagemService {
  private final ViagemRepository repository;
  
  public ViagemService(ViagemRepository repository) {
    this.repository = repository;  // Dependency injection
  }
  
  public Optional<Viagem> buscar(Long id) {
    return repository.findById(id);  // Return Optional
  }
}

// ❌ EVITAR
public class ViagemService {
  public ViagemService() {}  // No default constructor
  
  public Viagem buscar(Long id) {
    return null;  // Don't return null, use Optional
  }
}
```bash

### Nomenclatura

- Classes: `PascalCase` (ex: `ViagemService`)
- Métodos: `camelCase` (ex: `buscarViagem()`)
- Constantes: `UPPER_SNAKE_CASE` (ex: `MAX_BUDGET`)
- Packages: `com.empresa.viagens.feature`

### Imports

```java
// Use specific imports
import com.empresa.viagens.model.Viagem;

// Avoid wildcard imports
// ❌ import com.empresa.viagens.model.*;
```bash

### Comentários

```java
/**
 * Descrição clara do método.
 * 
 * @param id ID da viagem
 * @return Optional contendo a viagem se encontrada
 */
public Optional<Viagem> buscarPorId(Long id) {
  // Implementação
}
```bash

---

## 💬 Commit Messages

Seguimos o padrão Conventional Commits:

```bash
# Formato
type(scope): subject

# Tipos
feat      - Nova feature
fix       - Bug fix
docs      - Documentação
style     - Formatação, sem mudança lógica
refactor  - Refatoração de código
perf      - Melhorias de performance
test      - Adição de testes
chore     - Build, dependencies, etc

# Exemplos
feat(api): adicionar endpoint de recomendações
fix(auth): corrigir validação de token JWT
docs(readme): atualizar instruções de setup
perf(ml): otimizar algoritmo de recomendação
```bash

---

## 🧪 Testes

### Executar Testes

```bash
# Todos os testes
./mvnw test

# Teste específico
./mvnw test -Dtest=ViagemServiceTest

# Com coverage
./mvnw test jacoco:report
```bash

### Escrever Testes

```java
@Test
public void deveBuscarViagemPorId() {
  // Arrange
  Viagem viagem = new Viagem(1L, "Rio");
  when(repository.findById(1L)).thenReturn(Optional.of(viagem));
  
  // Act
  Optional<Viagem> resultado = service.buscarPorId(1L);
  
  // Assert
  assertTrue(resultado.isPresent());
  assertEquals("Rio", resultado.get().getNome());
}
```bash

### Requisitos

- ✅ Cobertura mínima: 80%
- ✅ Todos os testes devem passar
- ✅ Sem código comentado
- ✅ Nomes descritivos

---

## 📚 Documentação

### JavaDoc

```java
/**
 * Calcula a pontuação de recomendação para um destino.
 * 
 * A pontuação leva em conta: preferências do usuário (40%),
 * ajuste de orçamento (30%), e avaliação do destino (30%).
 * 
 * @param profile Perfil do usuário
 * @param destino Destino a ser avaliado
 * @return Pontuação entre 0.0 e 1.0
 * @throws IllegalArgumentException se destino for null
 */
public double calcularScore(UserProfile profile, Destino destino) {
  // Implementation
}
```bash

### README Updates

Se adicionar feature significativa, atualize o README:

```markdown
### Novas Features
- Recomendação de destinos com IA
- Validação de entrada robusta
- Caching de resultados
```bash

---

## 🔀 Pull Requests

### Template de PR

```markdown
## Descrição
Breve descrição do que foi implementado.

## Tipo de Change
- [ ] Bug fix
- [ ] Nova feature
- [ ] Breaking change
- [ ] Documentação

## Como Foi Testado
Descreva os testes que você realizou.

## Checklist
- [ ] Código segue style guidelines
- [ ] Executei testes localmente
- [ ] Adicionei testes novos
- [ ] Atualizei documentação
- [ ] Sem breaking changes
```bash

### Revisão de PR

- Espere pelo menos 1 code review
- Responda aos comentários constructivamente
- Faça ajustes conforme solicitado
- Aguarde aprovação final

---

## 🐛 Reporting Bugs

### Antes de Reportar

1. Atualize para a versão mais recente
2. Verifique issues existentes
3. Procure na documentação

### Como Reportar

1. Abra uma issue no GitHub
2. Use título descritivo
3. Forneça steps para reproduzir
4. Inclua screenshots/logs
5. Especifique sua versão de Java/OS

### Template de Bug

```markdown
## Descrição
O que não está funcionando?

## Steps to Reproduce
1. Vá para...
2. Clique em...
3. Veja o erro

## Comportamento Esperado
O que deveria acontecer?

## Informações do Sistema
- Java: 17
- OS: Ubuntu 22.04
- Browser: Chrome 120
```bash

---

## ✨ Sugestões de Features

### Antes de Sugerir

- Verifique existing issues/discussions
- Considere se alinha com o roadmap
- Pense no impacto na arquitetura

### Como Sugerir

1. Abra uma discussion (não issue)
2. Descreva o use case
3. Explique o benefício
4. Forneça exemplos

### Template de Feature

```markdown
## Descrição
O que você gostaria que fosse adicionado?

## Caso de Uso
Por que isso é importante?

## Solução Proposta
Como você imaginaria implementar isso?

## Alternativas
Outras abordagens?

## Contexto Adicional
Links, referências, etc.
```bash

---

## 📦 Dependências

### Adicionando Dependências

```bash
# Antes de adicionar uma nova dependência:
# 1. Verifique se realmente é necessária
# 2. Pesquise alternativas
# 3. Considere o tamanho e licença
# 4. Atualize pom.xml
# 5. Documente o motivo
```bash

### Padrão para pom.xml

```xml
<!-- Manter organizado e comentado -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <!-- Versão gerenciada pelo parent -->
</dependency>
```bash

---

## 🚀 Dicas para Sucesso

✅ **Comece pequeno**: Escolha uma issue pequena primeiro  
✅ **Comunique**: Comente na issue antes de trabalhar  
✅ **Testes**: Sempre adicione testes  
✅ **Documentação**: Atualize docs com mudanças  
✅ **Revisão**: Pedir feedback cedo  
✅ **Rebase**: Mantenha commit history limpo  
✅ **Respeito**: Seja respeitoso com feedback  

---

## ❓ Perguntas?

- **Issues**: Abra uma issue se encontrar um problema
- **Discussions**: Use discussions para dúvidas
- **Email**: Entre em contato: felipe@example.com
- **Discord**: [Link para servidor (futuro)]

---

## 📜 Licença

Por contribuir, você concorda que suas contribuições serão licenciadas sob a MIT License.

---

**Obrigado por contribuir!** 🎉

Suas contribuições fazem o Viagens melhor para todos!

[Voltar ao README](README.md) | [Ver Roadmap](ROADMAP.md)
