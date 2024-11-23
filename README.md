http://13.209.45.118:8080
ssh -i "capstone.pem" ec2-user@ec2-13-209-45-118.ap-northeast-2.compute.amazonaws.com
nohup java -jar web-develop-0.0.1-SNAPSHOT.jar > output.log 2>&1 &
killall java
git pull
http://ec2-13-209-45-118.ap-northeast-2.compute.amazonaws.com:8080
ssh -i capstone.pem -R 5001:localhost:5001 ec2-user@ec2-13-209-45-118.ap-northeast-2.compute.amazonaws.com
netstat -tuln
sudo lsof -i :5001
