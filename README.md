Hello World! (WAR-style)
===============

This is the simplest possible Java webapp for testing servlet container deployments.  It should work on any container and requires no other dependencies or configuration.

Environment Setup
===============
1. Download and Install [Vagrant.](https://www.vagrantup.com/downloads.html)
2. Download and install [VirtualBox.](https://www.virtualbox.org/wiki/Downloads)
3. Start a Vagrant box with Docker. For example: [williamyeh/ubuntu-trusty64-docker.](https://app.vagrantup.com/williamyeh/boxes/ubuntu-trusty64-docker)
  ```
  vagrant init williamyeh/ubuntu-trusty64-docker
  vagrant up
  ```
  3.1 If required add configuration to the Docker service at: ```/etc/default/docker```

  3.2 [Configure the "Port Forwarding"](http://www.jhipster.tech/tips/020_tip_using_docker_containers_as_localhost_on_mac_and_windows.html) on the running VM in VirtualBox to expose the required ports for the Docker containers you would launch.

4. Download the official Jenkins image:
  ```
  docker pull jenkins/jenkins:lts
  ```
5. Launch the Jenkins container:
  ```
  docker run --name jenkins -d -p 8090:8080 -p 50000:50000 -v jenkins_home:/var/jenikns_home jenkins/jenkins:lts
  ```
Another option is to install Jenkins on the VM. This is more suitable if you want to build docker images:

1. Install JDK 8
```
apt-get install software-properties-common python-software-properties
add-apt-repository ppa:openjdk-r/ppa
apt-get update
apt-get install openjdk-8-jdk
```

There is a nasty bug installing JAVA on Ubuntu.
The fix is simple:

```
apt-get install --reinstall ca-certificates-java
update-ca-certificates -f
```

2. Install Jenkins
3. Install mvn as well
```
sudo apt-get purge maven maven2 maven3
sudo apt-add-repository ppa:andrei-pozolotin/maven3
sudo apt-get update
sudo apt-get install maven3
```




Jenkins Configuration
===============
1. Install the _Job DSL Plugin_.
