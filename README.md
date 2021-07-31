# java-jna-demo
a demo project that shows an example use of JNA (Java Native Access)

Java Native Access (JNA)
========================

JNA provides Java programs easy access to native shared libraries without writing anything but Java code - no JNI or native code is required. This functionality is comparable to Windows' Platform/Invoke and Python's ctypes.

JNA allows you to call directly into native functions using natural Java method invocation. The Java call looks just like the call does in native code. Most calls require no special handling or configuration; no boilerplate or generated code is required.

Many projects make use of JNA. For further information and use cases look in [official JNA page](https://github.com/java-native-access/jna)


Development process
-------------------

Identify a native target library that you want to use. This can be any shared library with exported functions. Many examples of mappings for common system libraries, especially on Windows, may be found in the jna-platform package.

Make your target library available to your Java program:
- set the jna.library.path system property to the path to your target library;
- change path environment variable before launching the VM;
- make your native library available on your classpath, under the path {OS}-{ARCH}/{LIBRARY}, where {OS}-{ARCH} is JNA's canonical prefix for native libraries (e.g. win32-x86, linux-amd64, or darwin). If the resource is within a jar file it will be automatically extracted when loaded.

Declare a Java interface to hold the native library methods by extending the Library interface.

Within this interface, define an instance of the native library using the Native.load(Class) method, providing the native library interface you defined previously.

Declare methods that mirror the functions in the target library by defining Java methods with the same name and argument types as the native function (refer to the basic mappings below or the detailed table of type mappings). You may also need to declare native structures to pass to your native functions. To do this, create a class within the interface definition that extends Structure and add public fields (which may include arrays or nested structures).

Then invoke methods on the library instance just like any other Java class.

*Example of such usage can be found in com.sankdev.examples.DemoKernel32Load.

Optimized Direct Mapping
------------------------
JNA provides an additional method of mapping native methods, that can improve performance.  You may declare a class to hold your native methods, declare any number of methods with the `native` qualifier, and invoke `Native.register(String)` in the class static initializer with your library's name. See [JNA Direct Mapping](https://github.com/java-native-access/jna/blob/master/www/DirectMapping.md) for an example.