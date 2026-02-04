# ✈️ Viagens - Transformando Experiências de Viagem

<div align="center">

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.10-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.12-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](LICENSE)
[![Status](https://img.shields.io/badge/Status-🚀%20Em%20Desenvolvimento-blue?style=for-the-badge)](https://github.com/seu-usuario/viagens)

**Uma plataforma inovadora para descobrir, reservar e viver incríveis experiências de viagem.**

> 🎯 **Projeto de Evolução Contínua** — Desenvolvido com paixão, técnica e aprendizado diário na jornada de especialização em programação.

</div>

---

## 📋 Conteúdo

- [🌟 Visão Transformadora](#-visão-transformadora)
- [🎯 Nossa Missão](#-nossa-missão)
- [🛠️ Stack Tecnológico](#-stack-tecnológico)
- [✨ Funcionalidades Core](#-funcionalidades-core)
- [🏗️ Arquitetura](#-arquitetura)
- [🚀 Quick Start](#-quick-start)
- [📊 Roadmap de Evolução](#-roadmap-de-evolução)
- [🤝 Contribuindo](#-contribuindo)
- [❤️ Agradecimentos](#-agradecimentos)
- [📄 Licença](#-licença)

---

## 🌟 Visão Transformadora

### O Conceito

**Viagens** reimagina a experiência de encontrar um destino e fazer uma reserva. Queremos transformar um ato rotineiro em algo **mágico, intuitivo e memorável**.

Quando você entra na plataforma, você não está apenas buscando um hotel — está descobrindo histórias, conectando-se com culturas, planejando aventuras que mudarão sua vida.

### O Diferencial

- 🎨 **Experiência Imersiva**: Interface que inspira e emociona
- 🤖 **Recomendações Inteligentes**: IA que entende seus desejos
- ⚡ **Performance Extrema**: Carregamento instantâneo
- 🔒 **Segurança Total**: Dados protegidos com JWT e criptografia
- 📱 **Adaptativo**: Funciona perfeitamente em todos os dispositivos

---

## 🎯 Nossa Missão

### Para Usuários
✅ Tornar a busca por viagens **divertida e reveladora**
✅ Ofertar **recomendações que realmente importam**
✅ Garantir **segurança e confiabilidade** em cada transação
✅ Criar **comunidade de viajantes apaixonados**

### Para Desenvolvedores
✅ Demonstrar **code excellence** em Java/Spring
✅ Implementar **padrões de arquitetura** modernos
✅ Explorar **inovação em IA/ML**
✅ Documentar **jornada de evolução técnica**

---

## 🛠️ Stack Tecnológico

### 🔧 Backend & Framework

| Componente | Versão | Detalhes |
|-----------|--------|---------|
| **Java** | 17 LTS | Modern Java, records, sealed classes |
| **Spring Boot** | 3.5.10 | Framework principal |
| **Spring Security** | 6.x | JWT Authentication + RBAC |
| **Spring Data JPA** | 3.5.10 | ORM com Hibernate |
| **Spring Test** | 3.5.10 | Testes unitários e integração |

### 🗄️ Persistência & Dados

| Componente | Propósito |
|-----------|----------|
| **H2 Database** | Desenvolvimento local |
| **JPA/Hibernate** | ORM automático |
| **Flyway** | Versionamento de schema |

### 📊 Qualidade & Performance

| Tool | Propósito |
|------|----------|
| **JMH Benchmarks** | Profiling e otimização |
| **Spotless** | Code formatting (Google Java Format) |
| **Checkstyle** | Conformidade de estilo |
| **PMD** | Detecção de code smells |
| **SonarQube** | Análise estática avançada |

### 🔐 Segurança

- **JWT Tokens** para autenticação stateless
- **BCrypt** para hash de senhas
- **Role-Based Access Control (RBAC)**
- **Spring Security** com filter chain customizado

---

## ✨ Funcionalidades Core

### 👤 Gestão de Usuários
- ✅ Registro e autenticação com JWT
- ✅ Perfis de usuário (USER, ADMIN, MODERATOR)
- ✅ Sistema de permissões granular
- ✅ Recuperação segura de senha

### 🌍 Descoberta de Destinos
- ✅ Catálogo completo de destinos
- ✅ Filtros avançados (região, clima, orçamento)
- ✅ **Recomendações IA** baseadas em preferências
- ✅ Avaliações e reviews da comunidade

### 📅 Gestão de Reservas
- ✅ Busca de disponibilidade em tempo real
- ✅ Cálculo dinâmico de preços
- ✅ Confirmação instantânea
- ✅ Histórico de reservas

### 💳 Integração de Pagamento
- ✅ Gateway seguro de pagamento (roadmap)
- ✅ Múltiplos métodos de pagamento
- ✅ Transações criptografadas
- ✅ Recibos automáticos

### 🤖 Inteligência Artificial
- ✅ **Engine de Recomendação**: ML baseado em preferências
- ✅ **Análise de Sentimentos**: Feedback dos usuários
- ✅ **Previsão de Demanda**: Otimização de preços
- ✅ **Sugestões Personalizadas**: Destinos similares

---

## 🏗️ Arquitetura

### Estrutura do Projeto

```
src/main/java/com/empresa/viagens/
├── 🎮 controller/          # REST APIs & endpoints
├── 🏪 dto/                 # Transfer Objects (DTOs)
├── 💾 entity/              # JPA Entities & models
├── 🗂️ repository/          # Data Access Layer
├── 🧠 service/             # Business Logic & ML
├── 🔐 security/            # Auth & JWT
└── ⚙️ config/              # Configurações gerais

src/test/java/               # Testes automatizados
```

### Padrões de Design Aplicados

- **DTO Pattern**: Separação entre API e persistência
- **Repository Pattern**: Abstração de dados
- **Service Layer**: Lógica de negócio centralizada
- **Strategy Pattern**: Múltiplas estratégias de recomendação
- **Observer Pattern**: Eventos de reserva

---

## 🚀 Quick Start

### Pré-requisitos

```bash
✅ Java 17 JDK
✅ Maven 3.9+
✅ Git
✅ Seu editor favorito (VS Code, IntelliJ, etc)
```

### Instalação Local

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/viagens.git
cd viagens

# 2. Compile o projeto
./mvnw clean compile

# 3. Execute os testes
./mvnw test

# 4. Inicie a aplicação
./mvnw spring-boot:run
```

### Acessando a Plataforma

```
🌐 API REST:     http://localhost:8080/api
📚 Swagger UI:    http://localhost:8080/swagger-ui.html
💾 H2 Console:    http://localhost:8080/h2-console
```

---

## 📊 Roadmap de Evolução

### 🎯 Fase 1: Core Engine (Atual)
- [x] Setup inicial com Spring Boot
- [x] Autenticação JWT + RBAC
- [x] CRUD de usuários e destinos
- [x] Estrutura de testes
- [ ] **próximo**: Aprimorar UI/UX

### 🚀 Fase 2: Analytics & Insights (Q1 2026)
- [ ] Dashboard executivo
- [ ] Relatórios de reservas
- [ ] Análise de comportamento do usuário
- [ ] Métricas de performance

### 🤖 Fase 3: Inteligência Artificial (Q2 2026)
- [ ] Engine de recomendação avançado
- [ ] Clustering de preferências
- [ ] Previsão de demanda
- [ ] Chatbot de atendimento

---

## 🤝 Contribuindo

Adoraríamos sua ajuda! Este é um projeto **aberto à comunidade** e valorizamos contribuições de todos os níveis.

### Como Contribuir

#### 🐛 **1. Reporte Bugs**
Encontrou um problema? [Abra uma issue](../../issues/new)
- Descreva o que esperava
- Explique o que aconteceu
- Forneça passos para reproduzir

#### 💡 **2. Sugira Melhorias**
Tem uma ideia brilhante? [Compartilhe conosco](../../discussions/new)
- Descreva a feature
- Explique o benefício
- Forneça exemplos de uso

#### 👨‍💻 **3. Desenvolva Código**

```bash
# Fork → Clone → Branch
git clone https://github.com/seu-fork/viagens.git
git checkout -b feature/sua-feature

# Faça commits descritivos
git commit -m "✨ feat: adiciona recomendação de destinos"
git commit -m "🐛 fix: corrige validação de entrada"
git commit -m "📚 docs: atualiza README"

# Push → Pull Request
git push origin feature/sua-feature
```

#### 📝 **4. Melhore Documentação**
- Atualize READMEs
- Crie tutoriais
- Corrija typos

### Diretrizes de Contribuição

✅ Siga o [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
✅ Escreva testes para novas features
✅ Mantenha commits atômicos e descritivos
✅ Atualize documentação conforme necessário
✅ Respeite a estrutura do projeto

---

## ❤️ Agradecimentos

### 🙏 Pessoas Incríveis

Obrigado a todos que contribuem, testam, reportam bugs e compartilham ideias!

- **Comunidade Java** pelo apoio e inspiração
- **Spring Team** pela framework fantástica
- **Todos os developers** que ajudam com feedback

### 📚 Referências & Inspiração

Este projeto é resultado de:
- 📖 Clean Code (Robert C. Martin)
- 🎨 Design Patterns (Gang of Four)
- ⚙️ Spring in Action (Craig Walls)
- 💡 The Pragmatic Programmer

---

## 📞 Contato & Suporte

Ficou com dúvidas? Entre em contato!

| Canal | Link |
|-------|------|
| 📧 **Email** | [heyfelipeee@gmail.com](mailto:heyfelipeee@gmail.com) |
| 🐛 **Issues** | [GitHub Issues](../../issues) |
| 💬 **Discussões** | [GitHub Discussions](../../discussions) |

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License**.

```
MIT License

Copyright (c) 2026 Felipe Duarte

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

Veja o arquivo [LICENSE](LICENSE) para detalhes completos.

---

<div align="center">

### 🌟 Se este projeto ajudou você, deixe uma ⭐!

**Desenvolvido com ❤️ e muita ☕**

*Jornada de evolução contínua. Sempre aprendendo. Sempre crescendo.*

**Vamos transformar viagens em experiências extraordinárias juntos! 🚀✈️**

</div>

