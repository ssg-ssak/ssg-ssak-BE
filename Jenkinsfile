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
                    docker stop ssgpointapp || true
                    docker rm ssgpointapp || true
                    docker rmi ssgpoint_be || true
                    docker build -t ssgpoint_be_master ./master
                    docker build -t ssgpoint_be_slave ./slave
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker run -d --name ssgpointapp -p 8000:8000 -e MYSQL_ROOT_PASSWORD=1234 ssgpoint_be_master'
            }
        }
    }
}