FROM maven:3.6.0-jdk-8
USER root
RUN mkdir -p /gist_test
RUN chmod 777 -R /gist_test
WORKDIR /gist_test
COPY pom.xml .
RUN mvn -B dependency:resolve
RUN mvn -B dependency:resolve-plugins
COPY . .
CMD ["mvn","clean","test","-DGET_COMMENT=$GET_COMMENT","-DEDIT_COMMENT=$GET_COMMENT","-DDELETE_COMMENT=$DELETE_COMMENT"]