CLASSPATH = .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/commonmark-0.18.1.jar:.

debug-test: MarkdownParseTest.class
	jdb -classpath $(CLASSPATH) org.junit.runner.JUnitCore MarkdownParseTest

test: MarkdownParseTest.class
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
	javac -g -cp $(CLASSPATH) MarkdownParseTest.java  

MarkdownParse.class: MarkdownParse.java
	javac -g -cp $(CLASSPATH) MarkdownParse.java