pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/VINTAZ80/bookstore-project.git',
                    credentialsId: 'your-credential-id' // Replace with Jenkins credential ID
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
