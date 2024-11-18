http://13.209.45.118:8080/?jetsonIp=
client public key: lUZ2WDvBGtWqidSAlyY/p2Opipea9OfquuOCJkzJlkQ=
mobaxterm
ssh -i "capstone.pem" ec2-user@ec2-13-209-45-118.ap-northeast-2.compute.amazonaws.com
nohup java -jar web-develop-0.0.1-SNAPSHOT.jar > output.log 2>&1 &
killall java
git pull
