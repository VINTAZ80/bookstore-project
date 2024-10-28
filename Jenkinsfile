pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Pull the latest code from the repository
                git 'https://github.com/VINTAZ80/bookstore-project.git'
            }
        }
        
        stage('Build') {
            steps {
                // Clean and compile the project using Maven
                sh './mvnw clean compile'
            }
        }

        stage('Test') {
            steps {
                // Run tests and fail the build if any test fails
                sh './mvnw test'
            }
        }
        
        stage('Package') {
            steps {
                // Package the application (Optional: Skip if just testing)
                sh './mvnw package'
            }
        }
    }

    post {
        // Handle build status: mark as success or failure
        success {
            echo 'Build completed successfully.'
        }
        failure {
            echo 'Build failed! Check the logs to identify test failures.'
        }
    }
}
