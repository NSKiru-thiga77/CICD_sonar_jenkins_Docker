pipeline {
    agent any

    environment {
        IMAGE_NAME = 'nsk7docker/sonardemo-app'
        SONAR_TOKEN = credentials('sonarqube')
        SONAR_HOST_URL = 'http://184.72.134.113:9000'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/NSKiru-thiga77/CICD_sonar_jenkins_Docker.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                sh '''
                mvn sonar:sonar \
                -Dsonar.projectKey=demo \
                -Dsonar.host.url=$SONAR_HOST_URL \
                -Dsonar.login=$SONAR_TOKEN
                '''
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $IMAGE_NAME:latest .'
            }
        }

        stage('Trivy Scan') {
            steps {
                sh '''
                trivy image --exit-code 1 \
                --severity CRITICAL,HIGH \
                $IMAGE_NAME:latest
                '''
            }
        }

        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh '''
                    echo $PASS | docker login -u $USER --password-stdin
                    docker push $IMAGE_NAME:latest
                    '''
                }
            }
        }

        stage('Clean Work Space ') {
            steps {
                 {
                    cleanWs()
                }
            }
        }
    }
    
}