# 🚀 Challenge Backend Java - Microservices

Este proyecto implementa dos microservicios en Java utilizando **Spring Boot 3 + WebFlux**, cumpliendo con comunicación reactiva entre servicios.

---

# 🧩 Arquitectura

```
ms-clients  ←─── WebClient ───→  ms-orders
```

* **ms-clients**: Gestión de clientes
* **ms-orders**: Consume clientes vía WebClient

---

# ⚙️ Tecnologías

* Java 17
* Spring Boot 3
* WebFlux (reactivo)
* WebClient
* Lombok
* JUnit 5 + Mockito
* Docker + Docker Compose

---

# 📦 Estructura del proyecto

```
challenge-backend/
├── ms-clients/
├── ms-orders/
└── docker-compose.yml
```

---

# ▶️ Cómo ejecutar los microservicios

## 🔹 Opción 1: Ejecutar manualmente

### 1. Levantar ms-clients

```bash
cd ms-clients
mvn spring-boot:run
```

👉 Disponible en:

```
http://localhost:8081
```

---

### 2. Levantar ms-orders

```bash
cd ms-orders
mvn spring-boot:run
```

👉 Disponible en:

```
http://localhost:8082
```

---

## 🔹 Opción 2: Ejecutar con Docker

### 1. Construir imágenes

```bash
mvn clean install
```

---

### 2. Levantar todo

```bash
docker-compose up --build
```

---

# 🧪 Cómo probar los microservicios

---

## 🔹 1. Crear un cliente

**Endpoint:**

```
POST http://localhost:8081/clients
```

**Body:**

```json
{
  "id": 1,
  "name": "Carlos",
  "email": "test@mail.com"
}
```

---

## 🔹 2. Obtener cliente directamente

```
GET http://localhost:8081/clients/1
```

---

## 🔹 3. Probar comunicación entre microservicios 🚀

```
GET http://localhost:8082/orders/client/1
```

---

## 🔍 Flujo interno

1. Cliente llama a `ms-orders`
2. `ms-orders` usa **WebClient**
3. Llama a `ms-clients`
4. `ms-clients` responde
5. `ms-orders` retorna el resultado

---

# ❌ Manejo de errores

Si el cliente no existe:

```
GET http://localhost:8082/orders/client/999
```

👉 Resultado esperado:

* Error controlado desde `ms-orders`
* Manejo reactivo con `onErrorResume`

---

# 🧪 Ejecutar tests

```bash
mvn test
```

Incluye:

* Tests de Service
* Tests de Controller
* Uso de Mockito
* Uso de WebTestClient

---

# 🐳 Notas sobre Docker

Cuando se ejecuta con Docker:

* `ms-orders` se comunica con:

```
http://ms-clients:8080
```

(no usar localhost dentro de contenedores)

---

# 🚨 Problemas comunes

| Problema           | Causa                         |
| ------------------ | ----------------------------- |
| Connection refused | ms-clients no está corriendo  |
| Puerto ocupado     | Otro proceso usando 8081/8082 |
| 404                | Endpoint incorrecto           |
| Timeout            | URL mal configurada           |

---

# 🧠 Conceptos aplicados

* Programación reactiva (Mono / Flux)
* WebClient (no bloqueante)
* Programación funcional (Streams, Optional)
* Arquitectura por capas
* Manejo de errores centralizado

---

# 🚀 Próximas mejoras

* API Gateway
* Seguridad JWT
* Base de datos real (PostgreSQL)
* Kafka (event-driven)
* Observabilidad (logs + tracing)

---

# 👨‍💻 Autor

Proyecto desarrollado por **Carlos Paz** como parte de un challenge técnico Backend Java.
