字面常量
```javascript 
var flag = /^\w{6,20}$/.test(username);
``` 

```javascript 
function (evt) {
    evt.preventDefault();//阻止事件的默认行为
}
```

> javascript里的this, 谁调用谁是this

*** 
:frog: :frog: :frog: 
    
```javascript 
    $('#username').val('tom')
``` 
> * 传值

```javascript 
    $('#username').val()
``` 
* 取值
::unamused: :unamused: :unamused: 
***
## jquery
> * 每个jQuery对象相当于数组

## javascript
* 函数没有重载的概念
> 后面的会覆盖前面的
```javascript
foo() {
}
foo(int a, int b) {
}
```
* 调用时只用foo()

```javascript
function f (n) {
    if (n == 0 || n == 1) {
        return 1;
    }
    return n * arguments.callee(n - 1);
}
```
```javascript
arguments.callee(n - 1);
```
* 这段代码是调用自己
