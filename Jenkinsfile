pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the main branch
                git branch: 'main', url: 'https://github.com/VINTAZ80/bookstore-project.git'
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
