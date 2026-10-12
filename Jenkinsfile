
pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Validate Project') {
            steps {
                bat 'if not exist pom.xml exit /b 1'
                bat 'if not exist Jenkinsfile exit /b 1'
                echo 'Required project files are present.'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/TEST-*.xml'

            archiveArtifacts(
                artifacts: 'target/surefire-reports/**',
                allowEmptyArchive: true
            )

            echo 'Jenkins pipeline execution completed.'
        }

        success {
            echo 'API automation tests completed successfully!'
        }

        failure {
            echo 'Build or API automation tests failed. Check the console output.'
        }
    }
}
