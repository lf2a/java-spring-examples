# Bean Validation

O modelo Bean Validation é suportado por restrições na forma de anotações colocadas em um campo, método ou classe de um componente JavaBeans, como um bean gerenciado.

### @AssertFalse
O valor do campo ou propriedade deve ser false.
```java
@AssertFalse
boolean isUnsupported;
```

### @AssertTrue
O valor do campo ou propriedade deve ser true.
```java
@AssertTrue
boolean isActive;
```

### @DecimalMax
O valor do campo ou propriedade deve ser um valor decimal menor ou igual ao número no elemento de valor.
```java
@DecimalMax("30.00")
BigDecimal discount;
```

### @DecimalMin
O valor do campo ou propriedade deve ser um valor decimal maior ou igual ao número no elemento de valor.
```java
@DecimalMin("5.00")
BigDecimal discount;
```

### @Digits
O valor do campo ou propriedade deve ser um número dentro de um intervalo especificado. O elemento `integer`  especifica os dígitos integrais máximos para o número e o elemento `fraction` especifica os dígitos fracionários máximos para o número.
```java
@Digits(integer=6, fraction=2)
BigDecimal price;
```

### @Email
O valor do campo ou propriedade deve ser um endereço de e-mail válido.
```java
@Email
String emailaddress;
```

### @Future
O valor do campo ou propriedade deve ser uma data futura.
```java
@Future
Date eventDate;
```

### @FutureOrPresent
O valor do campo ou propriedade deve ser uma data ou hora no presente ou no futuro.
```java
@FutureOrPresent
Time travelTime;
```

### @Max
O valor do campo ou propriedade deve ser um valor inteiro menor ou igual ao número no elemento de valor.
```java
@Max(10)
int quantity;
```

### @Min
O valor do campo ou propriedade deve ser um valor inteiro maior ou igual ao número no elemento de valor.
```java
@Min(5)
int quantity;
```

### @Negative
O valor do campo ou propriedade deve ser um número negativo.
```java
@Negative
int basementFloor;
```

### @NegativeOrZero
O valor do campo ou propriedade deve ser negativo ou zero.
```java
@NegativeOrZero
int debtValue;
```

### @NotBlank
O valor do campo ou propriedade deve conter pelo menos um caractere diferente de espaço em branco.
```java
@NotBlank
String message;
```

### @NotEmpty
O valor do campo ou propriedade não deve estar vazio. O comprimento dos caracteres ou matriz e o tamanho de uma coleção ou mapa são avaliados.
```java
@NotEmpty
String message;;
```

### @NotNull
O valor do campo ou propriedade não deve ser nulo.
```java
@NotNull
String username;
```

### @Null
O valor do campo ou propriedade deve ser nulo.
```java
@Null
String unusedString;
```

### @Past
O valor do campo ou propriedade deve ser uma data no passado.
```java
@Past
Date birthday;
```

### @PastOrPresent
O valor do campo ou propriedade deve ser uma data ou hora no passado ou presente.
```java
@PastOrPresent
Date travelDate;
```

### @Pattern
O valor do campo ou propriedade deve corresponder à expressão regular definida no regexpelemento.
```java
@Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}")
String phoneNumber;
```

### @Positive
O valor do campo ou propriedade deve ser um número positivo.
```java
@Positive
BigDecimal area;
```

### @PositiveOrZero
O valor do campo ou propriedade deve ser um número positivo ou zero. .
```java
@PositiveOrZero
int totalGoals;
```

### @Size
O tamanho do campo ou propriedade é avaliado e deve corresponder aos limites especificados. Se o campo ou propriedade for um String, o tamanho da string será avaliado. Se o campo ou propriedade for a Collection, o tamanho de Collection é avaliado. Se o campo ou propriedade for a Map, o tamanho de Map é avaliado. Se o campo ou propriedade for uma matriz, o tamanho da matriz será avaliado. Use um dos elementos opcionais max ou min para especificar os limites.
```java
@Size(min=2, max=240)
String briefMessage;
```
