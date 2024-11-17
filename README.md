http://13.210.190.187:8080/?jetsonIp=
서버 공개키:BznLqkMrxLMXLBDsqgkLxwEslBfeNZVWZQGpixdcHB8=
mobaxterm
ssh -i "capstone.pem" ec2-user@ec2-13-210-190-187.ap-southeast-2.compute.amazonaws.com
nohup java -jar web-develop-0.0.1-SNAPSHOT.jar > output.log 2>&1 &
killall java
git pull
