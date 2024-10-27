pipeline {
    agent any

    environment {
        MAVEN_HOME = '/path/to/maven'  // Optional: Update Maven path if needed
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull the latest code from the GitHub repository
                git branch: 'main', url: 'https://github.com/VINTAZ80/bookstore-project.git'
            }
        }

        stage('Build') {
            steps {
                // Clean and build the project using Maven
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run unit tests using Maven
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Package the project into a JAR
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the packaged JAR to a remote server (Example using SCP)
                sh '''
                    scp target/bookstore.jar user@your-server-ip:/path/to/deploy/
                    ssh user@your-server-ip "nohup java -jar /path/to/deploy/bookstore.jar &"
                '''
            }
        }
    }

    post {
        success {
            echo 'Build, Test, Package, and Deployment completed successfully!'
        }
        failure {
            echo 'Build failed. Please check the logs.'
        }
    }
}
