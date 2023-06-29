srcfile:=$(shell ls -R | grep -i "$(test).*Test.java" | sed "s/.java$///")
run:
	gradle clean test --tests $(srcfile)
