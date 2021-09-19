# KDA
KDA is a compatibility layer for [JDA](https://github.com/DV8FromTheWorld/JDA) and Kotlin built for easy use of it with Kotlin

## This is still work in progress!

### Create messages
```kotlin
message { 
  content = "This is an example message!"

  actionRow { 
    button {
      id = "example"
      label = "Example button"
      style = ButtonStyle.PRIMARY
    }
  }      
}
```

<br>
TODO...
