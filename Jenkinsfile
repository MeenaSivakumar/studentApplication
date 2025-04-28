pipeline {
    agent any

    stages {
        stage('Build with Maven') {
            steps {
                bat 'mvn clean install'
            }
        }
               stage('Stop and Remove Previous Container') {
                   steps {
                       script {

                           bat "docker stop student-container || true"
                           bat "docker rm student-container || true"
                       }
                   }
               }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t student-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 8083:8080 --name student-container student-app'
            }
        }
    }
}
