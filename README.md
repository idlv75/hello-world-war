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

  3.2 Configure the "Port Forwarding" on the running VM in VirtualBox to expose the required ports for the Docker containers you would launch.

4. Download the official Jenkins image:
  ```
  docker pull jenkins/jenkins:lts
  ```
5. Launch the Jenins container:
  ```
  docker run --name jenkins -d -p 8090:8080 -p 50000:50000 -v jenkins_home:/var/jenikns_home jenkins/jenkins:lts
  ```
