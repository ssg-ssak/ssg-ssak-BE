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
                    docker rmi ssgpoint_user || true
                    docker build -t ssgpoint-user .
                    echo ${MASTER_DB_URL}
                    echo $MASTER_DB_URL
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker run -e MASTER_DB_URL="${MASTER_DB_URL}" -e MASTER_DB_USERNAME="${MASTER_DB_USERNAME}" -e MASTER_DB_PASSWORD="${MASTER_DB_PASSWORD}" -e SLAVE_DB_URL="${SLAVE_DB_URL}" -e SLAVE_DB_USERNAME="${SLAVE_DB_USERNAME}" -e SLAVE_DB_PASSWORD="${SLAVE_DB_PASSWORD}" -e JWT_SECRET="${JWT_SECRET}" -d --network root_net-ssg-mysql --name ssgpointapp -p 8000:8000 ssgpoint-user'
            }
        }
    }
}