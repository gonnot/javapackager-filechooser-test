# Java APP for macOS

Sample project to demonstrate the macOS 10.15 Catalina file access.

Heavily inspired by [sorghumking/catalinaFileChooserAccessTest](https://github.com/sorghumking/catalinaFileChooserAccessTest)

Code using https://github.com/fvarrui/JavaPackager/issues

# How to reproduce

### Problem


1. Compile and generate the macOS APP - `mvn package`
2. Run `SampleAPP/SampleAPP.app`
3. Try 

NB: For macOS the application is viewed as a BASH application

### Potential solution

Using `shc` to compile natively `universalJavaApplicationStub`

