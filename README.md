# Parrot Refactoring Kata

Este projeto é uma implementação refatorada do **Parrot Refactoring Kata**, um exercício clássico de programação que demonstra técnicas de refatoração e aplicação de princípios SOLID.

## 📋 Projeto Original

O kata original apresentava um código com vários "code smells" típicos:
- Método extenso com múltiplas condicionais
- Números mágicos espalhados pelo código
- Violação do princípio Open/Closed
- Dificuldade para adicionar novos tipos de papagaios

## 🎯 Objetivo

Demonstrar técnicas de refatoração aplicando:
- **Strategy Pattern** através de polimorfismo
- **Factory Pattern** para criação de objetos
- **Eliminação de números mágicos**
- **Princípios SOLID**

## 🏗️ Arquitetura Atual

### Hierarquia de Classes

```
Parrot (abstract)
├── EuropeanParrot
├── AfricanParrot
└── NorwegianParrot
```

### Componentes

- **`Parrot`**: Classe abstrata base com constantes compartilhadas
- **`ParrotTypeEnum`**: Enum com factory method para criação de papagaios
- **Subclasses específicas**: Implementações concretas de cada tipo

## 🔧 Melhorias Implementadas

### 1. **Eliminação de Números Mágicos**
**Antes:**
```java
// Números espalhados pelo código
return Math.max(0, 12.0 - 9.0 * numberOfCoconuts);
return Math.min(24.0, voltage * 12.0);
```

**Depois:**
```java
// Constantes nomeadas e centralizadas
protected static final double BASE_SPEED = 12.0;
private static final double LOAD_FACTOR = 9.0;
private static final double MAX_SPEED = 24.0;
```

### 2. **Transformação de Métodos em Constantes**
**Antes:**
```java
// Métodos que apenas retornavam valores fixos
protected double getBaseSpeed() {
    return 12.0;
}

protected double getLoadFactor() {
    return 9.0;
}
```

**Depois:**
```java
// Constantes nomeadas 
protected static final double BASE_SPEED = 12.0; //Classe base
private static final double LOAD_FACTOR = 9.0; //Subclasse AfricanParrot
```

- Métodos `getBaseSpeed()` e `getLoadFactor()` transformados em constantes
- `BASE_SPEED` centralizada na classe base `Parrot`
- Elimina duplicação de código e chamadas de método desnecessárias
- Melhora performance e facilita manutenção

### 3. **Imutabilidade de Campos**
```java
private final int numberOfCoconuts; // Marcado como final
```
- Campos que não mudam após construção são `final`
- Melhora a segurança e clareza do código

### 4. **Factory Pattern Melhorado**
```java
public static Parrot createParrot(ParrotTypeEnum type, int numberOfCoconuts, 
                                 double voltage, boolean isNailed) {
    return switch (type) {
        case EUROPEAN -> new EuropeanParrot();
        case AFRICAN -> new AfricanParrot(numberOfCoconuts);
        case NORWEGIAN_BLUE -> new NorwegianParrot(voltage, isNailed);
    };
}
```

### 5. **Métodos Auxiliares**
- `getBaseSpeed()` em `NorwegianParrot` para melhor legibilidade
- Separação de responsabilidades no cálculo de velocidade

## 📊 Benefícios das Refatorações

### **Manutenibilidade**
- Código mais legível e autoexplicativo
- Fácil localização e alteração de constantes
- Estrutura clara da hierarquia

### **Extensibilidade**
- Adicionar novos tipos de papagaios é simples
- Basta criar nova subclasse e adicionar ao enum
- Não requer modificação do código existente

### **Testabilidade**
- Cada classe tem responsabilidade única
- Métodos menores e mais focados
- Fácil criação de testes unitários

### **Performance**
- Constantes `static final` são mais eficientes
- Eliminação de chamadas de método desnecessárias

## 🛠️ Tecnologias

- **Java 17+** (uso de switch expressions)
- **Maven/Gradle** para build
- **JUnit** para testes (sugerido)

## 🏃‍♂️ Como Executar

```bash
# Clonar o repositório
git clone https://github.com/Shyuu7/Parrot-Refactoring-Kata.git

# Compilar
mvn compile
# ou
gradle build

# Executar testes
mvn test
# ou
gradle test
```

## 📚 Princípios Aplicados

### **SOLID**
- **S**RP: Cada classe tem uma responsabilidade única
- **O**CP: Aberto para extensão, fechado para modificação
- **L**SP: Subclasses podem substituir a classe base
- **I**SP: Interfaces focadas (métodos abstratos essenciais)
- **D**IP: Dependência de abstrações, não implementações

### **Clean Code**
- Nomes descritivos para constantes e métodos
- Métodos pequenos e focados
- Eliminação de duplicação
- Código autoexplicativo

---

Este projeto demonstra como técnicas simples de refatoração podem transformar código legado em uma estrutura limpa, maintível e extensível.
