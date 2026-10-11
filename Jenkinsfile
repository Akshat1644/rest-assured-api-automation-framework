
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
        always {
            junit 'target/surefire-reports/TEST-*.xml'

            archiveArtifacts(
                artifacts: 'target/surefire-reports/**',
                allowEmptyArchive: true
            )

            echo 'Pipeline execution completed.'
        }

        success {
            echo 'API automation tests completed successfully!'
        }

        failure {
            echo 'Build or API automation tests failed. Check the console output.'
        }
    }
}
