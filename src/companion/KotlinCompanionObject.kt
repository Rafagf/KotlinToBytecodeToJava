package companion

class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

//val instance = MyClass.create()
