pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "student-app:latest"
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull the code from your GitHub repository
                git 'https://github.com/MeenaSivakumar/studentApplication.git'
            }
        }

        stage('Build') {
            steps {
                // Build the project with Maven
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                // Build Docker image
                sh 'docker build -t ${DOCKER_IMAGE} .'
            }
        }

        stage('Docker Run') {
            steps {
                // Run the Docker container
                sh 'docker run -d -p 8080:8080 --name student-app ${DOCKER_IMAGE}'
            }
        }
    }

    post {
        always {
            // Clean up Docker container after build
            sh 'docker stop student-app || true'
            sh 'docker rm student-app || true'
        }
    }
}
