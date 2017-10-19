# Apache thrift demo --

Install thrift to compile .thrift files. On mac OS use "brew install thrift".  
 
To compile .thrift files run "thrift --gen java -out src/main/java src/thrift/QueryRemote.thrift" under thrift_server.  
  
Do "gradle uploadArchives" under thrift_server to create a JAR artifact and deploy to local maven cache.  

