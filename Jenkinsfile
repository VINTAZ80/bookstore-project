pipeline {
    agent any

    environment {
        PATH = "/opt/homebrew/bin:$PATH" // Ensure the PATH is set correctly
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone the Git repository
                git branch: 'main', url: 'https://github.com/VINTAZ80/bookstore-project.git'
            }
        }

        stage('Build') {
            steps {
                dir('bookstore') {
                    // Run Maven build
                    sh './mvnw clean install'
                }
            }
        }

        stage('Test') {
            steps {
                dir('bookstore') {
                    // Run tests
                    sh './mvnw test'
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('bookstore') {
                    // Use absolute path for Docker build command
                    sh '/opt/homebrew/bin/docker build -t bookstore-app .'
                }
            }
        }

        stage('Docker Run') {
            steps {
                // Run Docker container
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
            // Cleanup Docker container and image
            sh '/opt/homebrew/bin/docker stop bookstore-app || true'
            sh '/opt/homebrew/bin/docker rm bookstore-app || true'
            sh '/opt/homebrew/bin/docker rmi bookstore-app || true'
        }
    }
}
