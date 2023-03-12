# My own Notepad-like text editor.

### Purpose
Swing is a popular technology for creating GUI in Java.

Swing requires a lot of configuration code, which is not directly related to program functionality.

At it's core Spring framework is just an IoC container. One of crucial use cases for IoC is reduction of
configuration code.

It seemed interesting to investigate if Spring IoC (and Spring Boot, as easy way to use IoC) could simplify 
Swing UI configuration...

### Result
Notepad-like text editor. Swing is used as GUI, Spring Boot successfully used to simplify Swing configuration.
Features:
1. Open, save, save as files
2. Edit text in notepad/Nano way
3. Search though text: substring and regex modes