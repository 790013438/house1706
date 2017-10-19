```java
Pattern patter = Patter.compile("\\w{6, 20}");
Matcher matcher = pattern.matcher("jackfruedjackfruedjackfrued");//贪婪匹配

while (matcher.find()) {
    System.out.prinf
}
```
> 正则表达式30分钟入门
> 惰性匹配
```java
"\\w{6, 20}?"
```
