pipeline {
    agent any

    environment {
        PATH = "/opt/homebrew/bin:$PATH" // Ensure the PATH is set correctly
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/VINTAZ80/bookstore-project.git'
            }
        }

        stage('Build') {
            steps {
                dir('bookstore') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                dir('bookstore') {
                    sh 'mvn test'
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('bookstore') {
                    sh '/opt/homebrew/bin/docker build -t bookstore-app .'  // Use absolute path for Docker
                }
            }
        }

        stage('Docker Run') {
            steps {
                sh '/opt/homebrew/bin/docker run -d -p 8080:8080 --name bookstore-app bookstore-app'
            }
        }
    }

    post {
        success {
            echo 'Build, Tests, and Docker setup completed successfully!'
        }
        failure {
            echo 'Build, Tests, or Docker setup failed. Check the logs.'
        }
        cleanup {
            sh '/opt/homebrew/bin/docker stop bookstore-app || true'
            sh '/opt/homebrew/bin/docker rm bookstore-app || true'
            sh '/opt/homebrew/bin/docker rmi bookstore-app || true'
        }
    }
}
