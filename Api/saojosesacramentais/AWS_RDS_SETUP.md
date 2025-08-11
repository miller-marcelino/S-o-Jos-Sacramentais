# Configuração do Amazon RDS MySQL Free Tier

## Passos para criar o banco de dados na AWS:

### 1. Acesse o AWS Console
- Vá para https://aws.amazon.com/
- Faça login na sua conta AWS
- Se não tiver conta, crie uma gratuita (Free Tier)

### 2. Navegue até o RDS
- No console AWS, procure por "RDS"
- Clique em "Criar banco de dados"

### 3. Configure o banco de dados
- **Tipo de banco de dados**: MySQL
- **Template**: Free tier
- **Configurações do banco de dados**:
  - Nome do banco de dados: `saojosesacramentais` (ou o nome que preferir)
  - Nome de usuário: `admin` (ou outro nome)
  - Senha: Crie uma senha forte

### 4. Configurações de instância
- **Classe de instância**: db.t3.micro (Free tier)
- **Armazenamento**: 20 GB (gratuito)
- **Armazenamento provisionado**: Desmarcado

### 5. Conectividade
- **Rede virtual**: Default VPC
- **Sub-rede pública**: Sim
- **Grupo de segurança**: Crie um novo
- **Porta**: 3306 (padrão MySQL)

### 6. Configurações adicionais
- **Backup automático**: Sim
- **Janela de backup**: Escolha um horário
- **Retenção**: 7 dias (gratuito)

### 7. Criar o banco de dados
- Clique em "Criar banco de dados"
- Aguarde a criação (pode levar alguns minutos)

### 8. Obter as informações de conexão
Após a criação, você receberá:
- **Endpoint**: algo como `saojosesacramentais.abc123.us-east-1.rds.amazonaws.com`
- **Porta**: 3306
- **Nome do banco**: saojosesacramentais
- **Usuário**: admin
- **Senha**: a que você definiu

### 9. Atualizar o application.properties
Substitua no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://SEU_ENDPOINT_AQUI:3306/saojosesacramentais?useTimezone=true&serverTimezone=America/Sao_Paulo&useSSL=true&requireSSL=false
spring.datasource.username=admin
spring.datasource.password=SUA_SENHA_AQUI
```

### 10. Configurar grupo de segurança
- No console RDS, vá em "Grupos de segurança"
- Adicione uma regra de entrada:
  - Tipo: MySQL/Aurora
  - Porta: 3306
  - Origem: 0.0.0.0/0 (para desenvolvimento) ou seu IP específico

## Importante:
- O Free Tier da AWS RDS tem limite de 750 horas por mês
- Após 12 meses, você pode ser cobrado
- Para produção, considere usar variáveis de ambiente para senhas
- Nunca commite senhas no repositório Git

## Alternativas gratuitas:
1. **Railway** - Oferece PostgreSQL gratuito
2. **PlanetScale** - MySQL gratuito
3. **Supabase** - PostgreSQL gratuito
4. **MongoDB Atlas** - MongoDB gratuito 