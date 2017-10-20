
* java用annotation，做后端的验证
```java
@Pattern(regexp = "^\\w{6,20}$")
@DecimalMin(value="1.25")
@DecimalMax(value="5.23")
@Digits(integer = 5, faction=2)
```
