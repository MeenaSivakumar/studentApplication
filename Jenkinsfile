pipeline {
    agent any

    environment {
        IMAGE_NAME = 'student-app'
        IMAGE_TAG = 'latest'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/MeenaSivakumar/studentApplication.git'
            }
        }

        stage('Build with Maven') {
            steps {
                echo '🔧 Building the application...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo '🐳 Building Docker image...'
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Run Docker Container') {
            steps {
                echo '🚀 Running Docker container...'
                sh 'docker stop student-app || true'
                sh 'docker rm student-app || true'
                sh "docker run -d -p 8080:8080 --name student-app ${IMAGE_NAME}:${IMAGE_TAG}"
            }
        }
    }

    post {
        always {
            echo '🧹 Cleaning up workspace...'
            deleteDir()
        }
        success {
            echo '✅ Build and deploy successful!'
        }
        failure {
            echo '❌ Build or deploy failed.'
        }
    }
}
