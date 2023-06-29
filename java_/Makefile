srcfile:=$(shell ls -R | grep "$(test).*Test.java" | sed "s/.java$///")
run:
	gradle clean test --tests $(srcfile)
