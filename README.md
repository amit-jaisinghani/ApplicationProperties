# utils.ApplicationProperties
A simple way to load all properties required by a java project. This project supports maven. So, you can install this project add dependency given below to use it.

\<groupId>utilities\</groupId> <br>
\<artifactId>application-properties\</artifactId> <br>
\<version>1.0\</version> <br>

How to use the application:

<b>Step 1</b>: Load properties
You can use multiple ways to load properties. Example:
For single file: you can use File object or any inputstream.
For multiple files: you need to create a hashmap of list of properties file and override option.
NOTE: overriding properties is optional.

<b>Step 2</b>: Fetch property
Use getProperty() to get value for the properties.

Sample demo program is added in app. Please refer Demo.java file for usage sample.

I hope this app will help you.
