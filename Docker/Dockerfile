FROM adoptopenjdk/openjdk11:alpine-jre

# socket for UI to communicate to
EXPOSE 9090

# copy jar file
# TODO

# For versioning in docker image
ARG VERSION="dev"

LABEL image="com.docker.blah" description="Ally Auction Server" version=$VERSION

# copy the jar to the docker dir
COPY [ "ally-auction-server.jar", "docker/dir" ]
