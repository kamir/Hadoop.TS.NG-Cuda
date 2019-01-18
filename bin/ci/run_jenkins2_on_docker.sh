cd ..
cd ..

export BASE=$(PWD)
echo $BASE

git add .
git commit -m "prep auto build"
git push

echo ****************************************
echo   READY to start Jenkins2 ...
echo ****************************************

docker run -d \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v /Users/kamir/var/jenkins_home:/var/jenkins_home \
    -p 8080:8080 \
    --name jenkins-ci-mk \
    kamir/jenkins-ci-mk:latest



#   jenkinsci/jenkins
