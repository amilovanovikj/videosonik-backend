# Videosonik Backend App

This repository is a Dockerized and somewhat modified version of the following app: [vavramovski/videosonik-new](https://github.com/vavramovski/videosonik-new). 

Huge thanks to [vavramovski](https://github.com/vavramovski) for letting me use this app for my [Ansible/Docker project](https://github.com/amilovanovikj/videosonik-devops).

## What was changed

- All package and deploy operations, as well as server setup, are done using [Ansible playbooks](https://github.com/amilovanovikj/videosonik-devops/tree/master/playbooks).
- Added the [Dockerfile](https://github.com/amilovanovikj/videosonik-backend/blob/master/Dockerfile) where I use multi-stage build to first package this app using Maven based image, and then run it in a lightweight, OpenJDK based Docker container.
- During deploy time, the app reads the admin account credentials and database connection properties from an [Ansible vault](https://github.com/amilovanovikj/videosonik-devops/tree/master/playbooks/vault).
- During deploy time, the [application properties](https://github.com/amilovanovikj/videosonik-backend/blob/master/src/main/resources/application.properties) are changed by Ansible to configure the app to use the production database, using [this Jinja2 template](https://github.com/amilovanovikj/videosonik-devops/blob/master/playbooks/templates/application.properties.j2).
- During deploy time, multiple containers of this app are created, alongiside a load balancer that distributes the traffic between them, using a [Docker compose file](https://github.com/amilovanovikj/videosonik-devops/blob/master/playbooks/templates/docker-compose.yml.j2).
