`jbin`
======

## Binary Executables in Pure Java.

`jbin` allows you to **create binary executables in Java**, similar to using a [shebang](http://en.wikipedia.org/wiki/Shebang_%28Unix%29) in a Python, PHP, or Bash script.

Think of `jbin` as the replacement for a shebang in a Java program. **Instead of running `java -jar HelloWorld.jar` or `java HelloWorld`, you can execute the generated binary with `./HelloWorld` or simply `HelloWorld` if you place it in your `$PATH`.**

`jbin` adds no additional baggage or code to your project and ensures that it's as lightweight as it was before using `jbin`.
