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
                dir('bookstore') {  // Change to bookstore directory
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
    }

    post {
        success {
            echo 'Build and Tests completed successfully!'
        }
        failure {
            echo 'Build or Tests failed. Check the logs.'
        }
    }
}