pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clone the Git repository
                git branch: 'main', url: 'https://github.com/VINTAZ80/bookstore-project.git'
            }
        }

        stage('Build') {
            steps {
                // Navigate to the correct subdirectory and run Maven
                dir('bookstore') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                // Navigate to the correct subdirectory for testing
                dir('bookstore') {
                    sh 'mvn test'
                }
            }
        }

        stage('Docker Build') {
            steps {
                // Build Docker image using the full path to Docker
                dir('bookstore') {
                    sh '/opt/homebrew/bin/docker build -t bookstore-app .'
                }
            }
        }

        stage('Docker Run') {
            steps {
                // Run Docker container using the full path to Docker
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
            // Stop and remove Docker container and image if they exist, using full path to Docker
            sh '/opt/homebrew/bin/docker stop bookstore-app || true'
            sh '/opt/homebrew/bin/docker rm bookstore-app || true'
            sh '/opt/homebrew/bin/docker rmi bookstore-app || true'
        }
    }
}
