# 📌 São José Sacramentais

Sistema para gerenciamento de atividades e informações da loja São José Sacramentais.  
O projeto é dividido em **Back-end** (Spring Boot + MySQL) e **Front-end** (React), com integração a APIs externas e automações.

---

## 🛠 Tecnologias Utilizadas

### **Back-end**
- Java 17
- Spring Boot 3.5.3
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Google API Client & YouTube Data API
- Selenium WebDriver & WebDriverManager
- Jackson (JSON Processing)

### **Front-end**
- React 19
- React Router DOM
- Bootstrap 5 / React Bootstrap
- Axios
- SASS
- jsPDF + AutoTable
- React Icons

---

## 📂 Estrutura do Projeto

```
📦 saojosesacramentais
 ┣ 📂 backend  (Spring Boot API)
 ┃ ┣ 📂 src/main/java
 ┃ ┣ 📂 src/main/resources
 ┃ ┗ pom.xml
 ┣ 📂 frontend (React App)
 ┃ ┣ 📂 src
 ┃ ┣ 📂 public
 ┃ ┗ package.json
 ┗ README.md
```

---

## ⚙️ Configuração do Back-end

### **Pré-requisitos**
- Java 17 instalado
- Maven 3.x instalado
- MySQL em execução

### **Configuração do Banco de Dados**
No arquivo `application.properties` ou `application.yml`, configure:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/saojosesacramentais
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### **Rodando o Back-end**
```bash
cd backend
mvn spring-boot:run
```
API disponível em: **http://localhost:8080**

---

## ⚙️ Configuração do Front-end

### **Pré-requisitos**
- Node.js 18+
- NPM ou Yarn

### **Instalando Dependências**
```bash
cd frontend
npm install
```

### **Rodando o Front-end**
```bash
npm start
```
Aplicação disponível em: **http://localhost:3000**

---

## 📌 Funcionalidades
- Cadastro e gerenciamento de dados da loja
- Relatórios em PDF com **jsPDF**
- Integração com **YouTube API**
- Automação com **Selenium WebDriver**
- Consumo de API REST via **Axios**
- Interface responsiva com **Bootstrap e SASS**

---

## 📄 Licença
Projeto de uso interno. Licença não definida.

---

## ✉️ Contato
📧 **miller.marcelino3@gmail.com**
📧 **(81) 9.9525-2696**

