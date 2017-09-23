Hello World! (Java CI Flow)
===============

This is a simple Maven project that:
- builds a WAR file
- deploys the WAR file to a docker image
- implements a simple Jenkins DSL Release Flow.

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

4. Install Jenkins on the VM

5. Add user jenkins to the docker group:
```
usermod -G docker jenkins
```

6. Install JDK 8 (Optional: Configure in Jenkins)

  ```
  apt-get install software-properties-common python-software-properties
  add-apt-repository ppa:openjdk-r/ppa
  apt-get update
  apt-get install openjdk-8-jdk
  ```

  There is a nasty bug installing JAVA on Ubuntu 14.04.
  The fix is simple:

  ```
  apt-get install --reinstall ca-certificates-java
  update-ca-certificates -f
  ```

7. Install Maven (Optional: configure in Jenkins)
```
sudo apt-get purge maven maven2 maven3
sudo apt-add-repository ppa:andrei-pozolotin/maven3
sudo apt-get update
sudo apt-get install maven3
```

8. [Advanced SSH Configuration](https://stackoverflow.com/questions/18880024/start-ssh-agent-on-login) (In case you need it)

Jenkins Configuration
===============
1. Initialize Jenkins.
2. Install the following plugins:
  - _Job DSL Plugin_
  - _Release Plugin_
  - _Conditional Buildstep_
  - _Maven Release Plug-in_
3. Create a Jenkins Job DSL project and import a DSL script from the __/dsl__ project directory
