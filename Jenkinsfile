pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'mvn compile'   // ❌ no jar created
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'   // ❌ will fail
            }
        }

        stage('SonarQube') {
            steps {
                sh 'mvn sonar:sonar'  // ❌ no config
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t demo-app .'  // ❌ jar missing
            }
        }
    }
}