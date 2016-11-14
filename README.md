# Notes2-clean-architecture-kata

This project shows how to refactor an app in order to separate code in layers. 

First commits are creating an app where everything is coupled:
```
6161fcd first commit
d8a6316 User Interface
e96f0fe Realm
23213f1 Saving in Realm
```

Then refactor start to happend, first abstract the view and the Presenter:
```
b16436f View-Presenter
a86b3cf refactor
```

Then complete the presentarion layer with a model:
```
56d4743 Refactor into MVP
```

Split the model in several layers to decouple bussines logic from implementation
```
e02dc26 Clean Code
6994841 refactor CLEAN
```

Cover with unit testing (just an example)
```
14dead2 Unit Test Example
```
