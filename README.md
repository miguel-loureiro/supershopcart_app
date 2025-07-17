# SuperShopCart App - Java Backend (Spring Boot)

## 🧱 Initial Architecture

- **Backend**: Java Spring Boot
- **Frontend**: Kotlin Android app (to be implemented later)
- **Database**: PostgreSQL (or H2 for local testing)

## 📄 Entity: `GroceryItem.java`

```java
@Entity
public class GroceryItem {
    

    // Constructors, Getters and Setters
}
```

## 🧍 Entity: `Shopper.java`

```java
@Entity
@Table(name = "shoppers")
public class Shopper {
    

    // Constructors, Getters and Setters
}
```

## 🛒 Entity: `ShopCartList.java`

```java
@Entity
public class ShopCart {

   
    // Getters and Setters
}
```

## 📁 Repositories

```java

```

## ⚙️ application.properties

```properties

```

## ✅ Recommended JDK for VS Code

### JDK 17 (LTS)

- Compatible with Spring Boot 2.6+ and 3.x
- Supported until 2029
- Stable and widely adopted

### Suggested Builds

- Adoptium Temurin 17
- Amazon Corretto 17
- Zulu OpenJDK 17

### Setup in VS Code

1. Install Java Extension Pack
2. Set JDK via `Java: Configure Java Runtime`
3. Verify in terminal:

```bash
java -version
javac -version
```

Should return something like:

```bash
openjdk version "17.x.x"
```
