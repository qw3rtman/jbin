`jbin`
======

## Binary Executables in Pure Java.

`jbin` allows you to **create binary executables in Java**, similar to using a [shebang](http://en.wikipedia.org/wiki/Shebang_%28Unix%29) in a Python, PHP, or Bash script.

Think of `jbin` as the replacement for a shebang in a Java program. **Instead of running `java -jar HelloWorld.jar` or `java HelloWorld`, you can execute the generated binary with `./HelloWorld` or simply `HelloWorld` if you place it in your `$PATH`.**

`jbin` adds no additional baggage or code to your project and ensures that it's as lightweight as it was before using `jbin`.

## Getting Started
After the [super painless drag-and-drop installation](#installation), suppose you want to create a life-changing program that will have a stark effect on the world called `Hello`.

You sit down, dust off your Java compiler, and proceed to spend the next four years of your life working twenty hours a day. Then comes the day you are finally able to show off your masterpiece.

```java
public class Hello
{
	public static String sayHello()
	{
		return "Hello, world!";
	}

	public static void main(String[] args) {
		System.out.println(Hello.sayHello());
	}
}
```

You're ecstatic, all those years of hard work have finally paid off!

You decide to package your killer new program as a `JAR`; after all, **it's the standard**. Whenever someone wants to use your insanely-useful program, they'll have to:

```sh
$ java -jar Hello.jar
```

Hmm, you think. That's a bit overkill. **Shouldn't it be easier for my users to use my amazing program than that? Why is the standard so awkward?**

This is where `jbin` steps into the equation. You decide to run:

```sh
$ jbin Hello.jar Hello
```

You're presented with a new file, an executable binary by the name `Hello`. You run:

```sh
$ ./Hello
```

You're amazed; everything works as expected!

You wonder what happens if you copy this executable binary to your `$PATH`.

```sh
$ cp Hello /usr/local/bin
```

Trembling with excitement, you slowly type the command that may change your life forever:

```sh
$ Hello
```

Eureka! **Writing executable binaries in the language you're comfortable with is now a reality. You can finally sleep at night.**

You can now distribute a cleaner, leaner, and meaner binary executable for your users.

## Usage
### Generating an executable binary from an existing JAR
```sh
$ jbin Hello.jar Hello
```
Where `Hello.jar` is the existing JAR. `Hello` is the name of the executable binary that will be generated.

### Generating an executable binary from a bunch of Java source files (.java)
```sh
$ jbin Sudoku.java Board.java Cell.java Sudoku
```
Where `Sudoku.java`, `Board.java`, and `Cell.java` are the Java source files. `Sudoku` is the name of the executable binary that will be generated.

A JAR will be created with the **first Java source file specified being defined as the `Main-Class` in the `META-INF/MANIFEST.MF`**. This is the file that will be "run" when the executable binary is executed.

## Installation
### Linux and Max OS X
`jbin` can be installed on Unix-based machines (Linux or Mac OS X) by downloading the binary executable and copying it to your `$PATH`.

```sh
$ wget https://github.com/qw3rtman/jbin/archive/jbin
$ mv jbin /usr/local/bin
```

### Windows
There is currently limited support for `jbin` on Windows. This is due to the absence of a shebang or shebang-esque function in MS-DOS. As a result, `jbin` works just fine in [Cygwin](https://www.cygwin.com/). Simply follow the above instructions for Linux and Mac OS X in Cygwin.

`jbin` (obviously) depends on Java. Other than that, `jbin` has no dependencies!

Easy as cake!

## Updating
`jbin` will check for updates on every command and will inform you in the event that `jbin` is out-of-date.

Additionally, you can run `jbin -v` or `jbin --version` to check this manually.

To update, simply run `jbin self-update`.

## Contributing
Contributions are always welcome.

Find something interesting in the TODO below, fork our code, create a new branch, and send us a pull request.

There are only two rules: avoid [code smells](http://blog.codinghorror.com/code-smells/) and abide by the syntax-formatting of the existing code.
.com/qw3rtman>

## TODO
* everything
