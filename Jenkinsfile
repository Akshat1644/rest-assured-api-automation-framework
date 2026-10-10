
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        success {
            echo 'API automation tests completed successfully!'
        }

        failure {
            echo 'Build or API automation tests failed. Check the console output.'
        }

        always {
            echo 'Jenkins pipeline execution completed.'
        }
    }
}
