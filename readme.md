# 🌦️ Weather API Wrapper

Uma API leve desenvolvida em Java que busca e retorna dados climáticos de um provedor externo (`wttr.in`), utilizando Redis para cachear as respostas e evitar chamadas desnecessárias.

> 📌 Projeto baseado no desafio do [Weather API Wrapper](https://roadmap.sh/projects/weather-api-wrapper-service) do roadmap.sh

---

## 🚀 Funcionalidades

- 🌍 Consulta dados do clima para qualquer cidade usando [wttr.in](https://wttr.in/)
- ⚡ Usa Redis para cachear as respostas
- 🔁 Reutiliza dados já consultados anteriormente
- ⌛ Suporte a tempo de expiração no cache (recomendado)
- 🔐 Variáveis de ambiente com `.env`
- 
![](schema.png)
---

## 📦 Tecnologias Utilizadas

- **Java 22**
- **Redis** (com Jedis)
- **HttpServer** nativo do Java
- **wttr.in** como fonte de dados climáticos
- **dotenv-java** para ler variáveis de ambiente

---

## 🛠️ Como Usar

### ✅ Pré-requisitos

- Java 17 ou superior
- Redis instalado e rodando localmente
- Maven

### 📁 Clonar o projeto

```bash
git clone https://github.com/seu-usuario/weather-api-wrapper.git
cd weather-api-wrapper


### ⚙️ Criar o arquivo `.env`

```env
REDIS_URL=redis://localhost:6379
```

### 🔨 Rodar o projeto

```bash
mvn clean package
java -cp target/classes org.example.Main
```

---

## 🌐 Como Fazer Requisições

### Rota

```http
GET /weather/{cidade}
```

**Exemplo:**

```http
GET http://localhost:3000/weather/Sao%20Paulo
```

### Retorno

O servidor retorna os dados do tempo no formato JSON, vindos diretamente do `wttr.in`.

---

## 📌 Observações

* Os resultados ficam salvos no Redis com o nome da cidade como chave.
* É possível configurar tempo de expiração no cache (ex: 12 horas com `EX`).
* Ainda é possível adicionar melhorias como tratamento de erros e limites de requisições.

---

## 💡 Motivação

Esse projeto foi desenvolvido como parte do desafio do [roadmap.sh](https://roadmap.sh/projects/weather-api-wrapper-service) com o objetivo de praticar o uso de APIs externas, cache com Redis e variáveis de ambiente em Java.

---

## 🧪 Melhorias Futuras

* Adicionar tempo de expiração no Redis (ex: 12 horas)
* Melhorar tratamento de erros (API externa fora do ar, cidade inválida, etc.)
* Implementar limite de requisições
* Adicionar testes unitários
* Fazer deploy em algum serviço de nuvem

---

## 📄 Licença

MIT


