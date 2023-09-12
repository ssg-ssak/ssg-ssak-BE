pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh '''
                    chmod +x gradlew
                    ./gradlew build -x test
                '''
            }
        }
        stage('DockerSize') {
            steps {
                sh '''
                    docker stop ssgpoint_be_master || true
                    docker stop ssgpoint_be_slave || true
                    docker rm ssgpoint_be_master || true
                    docker rm ssgpoint_be_slave || true
                    docker rmi ssgpoint_be_master || true
                    docker rmi ssgpoint_be_slave || true
                    docker build -t ssgpoint_be_master ./master
                    docker build -t ssgpoint_be_slave ./slave
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker run -d --name ssgpoint_be_master -p 3320:3306 -e MYSQL_ROOT_PASSWORD=1234 ssgpoint_be_master'
                sh 'docker run -d --name ssgpoint_be_slave -p 3321:3306 -e MYSQL_ROOT_PASSWORD=1234 ssgpoint_be_slave'
            }
        }
    }
}