javac src\main\java\com\shadowcoder\ai\*.java src\main\java\com\shadowcoder\ui\*.java src\main\java\com\shadowcoder\theme\*.java
jar -cvfe GuessWho.jar com.shadowcoder.ui.MainFrame src\main\java\com\shadowcoder\ai\*.class src\main\java\com\shadowcoder\ui\*.class src\main\java\com\shadowcoder\theme\*.class
