alias docker-clean=' \
docker container prune -f ; \
docker image prune -f ; \
docker network prune -f ; \
docker volume prune -f '

add new user account:
adduser vabalas
usermode -aG sudo vabalas

from local machine:
ssh-copy-id vabalas@www.website.com

disable ssh password login:
vim /etc/ssh/sshd_config
PasswordAuthentication no
PermitRootLogin no
UsePAM no

also for hostinger:
vim /etc/ssh/sshd_config.d/50-cloud-init.conf

apply changes:
sudo systemctl reload ssh

firewall allow ports 22 80 and 443 only:
sudo ufw default deny incoming
sudo ufw default allow outgoing
sudo ufw allow OpenSSH
sudo ufw enable

in general, try to have everything you need in docker-compose file, build docker images with Dockerfiles that have build tools as steps instead of installing them to the machine
